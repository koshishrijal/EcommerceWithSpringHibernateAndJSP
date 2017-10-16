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
public class CustomerInfo implements Serializable{
    private int customerId;
    private String  customerName;
    private String customerAddress;
    private String customerPhoneNumber;
    private String customerEmail;

    public CustomerInfo() {
    }

    public CustomerInfo(int customerId, String customerName, String customerAddress, String customerPhoneNumber, String customerEmail) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerEmail = customerEmail;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" + "customerId=" + customerId + ", customerName=" + customerName + ", customerAddress=" + customerAddress + ", customerPhoneNumber=" + customerPhoneNumber + ", customerEmail=" + customerEmail + '}';
    }
    
    
    
}
