package gov.iti.jets.filmslibrary.repository;

import gov.iti.jets.filmslibrary.dtos.CustomerSetterDto;
import gov.iti.jets.filmslibrary.mappers.CustomerMapper;
import gov.iti.jets.filmslibrary.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerRepo {

    CustomerMapper customerMapper;

    public CustomerRepo() {
        customerMapper = new CustomerMapper();
    }

    public List<CustomerList> filterCustomers(Short id, String name, String phone, String country, String city, String email) {
        EntityManager em = EntityFactory.emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CustomerList> q = cb.createQuery(CustomerList.class);
        Root<CustomerList> customer = q.from(CustomerList.class);

        Predicate predicate = null;
        boolean filtered = false;

        if (country != null) {
            filtered = true;
            predicate = cb.and(cb.equal(customer.get("country"), country));
        }

        if (city != null) {
            filtered = true;
            predicate = cb.and(cb.equal(customer.get("city"), city));
        }

        if (email != null) {
            filtered = true;
            predicate = cb.and(cb.equal(cb.lower(customer.get("email")), email.toLowerCase()));
        }

        if (id != null) {
            filtered = true;
            predicate = cb.and(cb.equal(customer.get("id"), id));
        }

        if (phone != null) {
            filtered = true;
            predicate = cb.and(cb.equal(customer.get("phone"), phone));
        }

        if (name != null) {
            filtered = true;
            predicate = cb.and(cb.equal(cb.lower(customer.get("name")), name.toLowerCase()));
        }

        if (filtered)
            q.select(customer).where(predicate);
        else
            q.select(customer);

        List<CustomerList> customerList = em.createQuery(q).getResultList();
        em.close();
        return customerList;

    }


    public List<CustomerList> getAllCustomers() {
        EntityManager entityManager = EntityFactory.emf.createEntityManager();
        Query query = entityManager.createQuery("From CustomerList ");
        List<CustomerList> customerLists = query.getResultList();
        entityManager.close();
        return customerLists;
    }

    public boolean addCustomer(CustomerSetterDto customerSetterDto) {
        EntityManager entityManager = EntityFactory.emf.createEntityManager();

        entityManager.getTransaction().begin();

        Country country = entityManager.find(Country.class, customerSetterDto.getCountry());
        Query q = entityManager.createQuery("From City where city = :city");
        q.setParameter("city", customerSetterDto.getCity());

        Address address = customerMapper.createAddress(customerSetterDto);

        City city = null;
        try {
            city = (City) q.getSingleResult();
            if (city != null) {
                city.setLastUpdate(new Date());
                address.setCityId(city);
            }
        } catch (NoResultException e) {
            city = new City();
            city.setCity(customerSetterDto.getCity());
            city.setLastUpdate(new Date());
            city.setCountryId(country);
            entityManager.persist(city);
            address.setCityId(city);
        }

        Customer customer = customerMapper.toCustomerEntity(customerSetterDto);
        customer.setStoreId(entityManager.find(Store.class, customerSetterDto.getStoreId()));
        customer.setAddressId(address);

        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);
        address.setCustomerList(customerList);

        entityManager.persist(address);
        entityManager.persist(customer);

        entityManager.getTransaction().commit();
        entityManager.close();

        return true;
    }


    public boolean updateCustomer(CustomerSetterDto customerSetterDto) {

        Address address = customerMapper.createAddress(customerSetterDto);

        EntityManager entityManager = EntityFactory.emf.createEntityManager();
        entityManager.getTransaction().begin();

        Country country = entityManager.find(Country.class, customerSetterDto.getCountry());
        Customer customer = entityManager.find(Customer.class, customerSetterDto.getId());

        City city = customer.getAddressId().getCityId();
        city.setLastUpdate(new Date());
        city.setCity(customerSetterDto.getCity());
        city.setCountryId(country);
        entityManager.merge(city);

        address.setCityId(city);
        address.setAddressId(customer.getAddressId().getAddressId());
        entityManager.merge(address);

        customer.setLastUpdate(new Date());
        customer.setEmail(customerSetterDto.getEmail());
        customer.setLastName(customerSetterDto.getLastName());
        customer.setFirstName(customerSetterDto.getFirstName());
        customer.setActive(customerSetterDto.isActive());
        customer.setStoreId(entityManager.find(Store.class, customerSetterDto.getStoreId()));
        entityManager.merge(customer);

        entityManager.getTransaction().commit();
        entityManager.close();

        return true;
    }


    public boolean removeCustomer(short id) {
        EntityManager entityManager = EntityFactory.emf.createEntityManager();
        entityManager.getTransaction().begin();

        Customer customer = entityManager.find(Customer.class, id);

        Query query = entityManager.createQuery("delete from Address a where a.id = :addressId");
        query.setParameter("addressId", customer.getAddressId().getAddressId());
        query.executeUpdate();

        entityManager.remove(customer);

        entityManager.getTransaction().commit();
        entityManager.close();
        return true;

    }
}
