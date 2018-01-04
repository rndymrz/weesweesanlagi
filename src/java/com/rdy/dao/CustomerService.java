/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rdy.dao;

import com.rdy.model.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */

@Repository
@Transactional
public class CustomerService {
    
    @PersistenceUnit
    private EntityManagerFactory emf;
    
    //@PersistenceContext
    private EntityManager em;

    public CustomerService() {
    }

    public CustomerService(EntityManager em) {
        this.em = em;
    }
    
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    public List<Customer> findAll() {
        em = emf.createEntityManager();
        List<Customer> customers;
        customers = this.em.createNamedQuery("Customer.findAll").getResultList();
        return customers;
    }
    public Customer findById(Integer customerId) {
        return em.find(Customer.class, customerId);
    }
    
    
    
}
