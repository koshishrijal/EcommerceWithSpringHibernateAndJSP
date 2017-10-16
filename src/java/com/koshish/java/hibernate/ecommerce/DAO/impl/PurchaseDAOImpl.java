/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.DAO.impl;

import com.koshish.java.hibernate.ecommerce.DAO.PurchaseDAO;
import com.koshish.java.hibernate.ecommerce.entity.Purchase;
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
@Repository("purchaseDAO")
public class PurchaseDAOImpl implements PurchaseDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Override
    public List<Purchase> getAll() {
        session = sessionFactory.openSession();
        List<Purchase> purchaseList = session.createQuery("FROM Purchase").list();
        session.close();
        return purchaseList;
    }

    @Override
    public int Insert(Purchase purchase) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        int rslt = (int) session.save(purchase);
        transaction.commit();
        session.close();
        return rslt;

    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Purchase getById(int id) {
        session = sessionFactory.openSession();
        Purchase purchase = (Purchase) session.get(Purchase.class, id);
        session.close();
        return purchase;
    }

    @Override
    public int update(Purchase purchase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
