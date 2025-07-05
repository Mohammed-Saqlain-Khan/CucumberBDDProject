package stepDefination;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import pageObject.AdminPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import utilities.PropertyUtil;

import javax.swing.*;
//https://github.com/Mohammed-Saqlain-Khan/CucumberBDDProject.git
public class BaseClass
{
    public static WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    AdminPage adminPage;
    Action action;
   public static String AdminUserName;
   public static Logger logger;

    public String generateRandomUsername()
    {
        return RandomStringUtils.randomAlphabetic(6);


    }
}
