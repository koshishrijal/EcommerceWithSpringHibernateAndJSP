/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.controller;

import com.koshish.java.hibernate.ecommerce.DAO.Model.PurchaseModel;
import com.koshish.java.hibernate.ecommerce.DAO.ProductDAO;
import com.koshish.java.hibernate.ecommerce.DAO.PurchaseDAO;
import com.koshish.java.hibernate.ecommerce.DAO.PurchaseDetailDAO;
import com.koshish.java.hibernate.ecommerce.DAO.PurchaseHasProductDAO;
import com.koshish.java.hibernate.ecommerce.entity.Customer;
import com.koshish.java.hibernate.ecommerce.entity.Product;
import com.koshish.java.hibernate.ecommerce.entity.Purchase;
import com.koshish.java.hibernate.ecommerce.entity.PurchaseDetail;
import com.sun.xml.ws.resources.ServerMessages;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Koshish Rijal
 */
@Controller
@RequestMapping(value = "/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseDAO purchaseDAO;
    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private PurchaseDetailDAO purchaseDetailDAO;
    @Autowired
    private PurchaseHasProductDAO purchaseHasProductDAO;
    private List<PurchaseModel> purchaseModelList;
    private List<Product> productList;
    @RequestMapping(method = RequestMethod.GET)
    public String landingPage(Model model) {
        //look this
        //making list of productModel to be shown in purchase manager
        purchaseModelList=new ArrayList<>();
        List<PurchaseDetail> details=purchaseDetailDAO.getAll();
        for(PurchaseDetail purchaseDetail:details){
         List<Product> productList=new ArrayList<>();
        PurchaseModel purchaseModel=new PurchaseModel();
        purchaseModel.setTotalPrice(purchaseDetail.getTotalPrice());
        purchaseModel.setTotalProfit(purchaseDetail.getTotalProfit());
        purchaseModel.setPurchaseDate(purchaseDetail.getPurchase().getPurchaseDate());
        purchaseModel.setCustomer(purchaseDetail.getPurchase().getCustomer());
       // productList.add(productDAO.getById(1));
    purchaseModel.setProductList(purchaseHasProductDAO.getAllProductByPurchaseId(purchaseDetail.getPurchase().getPurchaseId()));
     // purchaseModel.setProductList(productList);
   
       purchaseModelList.add(purchaseModel);
        }
        int grandtotalProfit=0;
        for(PurchaseModel pm:purchaseModelList){
            grandtotalProfit+=pm.getTotalProfit();
        }
        model.addAttribute("purchaseModelList", purchaseModelList);
        model.addAttribute("grandtotalProfit", grandtotalProfit);
        return "purchase";

    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public String insert(@ModelAttribute("purchase") Purchase purchase, HttpSession session) {
        purchase.setCustomer((Customer) session.getAttribute("customer"));
        purchase.setPurchaseDate(new Date());
        purchaseDAO.Insert(purchase);
        return "sucessfully inserted";
    }

}
