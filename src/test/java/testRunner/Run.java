package testRunner;


//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// plugin={"pretty","html:target/cucumber-reports/reports1.html"}, plugin={"pretty","html:target/cucumber-reports/reports1.html"},
//@RunWith(Cucumber.class)
@CucumberOptions(features= "Features/",glue="stepDefination",
        plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome=true,tags="@regression",dryRun=false)

public class Run extends AbstractTestNGCucumberTests
{
    //This  class will be empty
}
