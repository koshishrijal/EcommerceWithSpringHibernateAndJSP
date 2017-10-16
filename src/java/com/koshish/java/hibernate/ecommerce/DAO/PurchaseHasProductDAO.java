/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.DAO;

import com.koshish.java.hibernate.ecommerce.entity.Product;
import com.koshish.java.hibernate.ecommerce.entity.Purchase;
import java.util.List;

/**
 *
 * @author Koshish Rijal
 */
public interface PurchaseHasProductDAO {
    public int insert(int purchaseId,int productId);
    public List<Product>  getAllProductByPurchaseId(int purchaseId);
    public List<Purchase>  getAllPurchaseByProductId(int purchaseId);
    
}
