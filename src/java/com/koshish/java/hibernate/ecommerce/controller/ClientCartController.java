/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.controller;

import com.koshish.java.hibernate.ecommerce.DAO.CategoryDAO;
import com.koshish.java.hibernate.ecommerce.DAO.Model.ProductInfo;
import com.koshish.java.hibernate.ecommerce.DAO.Model.PurchaseDetailInfo;
import com.koshish.java.hibernate.ecommerce.DAO.ProductDAO;
import com.koshish.java.hibernate.ecommerce.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Koshish Rijal
 */
@Controller
@RequestMapping(value = "/client")
public class ClientCartController {

    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private CategoryDAO categoryDAO;
   @Autowired
    private ServletContext servletContext;

    
    @RequestMapping(method = RequestMethod.GET)
    public String landingPage(Model model,HttpSession session) {
        model.addAttribute("categoryList", categoryDAO.getAll());
        int hits=1;
        if(servletContext.getAttribute("hits")!=null){
              hits=(int) servletContext.getAttribute("hits");
              if(session.isNew()){
                  hits=(int) servletContext.getAttribute("hits")+1;
              }
        servletContext.setAttribute("hits",hits);
        }
          servletContext.setAttribute("hits",hits);
        return "client";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addInCart(@ModelAttribute("productInfo") ProductInfo productInfo, HttpSession session) {
        //note and research that getby id of product didnt worked while created in model class productInfo
        //after passing product from only controller part this worked
        Product product = productDAO.getById(productInfo.getProductId());
        productInfo.setDiscountAndProfitProductNameAndCategoryName(product);
        if (session.getAttribute("productInfoList") == null) {
            List<ProductInfo> productInfoList = new ArrayList<>();
            productInfoList.add(productInfo);
            PurchaseDetailInfo pdi=new PurchaseDetailInfo(productInfoList);
            session.setAttribute("purchaseDetailInfo",pdi);
            session.setAttribute("productInfoList", productInfoList);

            return "shoppingcart";
        } else {
            List<ProductInfo> productInfoList = (List<ProductInfo>) session.getAttribute("productInfoList");

            productInfoList.add(productInfo);
            PurchaseDetailInfo pdi=(PurchaseDetailInfo) session.getAttribute("purchaseDetailInfo");
            pdi.setProductInfoList(productInfoList);
            session.setAttribute("purchaseDetailInfo",pdi);
            session.setAttribute("productInfoList", productInfoList);
            return "shoppingcart";
        }
    }

    @RequestMapping(value = "/continue", method = RequestMethod.GET)
    public String continueShopping() {
        return "redirect:/client";
    }

}
