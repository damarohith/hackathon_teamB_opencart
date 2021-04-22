package stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;


import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import dataProvider.ConfigFileReader;
import factory.driverfactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.createaccount;
import pages.loginpage;

import utills.ExcelReader;


 

 

public class stepdefinition {
    
    WebDriver driver;
    
   ConfigFileReader configfile;
    Properties prop;
   driverfactory factory;
    
    @Before(order = 0)
    public void getProperty() {
        configfile = new ConfigFileReader();
        prop = configfile.init_prop();
    }

 
    @Before(order = 1)
    public void launchBrowser() {
        String browserName = prop.getProperty("browser");
       factory = new driverfactory();
       driver = factory.init_driver(browserName);
        
    }
        
    

@Given("^user should open link$")
public void user_should_open_link() throws Throwable {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().deleteAllCookies();
    
    File src=new File("C:\\Users\\win10\\git\\h-5\\hackhathon5\\excel sheet\\Hackathon.xlsx");
    FileInputStream input=new FileInputStream(src);
    XSSFWorkbook wb=new XSSFWorkbook(input);
    XSSFSheet sheet=wb.getSheet("hackathon5");
    String urlLink=sheet.getRow(1).getCell(6).getStringCellValue();
   driver.get(urlLink);
   
}

@Then("^click on accountand enter credentials \"([^\"]*)\" and (\\d+)$")
public void click_on_accountand_enter_credentials_and(String SheetName, int RowNumber) throws Throwable {
	 driver.findElement(By.xpath(prop.getProperty("MyAccount_xpath"))).click();
	    driver.findElement(By.xpath(prop.getProperty("Register_button_xpath"))).click();
	    ExcelReader reader=new ExcelReader();
	    createaccount create=new createaccount(driver);
	    
		List<Map<String,String>> testData =reader.getData("C:\\Users\\win10\\git\\h-5\\hackhathon5\\excel sheet\\Hackathon.xlsx", SheetName);
	    String firstname =testData.get(RowNumber).get("First Name");
	    String lastname =testData.get(RowNumber).get("Last Name");
	    String emailaddress =testData.get(RowNumber).get("Email");
	    String telephone =testData.get(RowNumber).get("Telephone");
	    String password =testData.get(RowNumber).get("Password");
	    String confirmpassword =testData.get(RowNumber).get("Password Confirm");



	    create.Enterlogindetails(firstname, lastname, emailaddress, telephone, password, confirmpassword);
   
}

@And("^click on submit$")
public void click_on_submit() throws Throwable {
	
  
}

@Given("^user should login to application$")
public void user_should_login_to_application() throws Throwable {
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().deleteAllCookies();
	    File src=new File("C:\\Users\\win10\\git\\h-5\\hackhathon5\\excel sheet\\Hackathon.xlsx");
	    FileInputStream input=new FileInputStream(src);
	    XSSFWorkbook wb=new XSSFWorkbook(input);
	    XSSFSheet sheet=wb.getSheet("hackathon5");
	    String urlLink=sheet.getRow(1).getCell(6).getStringCellValue();
	    driver.get(urlLink);
	    
   
}

@Then("^enters credentials \"([^\"]*)\" and (\\d+)$")
public void enters_credentials_and(String SheetName, int RowNumber) throws Throwable {
	driver.findElement(By.xpath(prop.getProperty("MyAccount_xpath"))).click();
    driver.findElement(By.xpath(prop.getProperty("Login_xpath"))).click();
    driver.findElement(By.xpath(prop.getProperty("Email_loginpage_xpath"))).click();
    driver.findElement(By.xpath(prop.getProperty("Password_login_xpath"))).click();
    ExcelReader reader=new ExcelReader();
    loginpage login=new loginpage(driver);
    
	List<Map<String,String>> testData =reader.getData("C:\\Users\\win10\\git\\h-5\\hackhathon5\\excel sheet\\Hackathon.xlsx", SheetName);
    

	String Username =testData.get(RowNumber).get("Email");
   
	String loginpassword =testData.get(RowNumber).get("Password");
    
    login.Enterlogindetails(Username, loginpassword);
	
   
}

@And("^click on login$")
public void click_on_login() throws Throwable {
	 driver.findElement(By.xpath(prop.getProperty("Login_path"))).click();
   
}

@And("^user search for item and add to cart$")
public void user_search_for_item_and_add_to_cart() throws Throwable {
	 driver.findElement(By.xpath(prop.getProperty("search_iteam_xpath"))).sendKeys("iphone");
	    driver.findElement(By.xpath(prop.getProperty("search_ion_xpath"))).click();
	    JavascriptExecutor js = (JavascriptExecutor)  driver;
	     js.executeScript("window.scrollBy(5,500)");
	     driver.findElement(By.xpath(prop.getProperty("select_iphone_xpath"))).click();
	     WebElement Quantity = driver.findElement(By.xpath(prop.getProperty("enter_quantity_xpath")));
	     Quantity.clear();
	     driver.findElement(By.xpath(prop.getProperty("enter_quantity_xpath"))).sendKeys("2");
	     driver.findElement(By.xpath(prop.getProperty("Mac_add_to_cart_xpath"))).click();
	     driver.findElement(By.xpath(prop.getProperty("click_cart_items"))).click();
	     driver.findElement(By.xpath(prop.getProperty("checkout_cart_xpath"))).click();
	     Thread.sleep(1000);
	     File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	     File dest = new File("screenshot/"+"addtocart.screenshot"+ ".png");;
	     FileUtils.copyFile(scr, dest);
  
}


@And("^select a product and Add to cart$")
public void user_mouseover_to_laptop_and_select_HP_LP() throws Throwable {
	 WebElement ele=  driver.findElement(By.xpath(prop.getProperty("laptop_notebook_xpath")));
	    Actions act =new Actions( driver);
	    act.moveToElement(ele).perform();
	 driver.findElement(By.xpath(prop.getProperty("laptop_notebook_xpath"))).click();
	    driver.findElement(By.xpath(prop.getProperty("showall_lap_note_xpath"))).click();
	    JavascriptExecutor js = (JavascriptExecutor)  driver;
	     js.executeScript("window.scrollBy(5,500)");
	     driver.findElement(By.xpath(prop.getProperty("HpLp3065_xpath"))).click();
	     js.executeScript("window.scrollBy(2,500)");
	     driver.findElement(By.xpath(prop.getProperty("add_to_cart_xpath"))).click();
	     driver.findElement(By.xpath(prop.getProperty("shoppingcart_xpath"))).click();
	     driver.findElement(By.xpath(prop.getProperty("RemoveProduct"))).click();
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     
	     js.executeScript("window.scrollBy(2,500)");
	     driver.findElement(By.xpath(prop.getProperty("continueshopping"))).click();
    
}

@Then("^user mouseover to laptop$")
public void user_mouseover_to_laptop() throws Throwable {
    driver.findElement(By.xpath(prop.getProperty("laptop_notebook_xpath"))).click();
    driver.findElement(By.xpath(prop.getProperty("showall_lap_note_xpath"))).click();
    JavascriptExecutor js = (JavascriptExecutor)  driver;
     js.executeScript("window.scrollBy(5,500)");
     driver.findElement(By.xpath(prop.getProperty("HpLp3065_xpath"))).click();
    
    
}
@And("^user changes delivery date$")
public void user_changes_delivery_date() throws Throwable {
	JavascriptExecutor down = (JavascriptExecutor)  driver;
    down.executeScript("window.scrollBy(5,500)");
    WebElement Quantity = driver.findElement(By.xpath(prop.getProperty("delivery_date_xpath")));
    Quantity.clear();
    driver.findElement(By.xpath(prop.getProperty("delivery_date_xpath"))).sendKeys("2020-04-20");
    
}

@Then("^user Adds to cart and add coupon apply$")
public void user_Adds_to_cart_and_add_coupon_apply() throws Throwable {
	driver.findElement(By.xpath(prop.getProperty("add_to_cart_xpath"))).click();
    
    driver.findElement(By.xpath(prop.getProperty("shoppingcart_xpath"))).click();
    JavascriptExecutor down = (JavascriptExecutor)  driver;
     down.executeScript("window.scrollBy(5,250)");
    driver.findElement(By.xpath(prop.getProperty("coupon_xpath"))).click();
    WebDriverWait wait = new WebDriverWait(driver,20);
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("enter_coupon_xpath"))));
    driver.findElement(By.xpath(prop.getProperty("enter_coupon_xpath"))).sendKeys("CORONA2020");
   
    driver.findElement(By.xpath(prop.getProperty("apply_coupon_xpath"))).click();
   
    File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
     File dest = new File("screenshot/"+"errorcoupon.screenshot"+ ".png");
     FileUtils.copyFile(scr, dest);
}
	

@Then("^User apply empty coupon code$")
public void user_apply_empty_coupon_code() throws Throwable {
	
	    WebElement ele=  driver.findElement(By.xpath(prop.getProperty("Shoppingcart_xpath")));
	    Actions act =new Actions( driver);
	    act.moveToElement(ele).perform();
	    driver.findElement(By.xpath(prop.getProperty("Shoppingcart_xpath"))).click();
	    driver.findElement(By.xpath(prop.getProperty("Couponcode_xpath"))).click();
	    driver.findElement(By.xpath(prop.getProperty("Apply_xpath"))).click();
	   
	    Thread.sleep(2000);
	    File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	     File dest = new File("screenshot/"+"emptycoupon.screenshot"+ ".png");
	     FileUtils.copyFile(scr, dest);
}




@After(order = 0)
public void quitBrowser() {
    driver.quit();
}
}

   