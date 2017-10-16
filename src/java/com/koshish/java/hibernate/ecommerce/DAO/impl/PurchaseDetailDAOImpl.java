/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.DAO.impl;

import com.koshish.java.hibernate.ecommerce.DAO.PurchaseDetailDAO;
import com.koshish.java.hibernate.ecommerce.entity.PurchaseDetail;
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
@Repository("purchaseDetailDAO")
public class PurchaseDetailDAOImpl implements PurchaseDetailDAO{
@Autowired 
 private SessionFactory sessionFactory;
private Session session;
private Transaction transaction;
private List<PurchaseDetail> purchaseDetailList;
    @Override
    public List<PurchaseDetail> getAll() {
     session=sessionFactory.openSession();
     purchaseDetailList=session.createQuery("from PurchaseDetail").list();
     session.close();
     return purchaseDetailList;
     
    }

    @Override
    public PurchaseDetail getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(PurchaseDetail purchaseDetail) {
      session=sessionFactory.openSession();
      transaction=session.beginTransaction();
      session.save(purchaseDetail);
      transaction.commit();
      session.close();
        return 1;
    }
    
}
