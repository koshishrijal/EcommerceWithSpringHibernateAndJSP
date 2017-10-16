/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.DAO.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Koshish Rijal
 */
public class PurchaseInfo implements Serializable{
    private int purchaseId;
    private Date purchaseDate;
    private int totalPrice;
    private int totalDiscount;
    private int totalProfit;
    
    public PurchaseInfo() {
    }

    public PurchaseInfo(int purchaseId, Date purchaseDate) {
        this.purchaseId = purchaseId;
        this.purchaseDate = purchaseDate;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPriceDiscountAndProfit(List<ProductInfo> productInfoList) {
        totalPrice=0;
        totalDiscount=0;
       for( ProductInfo productInfo:productInfoList){
           totalPrice+=productInfo.getSellPrice();
           totalDiscount+=productInfo.getDiscount();
           totalProfit+=productInfo.getProfit();
       }
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }

    public int getTotalProfit() {
        return totalProfit;
    }

   

    @Override
    public String toString() {
        return "PurchaseInfo{" + "purchaseId=" + purchaseId + ", purchaseDate=" + purchaseDate + ", totalPrice=" + totalPrice + ", totalDiscount=" + totalDiscount + '}';
    }
    
   
}
