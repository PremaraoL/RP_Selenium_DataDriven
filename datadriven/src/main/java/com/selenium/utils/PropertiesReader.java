package com.selenium.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author rboyini
 */
public class PropertiesReader  {
    public Properties getProperties(String filename)throws InterruptedException, FileNotFoundException, IOException{
        
    /**
     *
     */
    
        Properties prop = new Properties();
       // Properties prop2 = new Properties();
       if(filename.equalsIgnoreCase("login"))
       {
         FileInputStream fis = new FileInputStream("D:\\Workspaces\\EclipseJee\\Gmail\\conf\\login.properties");
         prop.load(fis);
         return prop;
       }
       else if(filename.equalsIgnoreCase("xpath"))
       {
         FileInputStream fis = new FileInputStream("D:\\Workspaces\\EclipseJee\\Gmail\\conf\\xpaths.properties");
         prop.load(fis);
         return prop;
       }
       else if(filename.equalsIgnoreCase("config"))
       {
         FileInputStream fis = new FileInputStream("D:\\Workspaces\\EclipseJee\\Gmail\\conf\\config.properties");
         prop.load(fis);
         return prop;
       }
       else if(filename.equalsIgnoreCase("error"))
       {
           FileInputStream fis = new FileInputStream("D:\\Workspaces\\EclipseJee\\Gmail\\conf\\errormesgs.properties");
           prop.load(fis);
           return prop;
       }
       else
       {
    	   System.out.println("Invalid keyword provided for property file loader."); 
    	   return prop;
       }
    }
}
