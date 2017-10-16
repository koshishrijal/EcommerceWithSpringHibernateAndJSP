/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koshish.java.hibernate.ecommerce.Helper;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;

/**
 *s
 * @author Koshish Rijal
 */
public class FileHelper {
    private static HttpServletRequest request;
    private static long maxSize;
    private static long maxFileSize;
    private static String uploadPath;
    private static File uploadDir =null;
    private static String productName;
   private static ServletFileUpload upload =null;
    //secondly call this
   public  static void initDiskFactory(){
       DiskFileItemFactory factory=new DiskFileItemFactory();
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

         upload = new ServletFileUpload(factory);
         
        FileHelper.uploadDir = new File(uploadPath);
        upload.setSizeMax(maxSize);
        upload.setFileSizeMax(maxFileSize);
   }
   //first call this 
    public static void setUploadCondition(long maxSize,long maxFileSize,String uploadPath,HttpServletRequest request){
        FileHelper.maxFileSize=maxFileSize;
       FileHelper.maxSize=maxSize;
         FileHelper.request=request;
          FileHelper.uploadPath=uploadPath;
          
    }
    //lastly call this
    public static String process(Model model){
         if (! FileHelper.uploadDir.exists()) {
             FileHelper.uploadDir.mkdir();
        }
        try {
            
            List<FileItem> items = FileHelper.upload.parseRequest(FileHelper.request);
           Iterator<FileItem> itr = items.iterator();
            while (itr.hasNext()) {
                FileItem item = itr.next();
              if(item.isFormField()){
                 FileHelper.productName=item.getString();
              }
  
                if(!item.isFormField()){
                String fieldName = item.getFieldName();
                String fileName = item.getName();
                String content = item.getContentType();
                boolean IsInMemory = item.isInMemory();
                long size = item.getSize();
               
                String filePath = FileHelper.uploadPath +File.separator+FileHelper.productName+".jpeg";
                File storeFile = new File(filePath);
                
                try {
                    item.write(storeFile);
                } catch (Exception ex) {
                    model.addAttribute("errorMessage", ex.getMessage());
                    return PageConstant.errorPageConstant;
                }
                }
            }

        } catch (FileUploadException ex) {
            model.addAttribute("errorMessage", ex.getMessage());
            return PageConstant.errorPageConstant;

        }
        return PageConstant.successPageConstant;
    }
    
    
}
