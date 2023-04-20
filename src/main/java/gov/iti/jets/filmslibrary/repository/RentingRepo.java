package gov.iti.jets.filmslibrary.repository;

import gov.iti.jets.filmslibrary.dtos.rentsDtos.AllRentsDto;
import gov.iti.jets.filmslibrary.dtos.rentsDtos.RentalSetterDto;
import gov.iti.jets.filmslibrary.mappers.RentingMapper;
import gov.iti.jets.filmslibrary.model.Inventory;
import gov.iti.jets.filmslibrary.model.Rental;
import gov.iti.jets.filmslibrary.util.Rents;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentingRepo {

    RentingMapper rentingMapper;

    public  RentingRepo(){
        rentingMapper = new RentingMapper();
    }

    public List<AllRentsDto> getAllRents() {
        EntityManager entityManager = EntityFactory.getInstance().getEmf().createEntityManager();
        List<Rental> rentalList = entityManager.createQuery("From Rental ").getResultList();

        List<AllRentsDto> allRentsDtoList = new ArrayList<>();
        for(Rental rental:rentalList){
            allRentsDtoList.add(rentingMapper.toAllRents(rental));
        }

        entityManager.close();
        return allRentsDtoList;
    }

    public void rentFilm(RentalSetterDto rentalSetterDto){
        EntityManager em = EntityFactory.getInstance().getEmf().createEntityManager();
        em.getTransaction().begin();
        Rental rental = rentingMapper.toRental(rentalSetterDto);
        rental.setInventoryId(em.find(Inventory.class, rentalSetterDto.getInventoryId()));
        em.persist(rental);
        em.getTransaction().commit();
        em.close();
    }
    public void returnFilm(Integer rentalId){
        EntityManager em = EntityFactory.getInstance().getEmf().createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("update Rental r set r.returnDate = :date, r.lastUpdate = :lastUpdate where r.rentalId = :rentalId");
        q.setParameter("date", new Date());
        q.setParameter("rentalId", rentalId);
        q.setParameter("lastUpdate", new Date());
        q.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

}
