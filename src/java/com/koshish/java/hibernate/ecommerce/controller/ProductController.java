/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.controller;

import com.koshish.java.hibernate.ecommerce.DAO.CategoryDAO;
import com.koshish.java.hibernate.ecommerce.DAO.ProductDAO;
import com.koshish.java.hibernate.ecommerce.DAO.PurchaseDetailDAO;
import com.koshish.java.hibernate.ecommerce.DAO.UserDAO;
import com.koshish.java.hibernate.ecommerce.entity.Category;
import com.koshish.java.hibernate.ecommerce.entity.Product;
import com.koshish.java.hibernate.ecommerce.entity.PurchaseDetail;
import com.koshish.java.hibernate.ecommerce.entity.User;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
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

/**
 *
 * @author Koshish Rijal
 */
//default controller in this
@Controller
@RequestMapping(value = "/")
public class ProductController {

    @Autowired
    private ProductDAO productDAO;
      @Autowired
    private PurchaseDetailDAO purchaseDetailDAO;
    @Autowired
    private CategoryDAO categoryDAO;
  @Autowired
  private UserDAO userDAO;
  
    @RequestMapping(method=RequestMethod.GET)
      private String login(Model model){
        return "login";
    }
    
    
    @RequestMapping(method = RequestMethod.POST,value="/index")
    public ModelAndView index(@ModelAttribute("user")User user) {
       boolean isLoggedIn=false;
        for(User u:userDAO.getAll()){
            if(u.equals(user)){
              isLoggedIn=true;  
            }
            
        }
        
          if(!isLoggedIn){
              ModelAndView modelAndView = new ModelAndView("login");
              modelAndView.addObject("message","incorrect login please try again");
              return modelAndView;
          }    
        ModelAndView modelAndView = new ModelAndView("index");
        int totalProfitTillDate=0;
        int totalProfitToday=0;
        
    
        for(PurchaseDetail pD:purchaseDetailDAO.getAll()){
            if(pD.getPurchase().getPurchaseDate().getYear()==(new Date().getYear())&&pD.getPurchase().getPurchaseDate().getMonth()==(new Date().getMonth())&&pD.getPurchase().getPurchaseDate().getDay()==(new Date().getDay())){
                totalProfitToday+=pD.getTotalProfit();
            }
            totalProfitTillDate+=pD.getTotalProfit();
        }
       
        modelAndView.addObject("totalProfitTillDate",totalProfitTillDate );
        modelAndView.addObject("totalProfitToday",totalProfitToday );
        modelAndView.addObject("productList", productDAO.getAll());
        modelAndView.addObject("categoryList", categoryDAO.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ModelAndView detail(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("product", productDAO.getById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public String insert(@ModelAttribute("product") Product product) {
        
        productDAO.insert(product);
        return "successfully inserted";

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id) {
        productDAO.delete(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam("id") int id, Model model) {
        Product product = productDAO.getById(id);
        if (product == null) {
            return "redirect:/";
        }
        model.addAttribute("product", product);
        model.addAttribute("categoryList", categoryDAO.getAll());
        return "productedit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(@ModelAttribute("product") Product product) {
        productDAO.update(product);
        return "success fully updated";
    }
}
