/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.DAO.impl;

import com.koshish.java.hibernate.ecommerce.DAO.CategoryDAO;
import com.koshish.java.hibernate.ecommerce.entity.Category;
import java.util.List;
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
@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Override
    public List<Category> getAll() {
        session = sessionFactory.openSession();
        List<Category> categoryList = session.createQuery("from Category").list();
        session.close();
        return categoryList;
    }

    @Override
    public Category getById(int id) {
        session = sessionFactory.openSession();
        Category category = (Category) session.get(Category.class, id);
        session.close();
        return category;
    }

    @Override
    public int delete(int id) {
        Category category = getById(id);
        if (!category.getProductList().isEmpty()) {
            return 0;
        }
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.delete(category);
        transaction.commit();
        session.close();
        return 1;
    }

    @Override
    public int update(Category category) {
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
        session.update(category);
        transaction.commit();
        session.close();
        return 1;
    }

    @Override
    public int insert(Category category) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.save(category);
        transaction.commit();
        session.close();
        return 1;

    }

}
