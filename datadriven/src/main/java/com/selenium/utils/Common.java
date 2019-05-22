package com.selenium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author rboyini
 */
public class Common {
    public Boolean compareStrings(String s1, String s2)
    {
        if(s1.equalsIgnoreCase(s2))
        return true;
        else
        return false;
    }
    
    public Boolean compareIntegers(int i, int j)
    {
        if(i == j)
        return true;
        else
        return false;
    }
    
    public boolean compareBoolean(Boolean i, Boolean j)
    {
        if(i && j)
        return true;
        else
        return false;
    }
    
    public void click(WebDriver driver, String xpath)
    {
        driver.findElement(By.xpath(xpath)).click();
        
    }
    
    public void sendKeys(WebDriver driver, String xpath, String text)
    {
        driver.findElement(By.xpath(xpath)).sendKeys(text);
        
    }
    
    public String getText(WebDriver driver, String xpath)
    {
        String text = driver.findElement(By.xpath(xpath)).getText();
        return text;
    }
}
