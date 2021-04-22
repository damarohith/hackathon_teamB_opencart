package pages;
import org.openqa.selenium.WebDriver;

 

import dataProvider.ConfigFileReader;

 


import java.util.Properties;

 

import org.openqa.selenium.By;

 

public class loginpage {

 

   WebDriver driver;
   Properties prop;
   ConfigFileReader configfile;
   
  

 

    public loginpage(WebDriver driver) {
        this.driver=driver;
    }
     
            
    public void Enterlogindetails(String Email, String Password) {
        configfile = new ConfigFileReader();
           prop = configfile.init_prop();
       
          driver.findElement(By.xpath(prop.getProperty("Email_loginpage_xpath"))).sendKeys(Email);
          driver.findElement(By.xpath(prop.getProperty("Password_login_xpath"))).sendKeys(Password);
          
    }
    

 

    public void ClickLogin() {
        configfile = new ConfigFileReader();
           prop = configfile.init_prop();
        
        driver.findElement(By.xpath(prop.getProperty("Login_Button_Xpath"))).click();
        
    }
}