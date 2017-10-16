/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.DAO.impl;

import com.koshish.java.hibernate.ecommerce.DAO.CustomerDAO;
import com.koshish.java.hibernate.ecommerce.entity.Customer;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Koshish Rijal
 */
@Repository("customerDAO")
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private Transaction transaction;
    private Session session;
    private List<Customer> customerList;

    @Override
    public List<Customer> getAll() {
        session = sessionFactory.openSession();
        customerList = session.createQuery("From Customer c").list();
        session.close();
        return customerList;
    }

    @Override
    public Customer getById(int id) {
        session = sessionFactory.openSession();
       Customer customer=(Customer) session.get(Customer.class, id);
        session.close();
        return customer;
    }

    @Override
    public int insert(Customer customer) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        int result = (int) session.save(customer);
        transaction.commit();
        session.close();
        return result;
    }

    @Override
    public int update(Customer customer) {
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
       session.update(customer);
        transaction.commit();
        session.close();
        return 1;
    }

    @Override
    public int delete(int id) {
        Customer customer=getById(id);
        if(!customer.getPurchaseList().isEmpty()){
            return 0;
        }
       session=sessionFactory.openSession();
       transaction=session.beginTransaction();
       session.delete(customer);
       transaction.commit();
       session.close();
       return 1;
        
        
    }

}
