package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.naming.ldap.spi.LdapDnsProvider;

public class HomePage
{

    public HomePage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//span[text()='Admin']")
    WebElement AdminButton;

    @FindBy(xpath="//span[text()='PIM']")
    WebElement PIMButton;

    @FindBy(xpath="//span[text()='Dashboard']")
    WebElement DashboardButton;

    @FindBy(xpath="//p[@class='oxd-userdropdown-name']")
    WebElement LogoutDropDownButton;

    @FindBy(xpath="//a[text()='Logout']")
    WebElement LogoutButton;

    public void clickAdminButton()
    {
        AdminButton.click();

    }
    public  void clickPIMButton()
    {
        PIMButton.click();
    }

    public void clickDashBoard()
    {
        DashboardButton.click();
    }

    public void clickLogoutButton() {
        LogoutDropDownButton.click();
        LogoutButton.click();
    }
}
