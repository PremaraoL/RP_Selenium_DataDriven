package com.selenium.datadriven;


/**
*
* @author rboyini
*/
import com.selenium.utils.PropertiesReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.selenium.utils.Common;

public class Login {
   
   Common common = new Common();
   PropertiesReader prop = new PropertiesReader();
   
   public Login(){
   }
   
   public boolean login(WebDriver driver, String token) throws InterruptedException, IOException
   {
       Boolean ExpStatus = null;
       Boolean ActualStatus = null;
       String ExpText = null;
       String ActText = null;
       WebDriverWait wait = new WebDriverWait(driver, 15);
       Properties xpath = prop.getProperties("xpath");
      
       
       switch(token){
               case "success":
                   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperties("xpath").getProperty("email"))));
                   common.sendKeys(driver, xpath.getProperty("email"), prop.getProperties("config").getProperty("username"));
                    common.click(driver, prop.getProperties("xpath").getProperty("next_button"));
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperties("xpath").getProperty("password"))));
                    common.sendKeys(driver, prop.getProperties("xpath").getProperty("password"), prop.getProperties("config").getProperty("password"));
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperties("xpath").getProperty("signin_button"))));
                    common.click(driver, prop.getProperties("xpath").getProperty("signin_button"));
           
                   ExpStatus = true;
                   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperties("xpath").getProperty("composebutton"))));
                   ActText = common.getText(driver, prop.getProperties("xpath").getProperty("composebutton"));
                   ExpText = "COMPOSE";
                   System.out.println("Expected: "+ExpText+"\n Actual: "+ActText );
                   ActualStatus = common.compareStrings(ActText, ExpText);
                   if (ActualStatus)
                    {
                    System.out.println("logged in successfully");
                    }
                 else
                      {
                      System.out.println("Login failed");
                         }
                   break;
               case "emailinvalid":
                   common.sendKeys(driver, prop.getProperties("xpath").getProperty("email"), prop.getProperties("config").getProperty("invalid_username"));
                    common.click(driver, prop.getProperties("xpath").getProperty("next_button"));
                   ExpStatus = true;
                   ActText = common.getText(driver, prop.getProperties("xpath").getProperty("invalid_email_error"));
                   ExpText = "Sorry, Google doesn't recognize that email. ";
                   ActualStatus = common.compareStrings(ActText, ExpText);      
                   System.out.println("Expected: "+ExpText+"\n Actual: "+ActText );
                   break;
               default:
               System.out.println("Invalid Token");
               
  
               }
       Boolean status = common.compareBoolean(ExpStatus, ActualStatus);
       return status;
       
   }
   
}
