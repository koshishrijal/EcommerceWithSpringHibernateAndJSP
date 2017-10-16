/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.DAO.impl;

import com.koshish.java.hibernate.ecommerce.DAO.ProductDAO;
import com.koshish.java.hibernate.ecommerce.DAO.PurchaseHasProductDAO;
import com.koshish.java.hibernate.ecommerce.entity.Product;
import com.koshish.java.hibernate.ecommerce.entity.Purchase;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Koshish Rijal
 */
@Repository("purchaseHasProductDAO")
public class PurchaseHasProductDAOImpl implements PurchaseHasProductDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    private List<Product> productList;
    private List<Purchase> purchaseList;
    @Autowired
    private ProductDAO productDAO;

    @Override
    public int insert(int purchaseId, int productId) {
        session = sessionFactory.openSession();

        String sql = "INSERT INTO `ecommerce`.`purchase_has_product` (`purchase_id`, `product_id`) VALUES (:purchaseId,:productId);";
        Query query = session.createSQLQuery(sql);
        query.setParameter("purchaseId", purchaseId);
        query.setParameter("productId", productId);
        query.executeUpdate();
        session.close();
        return 1;

    }
//this method uses native sql from hibernate for more see tutorilas point hiberntae native sql

    @Override
    public List<Product> getAllProductByPurchaseId(int purchaseId) {
        session = sessionFactory.openSession();
        String sql = "SELECT * FROM `purchase_has_product` WHERE purchase_id=:purchaseId";
        Query query = session.createSQLQuery(sql);
        query.setParameter("purchaseId", purchaseId);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List result = query.list();
       session.close();
         productList=new ArrayList<>();
        for (Object object : result) {
          
            Map row = (Map) object;
            int productId = (int) row.get("product_id");
            //Product product = productDAO.getById(1);
            Product product=new Product();
            product=productDAO.getById(productId);
            productList.add(product);
        }
           //session.close();
        return productList;
    }

    @Override
    public List<Purchase> getAllPurchaseByProductId(int purchaseId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
