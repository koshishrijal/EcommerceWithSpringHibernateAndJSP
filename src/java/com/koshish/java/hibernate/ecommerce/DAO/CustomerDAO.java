/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.DAO;

import com.koshish.java.hibernate.ecommerce.entity.Customer;
import java.util.List;

/**
 *
 * @author Koshish Rijal
 */
public interface CustomerDAO {
    public List<Customer> getAll();
    public Customer getById(int id);
    public int insert(Customer customer);
    public int update(Customer customer);
    public int delete(int id);
    
}
