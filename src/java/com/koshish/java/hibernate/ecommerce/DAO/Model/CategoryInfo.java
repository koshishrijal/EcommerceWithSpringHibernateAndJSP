/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.DAO.Model;

import java.io.Serializable;

/**
 *
 * @author Koshish Rijal
 */
public class CategoryInfo implements Serializable{
    private int categoryId;
    private String categoryName;

    public CategoryInfo() {
    }

    public CategoryInfo(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryInfo{" + "categoryId=" + categoryId + ", categoryName=" + categoryName + '}';
    }
    
    
}
