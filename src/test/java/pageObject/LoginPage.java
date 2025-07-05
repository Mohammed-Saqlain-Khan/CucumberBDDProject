package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{

    public LoginPage(WebDriver driver)
    {
     PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//input[@name='username']")
    WebElement UserTextBox;

    @FindBy(xpath="//input[@name='password']")
    WebElement PasswordTextBox;

    @FindBy(xpath="//button[text()=' Login ']")
    WebElement LoginButton;

    @FindBy(xpath="//p[@class='oxd-userdropdown-name']")
    WebElement LogoutDropDownButton;

    @FindBy(xpath="//a[text()='Logout']")
    WebElement LogoutButton;




    public void setUserTextBox(String userName)
    {
        UserTextBox.clear();
        UserTextBox.sendKeys(userName);
    }

    public void setPasswordTextBox(String password)
    {
        PasswordTextBox.clear();
        PasswordTextBox.sendKeys(password);
    }

    public void clickLoginButton()
    {
        LoginButton.click();
    }




}
