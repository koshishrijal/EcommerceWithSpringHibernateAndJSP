/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.controller;

import com.koshish.java.hibernate.ecommerce.DAO.CategoryDAO;
import com.koshish.java.hibernate.ecommerce.entity.Category;
import com.koshish.java.hibernate.ecommerce.entity.Product;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
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
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author Koshish Rijal
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryDAO categoryDAO;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("/category");
        modelAndView.addObject("categoryList", categoryDAO.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public String insert(@ModelAttribute("category") Category category) {

        categoryDAO.insert(category);
        return "redirect:/inserted";
    }
    @RequestMapping(value="/edit",method=RequestMethod.GET)
    public String edit(@RequestParam("id")int id,Model model){
        Category category=categoryDAO.getById(id);
        model.addAttribute("category",category);
        return "categoryedit";
    }
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public String update(@ModelAttribute("category")Category category){
        categoryDAO.update(category);
        return "Updated";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") int id,Model model) {
        
     int result=categoryDAO.delete(id);
     if(result==0){
         
         model.addAttribute("error","cannot be delted as child is present,first delete all the products in the category");
         return "redirect:/category";
     }
    return  "redirect:/category";
    }

}
