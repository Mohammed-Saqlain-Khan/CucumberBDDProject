package stepDefination;

import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import pageObject.AdminPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import utilities.PropertyUtil;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

public class StepDef extends BaseClass
{


    @Given("User Launch The new  Chrome Browser")
    public void user_launch_the_new_chrome_browser() throws IOException {

        logger = LogManager.getLogger("StepDef");
        logger.info("laucnching the chrome brower with info log");

        String browser =  PropertyUtil.getBrowser();
        System.out.println(browser);
        System.out.println("wowo");

        switch(browser.toLowerCase())
        {
            case "chrome":
            {
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;
            }
            case "firefox":
            {
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;
            }
            case "edge":
            {
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;

            }
        }

    }
    @When("User navigates for the URL {string}")
    public void user_navigates_for_the_url(String string) {

        driver.get(string);
        logger.info("gettting some logs methods");
        System.out.println(logger.getLevel() + " "+ logger.getName());
        System.out.println("wowo ");

    }
    @When("User enter with the credentials UserName {string} and  password {string}")
    public void user_enter_with_the_credentials_user_name_and_password(String string, String string2) {


        logger.fatal("fatal entering the user name and the password");
        loginPage = new  LoginPage(driver);
        loginPage.setUserTextBox(string);
        loginPage.setPasswordTextBox(string2);
    }
    @When("User click on login Button Link")
    public void user_click_on_login_button_link() throws InterruptedException {

        logger.error("error log , clicking on the login button");

        loginPage.clickLoginButton();
        Thread.sleep(2000);
    }
    @When("User Click on the Admin Button")
    public void user_click_on_the_admin_button() throws InterruptedException {


        logger.warn("warn loog, clicking on the home page button");
        homePage= new  HomePage(driver);
        Thread.sleep(1000);
        homePage.clickAdminButton();
        adminPage = new AdminPage(driver);
        Thread.sleep(1000);


    }
    @When("User Click on the  Add Button in Admin Page")
    public void user_click_on_the_add_button_in_admin_page() {


        logger.info("clicking on the admin page");
        adminPage.clickAdminAddButton();
    }
    @Then("The URL of the page should be {string}")
    public void the_url_of_the_page_should_be(String string) {


        String  url = driver.getCurrentUrl();
        if(url.contains(string))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertFalse(true);
        }
    }
    @When("User enters the UserRole as {string}")
    public void user_enters_the_user_role_as(String string) throws InterruptedException {

        logger.debug("entering the user role debug information");

        Thread.sleep(1000);
      adminPage.setAdminUserRole("Admin");
    }
    @When("User enters the Employee name as down arrow")
    public void user_enters_the_employee_name_as() throws InterruptedException {




        adminPage.setAdminEmployeeName();
    }
    @When("User enters the status as {string}")
    public void user_enters_the_status_as(String string) throws InterruptedException {
       adminPage.setAdminStatus(string);
       Thread.sleep(2000);

    }
    @When("User enters the Username as {string}")
    public void user_enters_the_username_as(String string) {
        AdminUserName= generateRandomUsername();
        string= AdminUserName;
        adminPage.setAdminUserName(string);
        logger.trace("entering the admin user name with the 'trace' ");



    }
    @When("User enter the password as {string} and confirmPassword as {string}")
    public void user_enter_the_password_as_and_confirm_password_as(String string, String string2) {
        adminPage.setAdminPassword(string);
        adminPage.setAdminConfirmPassword(string2);
    }
    @When("User clicks on save")
    public void user_clicks_on() {
        adminPage.clickAddSaveButton();


    }
    @Then("Success Message is displayed")
    public void success_message_is_displayed() throws InterruptedException {

        adminPage.CheckSuccessValidation();;
    }
//    @Then("User close the browser")
//    public void user_close_the_browser() {
//
//        driver.close();
//    }


    @When("User Enter the Username to be searched in the UserName textbox as {string}")
    public void userEnterTheUsernameToBeSearchedInTheUserNameTextboxAs(String arg0) throws InterruptedException {

        arg0=AdminUserName;
        adminPage.searchByUserName(arg0);

    }
    @When("User clicks on the search button")
    public void user_clicks_on_the_search_button() {

        adminPage.clickOnSearchButton();
    }

    @Then("User finds one records with expected username as {string}")
    public void userFindsOneRecordsWithExpectedUsernameAs(String arg0) throws InterruptedException {
        Thread.sleep(2000);
        arg0=AdminUserName;
       boolean b= adminPage.getAdminSearchResult(arg0);
       Assert.assertTrue(b);


    }

    @AfterStep
    public void addScreenshot(Scenario scenario)
    {
        if(scenario.isFailed()) {


            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
         //   scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }




}
