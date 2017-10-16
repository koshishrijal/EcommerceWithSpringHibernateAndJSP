/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.DAO.Model;

import com.koshish.java.hibernate.ecommerce.DAO.ProductDAO;
import com.koshish.java.hibernate.ecommerce.entity.Product;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Koshish Rijal
 */
//only product needs to passed
public class ProductInfo implements Serializable {

    private int productId;
    private String productName;
    private String categoryName;
    private int costPrice;
    private int sellPrice;
    private int profit;
    private int discount;
    private int quantityBought;

    public ProductInfo() {
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setDiscountAndProfitProductNameAndCategoryName(Product product) {
        this.productName = product.getProductName();
        this.categoryName = product.getCategory().getCategoryName();
        this.sellPrice = product.getSellPrice() * this.quantityBought;
        this.costPrice = product.getCostPrice() * this.quantityBought;
        this.profit = (this.sellPrice - this.costPrice);
        this.discount = this.profit / 50;
        this.profit = this.profit - discount;
    }

    public int getProfit() {
        return profit;
    }

    public int getQuantityBought() {
        return quantityBought;
    }

    public void setQuantityBought(int quantityBought) {
        this.quantityBought = quantityBought;
    }

    public int getDiscount() {
        return discount;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(int costPrice) {
        this.costPrice = costPrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    @Override
    public String toString() {
        return "ProductInfo{" + "productId=" + productId + ", productName=" + productName + ", costPrice=" + costPrice + ", sellPrice=" + sellPrice + '}';
    }

}
