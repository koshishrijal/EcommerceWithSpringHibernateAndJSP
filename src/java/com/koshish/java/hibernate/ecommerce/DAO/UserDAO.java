/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.DAO;

import com.koshish.java.hibernate.ecommerce.entity.User;
import java.util.List;

/**
 *
 * @author Koshish Rijal
 */
public interface UserDAO {
    public List<User> getAll();
    public User getById(int id);
    public int insert(User user);
    public int update(User user);
    public int delete(int id);
}
