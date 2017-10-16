/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.DAO;

import com.koshish.java.hibernate.ecommerce.entity.PurchaseDetail;
import java.util.List;

/**
 *
 * @author Koshish Rijal
 */
public interface PurchaseDetailDAO {
    public List<PurchaseDetail> getAll();
    public PurchaseDetail getById(int id);
    public int insert(PurchaseDetail purchaseDetail);
    
}
