/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.controller;

import com.koshish.java.hibernate.ecommerce.DAO.UserDAO;
import com.koshish.java.hibernate.ecommerce.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Koshish Rijal
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserDAO userDAO;
    
    
    
    @RequestMapping(method=RequestMethod.GET)
    private String landingPage(Model model){
        model.addAttribute("userList",userDAO.getAll());
        return "user";
        
    }
    @RequestMapping(method=RequestMethod.POST,value="/insert")
    private String insert(User user ){
       userDAO.insert(user);
       return "redirect:/";
        
    }
  
}
