/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.controller;

import com.koshish.java.hibernate.ecommerce.DAO.CustomerDAO;
import com.koshish.java.hibernate.ecommerce.DAO.Model.ProductInfo;
import com.koshish.java.hibernate.ecommerce.DAO.Model.PurchaseDetailInfo;
import com.koshish.java.hibernate.ecommerce.DAO.PurchaseDAO;
import com.koshish.java.hibernate.ecommerce.DAO.PurchaseDetailDAO;
import com.koshish.java.hibernate.ecommerce.DAO.PurchaseHasProductDAO;
import com.koshish.java.hibernate.ecommerce.entity.Customer;
import com.koshish.java.hibernate.ecommerce.entity.Purchase;
import com.koshish.java.hibernate.ecommerce.entity.PurchaseDetail;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Koshish Rijal
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerAndPurchaseController {

    @Autowired
    private CustomerDAO customerDAO;
  @Autowired
  private PurchaseDAO purchaseDAO;
   @Autowired 
   
    private PurchaseDetailDAO purchaseDetailDAO;
   @Autowired
   PurchaseHasProductDAO purchaseHasProductDAO;
   
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView landingPage(){
        ModelAndView modelAndView=new ModelAndView("customer");
        modelAndView.addObject("customerList",customerDAO.getAll());
        return modelAndView;
    }
    @RequestMapping(value="/insert",method=RequestMethod.POST)
    //along with cuatomer informations the paytype are also received at the same time
    public String insert(@ModelAttribute("customer") Customer customer,@ModelAttribute("purchase") Purchase purchase,HttpSession session){
        customerDAO.insert(customer);
        session.setAttribute("customer", customer);
        purchase.setCustomer(customer);
        List<ProductInfo> productInfoList=(List<ProductInfo>)session.getAttribute("productInfoList");
        purchase.setPurchaseDate(new Date());
        int id=purchaseDAO.Insert(purchase);
        PurchaseDetailInfo purchaseDetailInfo =new PurchaseDetailInfo((List<ProductInfo>) session.getAttribute("productInfoList"), customer.getCustomerId());
        PurchaseDetail purchasedetail=new PurchaseDetail(purchaseDetailInfo.getTotalPrice(), purchaseDetailInfo.getTotalDiscount(),purchaseDAO.getById(id),purchaseDetailInfo.getTotalProfit());
        purchaseDetailDAO.insert(purchasedetail);
        for(ProductInfo productInfo:productInfoList){
            purchaseHasProductDAO.insert(id,productInfo.getProductId());
        }
        return "redirect:/client";
    }
   
    
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    public String delete(@RequestParam("id")int id,Model model){
        int result=customerDAO.delete(id);
        if(result==0){
           model.addAttribute("error","cannot be deleted as child is present");
            return "redirect:/customer";
            
        }
        return "redirect:/customer";
    }
    
    @RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id")int id){
      ModelAndView modelAndView=new ModelAndView("customeredit");
      modelAndView.addObject("customer",customerDAO.getById(id));
      return modelAndView;
    }
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public String update(@ModelAttribute("customer") Customer customer){
        customerDAO.update(customer);
        return "successfully updated";
    }
    
}
