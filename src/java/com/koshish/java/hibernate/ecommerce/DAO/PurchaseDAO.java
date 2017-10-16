/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.DAO;

import com.koshish.java.hibernate.ecommerce.entity.Purchase;
import java.util.List;

/**
 *
 * @author Koshish Rijal
 */
public interface PurchaseDAO {
    public List<Purchase> getAll();
    public int Insert(Purchase purchase);
    public int  delete(int id);
    public Purchase getById(int id);
    public int  update(Purchase purchase);
}
