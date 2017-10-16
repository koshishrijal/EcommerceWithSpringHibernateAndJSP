/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.DAO.Model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Koshish Rijal
 */
public class PurchaseDetailInfo implements Serializable{
    private List<ProductInfo> productInfoList;
    private int customerId;
    //lokking from buyer side
    private int totalDiscount;
    //lokking from buyer side
    private int totalPrice;
   private int totalProfit;

    public PurchaseDetailInfo(List<ProductInfo> productInfoList, int customerId, int totalDiscount, int totalPrice, int totalProfit) {
        this.productInfoList = productInfoList;
        this.customerId = customerId;
        this.totalDiscount = totalDiscount;
        this.totalPrice = totalPrice;
        this.totalProfit = totalProfit;
    }

    public int getTotalProfit() {
        return totalProfit;
    }
//at last set the totalProfit
    public void setTotalProfit() {
        this.totalProfit = 0;
        for(ProductInfo pI:this.productInfoList){
            this.totalProfit+=pI.getProfit();
        }
        
    }
   
    public PurchaseDetailInfo(List<ProductInfo> productInfoList, int customerId) {
        this.productInfoList = productInfoList;
        this.customerId = customerId;
        this.totalDiscount=calculateTotalDiscount(productInfoList);
        this.totalPrice=calculateTotalPrice(productInfoList);
         for(ProductInfo pI:this.productInfoList){
            this.totalProfit+=pI.getProfit();
        }
    }
    public PurchaseDetailInfo(List<ProductInfo> productInfoList) {
        this.productInfoList = productInfoList;
        this.totalDiscount=calculateTotalDiscount(productInfoList);
        this.totalPrice=calculateTotalPrice(productInfoList);
         
        for(ProductInfo pI:this.productInfoList){
            this.totalProfit+=pI.getProfit();
        }
        
    }
private int calculateTotalDiscount(List<ProductInfo> productInfoList){
    int temp=0;
    for(ProductInfo pI:productInfoList){
        temp+=pI.getDiscount();
    }
    return temp;
}
private int calculateTotalPrice(List<ProductInfo> productInfoList){
     int temp=0;
    for(ProductInfo pI:productInfoList){
        temp+=pI.getSellPrice();
    }
    return temp;
}
   
    public PurchaseDetailInfo() {
    }

    public List<ProductInfo> getProductInfoList() {
        return productInfoList;
    }

    public void setProductInfoList(List<ProductInfo> productInfoList) {
        this.productInfoList = productInfoList;
          this.totalDiscount=calculateTotalDiscount(productInfoList);
        this.totalPrice=calculateTotalPrice(productInfoList);
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(int totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    
}
