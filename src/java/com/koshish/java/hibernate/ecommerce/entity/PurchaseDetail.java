/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Koshish Rijal
 */
@Entity
@Table(name = "tbl_purchasedetail", catalog = "ecommerce", schema = "")
@NamedQueries({
    @NamedQuery(name = "PurchaseDetail.findAll", query = "SELECT p FROM PurchaseDetail p")})
public class PurchaseDetail implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_profit")
    private int totalProfit;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "purchasedetail_id")
    private Integer purchasedetailId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_price")
    private int totalPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "discount")
    private int discount;
    @JoinColumn(name = "purchase_id", referencedColumnName = "purchase_id")
    @ManyToOne(optional = false)
    private Purchase purchase;

    public PurchaseDetail() {
    }

    public PurchaseDetail(int totalPrice, int discount, Purchase purchase,int totalProfit ) {
        this.totalProfit = totalProfit;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.purchase = purchase;
    }

    public PurchaseDetail(Integer purchasedetailId) {
        this.purchasedetailId = purchasedetailId;
    }

    public PurchaseDetail(Integer purchasedetailId, int totalPrice, int discount) {
        this.purchasedetailId = purchasedetailId;
        this.totalPrice = totalPrice;
        this.discount = discount;
    }

    public PurchaseDetail(int totalPrice, int discount, Purchase purchase) {
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.purchase = purchase;
    }

    public Integer getPurchasedetailId() {
        return purchasedetailId;
    }

    public void setPurchasedetailId(Integer purchasedetailId) {
        this.purchasedetailId = purchasedetailId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purchasedetailId != null ? purchasedetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseDetail)) {
            return false;
        }
        PurchaseDetail other = (PurchaseDetail) object;
        if ((this.purchasedetailId == null && other.purchasedetailId != null) || (this.purchasedetailId != null && !this.purchasedetailId.equals(other.purchasedetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.koshish.java.hibernate.ecommerce.entity.PurchaseDetail[ purchasedetailId=" + purchasedetailId + " ]";
    }

    public int getTotalProfit() {
        return this.totalProfit;
    }

    public void setTotalProfit(int totalProfit) {
        this.totalProfit = totalProfit;
    }
    
}
