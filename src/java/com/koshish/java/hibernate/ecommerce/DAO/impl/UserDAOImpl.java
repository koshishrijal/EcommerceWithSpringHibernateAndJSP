/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.DAO.impl;

import com.koshish.java.hibernate.ecommerce.DAO.UserDAO;
import com.koshish.java.hibernate.ecommerce.entity.User;
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
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    private List<User> userList;

    @Override
    public List<User> getAll() {
        session = sessionFactory.openSession();
        userList = session.createQuery("from User ").list();
        session.close();
        return userList;

    }

    @Override
    public User getById(int id) {
        session = sessionFactory.openSession();
        User user = (User) session.get(User.class, id);
        return user;
    }

    @Override
    public int insert(User user) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        int rslt = (int) session.save(user);
        transaction.commit();
        return rslt;
    }

    @Override
    public int update(User user) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
        return user.getUserId();
    }

    @Override
    public int delete(int id) {
        User user=getById(id);
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
        return id;
        
    }

}
