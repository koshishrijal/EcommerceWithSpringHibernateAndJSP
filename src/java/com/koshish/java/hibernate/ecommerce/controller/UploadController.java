/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.controller;

import com.koshish.java.hibernate.ecommerce.DAO.ProductDAO;
import com.koshish.java.hibernate.ecommerce.Helper.FileHelper;
import com.sun.xml.ws.runtime.dev.SessionManager;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Koshish Rijal
 */
@Controller
@RequestMapping(value = "/upload")
public class UploadController {
    @Autowired
    private ProductDAO productDAO;
    @RequestMapping(method = RequestMethod.GET)
    public String upload(Model model) {
        model.addAttribute("productList",productDAO.getAll());
        return "upload";
    }
   
    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String does(HttpServletRequest request, Model model) {
        
       FileHelper.setUploadCondition(1024*1024*6,1024*1024*5,"C:\\Users\\Koshish Rijal\\Documents\\NetBeansProjects\\ECommerceHibernateSpring\\web\\WEB-INF\\resources\\images", request);
        FileHelper.initDiskFactory();
        String returnPage=FileHelper.process(model);
        
        return returnPage;
    }


}
