package gov.iti.jets.filmslibrary.repository;

import gov.iti.jets.filmslibrary.dtos.filmDtos.FilmFilterDto;
import gov.iti.jets.filmslibrary.dtos.filmDtos.FilmGetterDto;
import gov.iti.jets.filmslibrary.dtos.filmDtos.FilmSetterDto;
import gov.iti.jets.filmslibrary.dtos.filmDtos.EmbeddedInventoryDto;
import gov.iti.jets.filmslibrary.mappers.FilmMapper;
import gov.iti.jets.filmslibrary.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilmRepo {
   FilmMapper filmMapper;

   public FilmRepo() {
       filmMapper = new FilmMapper();
   }

   public List<FilmGetterDto> filterFilms(FilmFilterDto filmFilterDto) {
       EntityManager em = EntityFactory.getEmf().createEntityManager();
       Query query = em.createQuery("select f from FilmList f where f.fid = coalesce(?1, f.fid)" +
               "and f.category = coalesce(?2, f.category) " +
               "and f.language = coalesce(?3, f.language) " +
               "and f.replacementCost between coalesce(?4, f.replacementCost) and coalesce(?5, f.replacementCost)" +
               "and f.rating = coalesce(?6, f.rating)" +
               "and f.releaseYear = coalesce(?7, f.releaseYear) " +
               "and f.title = coalesce(?8, f.title) " +
               "and f.rentalRate between coalesce(?9, f.rentalRate) and coalesce(?10, f.rentalRate)");
       query.setParameter(1, filmFilterDto.getFid());
       query.setParameter(2, filmFilterDto.getCategory());
       query.setParameter(3, filmFilterDto.getLanguage());
       query.setParameter(4, filmFilterDto.getMinReplacementCost());
       query.setParameter(5, filmFilterDto.getMaxReplacementCost());
       query.setParameter(6, filmFilterDto.getRate());
       query.setParameter(7, filmFilterDto.getReleaseYear());
       query.setParameter(8, filmFilterDto.getTitle());
       query.setParameter(9, filmFilterDto.getMinRentalRate());
       query.setParameter(10, filmFilterDto.getMaxRentalRate());

       List<FilmGetterDto> filmGetterDtoList = new ArrayList<>();
       for (FilmList film : (List<FilmList>) query.getResultList()) {
           filmGetterDtoList.add(filmMapper.toGetterDto(film));
       }
       em.close();
       return filmGetterDtoList;

   }


   public List<FilmGetterDto> getAllFilms() {
       EntityManager entityManager = EntityFactory.getEmf().createEntityManager();
       Query query = entityManager.createQuery("From FilmList");
       List<FilmGetterDto> filmGetterDtoList = new ArrayList<>();
       for (FilmList film : (List<FilmList>) query.getResultList()) {
           filmGetterDtoList.add(filmMapper.toGetterDto(film));
       }
       entityManager.close();
       return filmGetterDtoList;

   }

   public boolean addFilm(FilmSetterDto filmSetterDto) {
       EntityManager entityManager = EntityFactory.getEmf().createEntityManager();

       entityManager.getTransaction().begin();

       Film film = filmMapper.toFilmEntity(filmSetterDto);

       //ADD LANGUAGE AND ORIGINAL LANGUAGE TO FILM
       film.setLanguageId(entityManager.find(Language.class, filmSetterDto.getLanguageId()));
       if (filmSetterDto.getOriginalLanguageId() != null) {
           film.setOriginalLanguageId(entityManager.find(Language.class, filmSetterDto.getLanguageId()));
       }

       entityManager.persist(film);


       //ADD FILM AND STORE TO INVENTORY
       for (EmbeddedInventoryDto embeddedInventoryDto : filmSetterDto.getInventoryList()) {
           Inventory inventory = new Inventory();
           inventory.setFilmId(film);
           inventory.setLastUpdate(new Date());
           inventory.setStoreId(entityManager.find(Store.class, embeddedInventoryDto.getStoreId()));
           entityManager.persist(inventory);
       }


       //ADD CATEGORY TO FILM
       FilmCategoryPK filmCategoryPK = new FilmCategoryPK();
       filmCategoryPK.setCategoryId(filmSetterDto.getCategory());
       filmCategoryPK.setFilmId(film.getFilmId());

       FilmCategory filmCategory = new FilmCategory();
       filmCategory.setFilm(film);
       filmCategory.setFilmCategoryPK(filmCategoryPK);
       filmCategory.setCategory(entityManager.find(Category.class, filmSetterDto.getCategory()));
       filmCategory.setLastUpdate(new Date());

       entityManager.persist(filmCategory);
       entityManager.getTransaction().commit();
       entityManager.close();

       //ADD ACTORS TO FILM
       for (Short actor : filmSetterDto.getActors()) {
           new ActorFilmsRepo().addExistingFilmToAnExistingActor(film.getFilmId(), actor);
       }

       return true;
   }


   public boolean updateFilm(FilmSetterDto filmSetterDto) {

       Film film = filmMapper.toFilmEntity(filmSetterDto);
       film.setFilmId(filmSetterDto.getFilmId());

       EntityManager entityManager = EntityFactory.getEmf().createEntityManager();
       entityManager.getTransaction().begin();

       //UPDATE LANGUAGE AND ORIGINAL LANGUAGE TO FILM
       film.setLanguageId(entityManager.find(Language.class, filmSetterDto.getLanguageId()));
       if (filmSetterDto.getOriginalLanguageId() != null) {
           film.setOriginalLanguageId(entityManager.find(Language.class, filmSetterDto.getLanguageId()));
       }
       entityManager.merge(film);

       //UPDATE FILM AND STORE AT INVENTORY
       for (EmbeddedInventoryDto embeddedInventoryDto : filmSetterDto.getInventoryList()) {
           Query query = entityManager.createQuery("update Inventory i set i.storeId.storeId = :storeId where  i.inventoryId = :inventoryId");
           query.setParameter("storeId", embeddedInventoryDto.getStoreId());
           query.setParameter("inventoryId", embeddedInventoryDto.getInventoryId());
           query.executeUpdate();
       }

       //UPDATE FILM CATEGORY
       Query query = entityManager.createQuery("update FilmCategory f set f.id.categoryId = :categoryId");
       query.setParameter("categoryId",filmSetterDto.getCategory() );
       query.executeUpdate();


       //UPDATE FILM ACTORS
       Query q = entityManager.createQuery("from FilmActor f where f.id.filmId = :filmId");
       q.setParameter("filmId", film.getFilmId());
       List<FilmActor> filmActorList = q.getResultList();
       entityManager.getTransaction().commit();
       entityManager.close();

       for (FilmActor filmActor: filmActorList){
           new ActorFilmsRepo().removeFilmOfAnActor(film.getFilmId(), filmActor.getFilmActorPK().getActorId());
       }

       for(Short actor: filmSetterDto.getActors()) {
           new ActorFilmsRepo().addExistingFilmToAnExistingActor(film.getFilmId(), actor);
       }

       return true;
   }


   public boolean removeFilm(short id) {
       EntityManager entityManager = EntityFactory.getEmf().createEntityManager();
       entityManager.getTransaction().begin();


      Query query = entityManager.createQuery("delete from FilmText f where f.filmId = :id");
       query.setParameter("id", id);
       query.executeUpdate();

       query = entityManager.createQuery("delete from Film a where a.filmId = :id");
       query.setParameter("id", id);
       query.executeUpdate();


       entityManager.getTransaction().commit();
       entityManager.close();
       return true;

   }
}
