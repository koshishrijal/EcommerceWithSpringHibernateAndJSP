/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.DAO.impl;

import com.koshish.java.hibernate.ecommerce.DAO.ProductDAO;
import com.koshish.java.hibernate.ecommerce.entity.Product;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Koshish Rijal
 */
@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private Transaction transaction;
    private Session session;
    private List<Product> productList;

    @Override
    public List<Product> getAll() {
        session = sessionFactory.openSession();
        productList = session.createQuery(" from Product").list();
        session.close();
        return productList;
    }

    @Override
    public Product getById(int id) {
        session = sessionFactory.openSession();
        Product product = (Product) session.get(Product.class, id);
        session.close();
        return product;

    }

    @Override
    public int insert(Product product) {
        /*Save/update/delete are transactional operations.So to execute those operations, there is need to begin transaction with

         session.beginTransaction();
         and then only we can execute save/update/delete. Hibernate provides good quality of transaction rollback mechanism. Hibernate makes changes to database only if transaction is committed through

         session.getTransaction().commit();*/
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();
        session.close();
        return 1;
    }

    @Override
    public int update(Product product) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.update(product);

        transaction.commit();
        session.close();
        return 1;
    }

    @Override
    public int delete(int id) {
        Product product = getById(id);
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.delete(product);
        transaction.commit();
        session.close();
        return 1;

    }

}
