package pages;


	
	import org.openqa.selenium.WebDriver;

	 

	import dataProvider.ConfigFileReader;

	 


	import java.util.Properties;

	 

	import org.openqa.selenium.By;

	 

	
	public class createaccount {
	 

	   private static final CharSequence EmailAdress = null;
	WebDriver driver;
	   Properties prop;
	   ConfigFileReader configfile;
	   
	  

	 

	    public createaccount(WebDriver driver) {
	        this.driver=driver;
	    }
	     
	            
	    public void Enterlogindetails(String firstname,String lastname, String emailaddress,String telephone,String password,String confirmpassword) {
	        configfile = new ConfigFileReader();
	           prop = configfile.init_prop();
	       
	         driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(firstname);
	          driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(lastname);
	          driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(emailaddress);
	          
	          driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(telephone);
	          driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
	          driver.findElement(By.xpath("//*[@id=\"input-confirm\"]")).sendKeys(confirmpassword);
	          driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
	          driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
	         
	    }
	    

	 

	    
	}


