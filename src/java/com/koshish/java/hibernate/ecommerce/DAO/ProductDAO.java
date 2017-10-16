/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.DAO;

import com.koshish.java.hibernate.ecommerce.entity.Product;
import java.util.List;

/**
 *
 * @author Koshish Rijal
 */
public interface ProductDAO {
    public List<Product> getAll();
    public Product getById(int id);
    public int insert(Product product);
    public int update(Product product);
    public int delete(int id);
    
}
