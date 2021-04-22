package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


	@RunWith(Cucumber.class)
	@CucumberOptions (  
	        features = {"src/test/resources/feature"},
	        glue={"stepdefinition"},
	       // plugin={"pretty"}
	        plugin = { "pretty","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html","html:test-output"}
	        
	        )

	 

	public class opencartrunner extends AbstractTestNGCucumberTests {
		
	}
		


	 




