package stepDefination;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor;
//import org.junit.Assert;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObject.HomePage;
import pageObject.LoginPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class StepDef_Login extends BaseClass {



    @Before("@sanity")
    public void  setUp()
    {
         driver = new ChromeDriver();
        System.out.println("its is stepdef login");

    }



    @Given("User Launch The chrome browser")
    public void user_launch_the_chrome_browser() {

     //   driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @When("User navigates to the URL {string}")
    public void user_navigates_to_the_url(String string) {

        driver.get(string);
    }
    @When("User enter the UserName {string} and  password {string}")
    public void user_enter_the_user_name_and_password(String string, String string2) {

        loginPage= new LoginPage(driver);
        loginPage.setUserTextBox(string);
        loginPage.setPasswordTextBox(string2);
    }
    @When("User click on login link")
    public void user_click_on_login_link() throws InterruptedException {

        loginPage.clickLoginButton();
        Thread.sleep(2000);
    }
    @Then("Page URL should be {string}")
    public void page_url_should_be(String string) {

        String url=driver.getCurrentUrl();
        Assert.assertEquals(url,string);
    }
    @When("click on logout link")
    public void click_on_logout_link() {

        homePage= new HomePage(driver);
        homePage.clickLogoutButton();
    }
//    @Then("Close the browser")
//    public void close_the_browser() {
//
//        driver.close();

 //   }

}
