/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.DAO.Model;

import com.koshish.java.hibernate.ecommerce.entity.Customer;
import com.koshish.java.hibernate.ecommerce.entity.Product;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Koshish Rijal
 */
//for model to be shown in purchase manager
public class PurchaseModel implements Serializable{
    private Date purchaseDate;
    private int totalPrice;
    private Customer customer;
    private List<Product> productList;
    private int totalProfit;

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public PurchaseModel(Date purchaseDate, int totalPrice, Customer customer, int totalProfit) {
        this.purchaseDate = purchaseDate;
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.totalProfit = totalProfit;
    }

    public void setTotalProfit(int totalProfit) {
        this.totalProfit =totalProfit;
        
        
    }

    public int getTotalProfit() {
        return totalProfit;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public PurchaseModel() {
    }

    public PurchaseModel(Date purchaseDate, int totalPrice, Customer customer, List<Product> productList) {
        this.purchaseDate = purchaseDate;
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.productList = productList;
    }
    
    
}
