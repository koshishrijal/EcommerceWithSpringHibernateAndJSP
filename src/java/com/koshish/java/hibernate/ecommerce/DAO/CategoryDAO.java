/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.DAO;

import com.koshish.java.hibernate.ecommerce.entity.Category;
import java.util.List;

/**
 *
 * @author Koshish Rijal
 */
public interface CategoryDAO {
    public List<Category> getAll();
    public Category getById(int id);
    public int delete(int id);
    public int update(Category category);
    public int insert(Category category);
    
}
