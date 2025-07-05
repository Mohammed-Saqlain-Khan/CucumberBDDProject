package pageObject;

import io.cucumber.java.en_old.Ac;
//import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.openqa.selenium.By.xpath;

public class AdminPage {

    WebDriver driver;


    public AdminPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

                     @FindBy(xpath="//button[text()=' Add ']")
    WebElement AdminAddCustomerButton;

    @FindBy(xpath="//label[text()='User Role']/../following-sibling::div//div[@class='oxd-select-text oxd-select-text--active']")
    WebElement AdminUserRoleDropdown;

    @FindBy(xpath="//label[text()='User Role']/../following-sibling::div//span[text()='Admin']")
    WebElement  AdminUserRoleAdmin;

    @FindBy(xpath="//label[text()='User Role']/../following-sibling::div//span[text()='ESS']")
    WebElement AdminUserRoleESs;

    @FindBy(xpath="//label[text()='Employee Name']/../following-sibling::div//input")
    WebElement AdminEmployeeName;

    @FindBy(xpath="//label[text()='Status']/../following-sibling::div//div[@class='oxd-select-text-input']")
    WebElement AdminStatusDropdown;

    @FindBy(xpath="//label[text()='Status']/../following-sibling::div//span[text()='Enabled']")
    WebElement AdminStatusEnabled;

    @FindBy(xpath="//label[text()='Status']/../following-sibling::div//span[text()='Disabled']")
    WebElement AdminStatusDisabled;

    @FindBy(xpath="//label[text()='Username']/../following-sibling::div")
    WebElement AdminUserName;

    @FindBy(xpath="//label[text()='Password']/../following-sibling::div")
    WebElement AdminPassword;

    @FindBy(xpath="//label[text()='Confirm Password']/../following-sibling::div")
    WebElement AdminConfirmPassword;

    @FindBy(xpath="//button[text()=' Save ']")
    WebElement AdminSaveButton;

    @FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-text--toast-title oxd-toast-content-text']")
    WebElement AdminSuccessNotification;

    @FindBy(xpath="//i[@class='oxd-icon bi-plus oxd-button-icon']")
    WebElement AdminAddButton;

    @FindBy(xpath="//label[text()='Username']/../following-sibling::div")
    WebElement AdminSearchUseName;

    @FindBy(xpath="//button[text()=' Search ']")
    WebElement AdminSearchButton;

    @FindBy(xpath="//div[@class='oxd-table']/div[@class='oxd-table-body']/div/div/div[2]")
    WebElement AdminSearchRecord;


    public void setAdminUserRole(String value)
    {
        AdminUserRoleDropdown.click();

        if(value.contains("Admin")){
            AdminUserRoleAdmin.click();
        }
        else
        {
            AdminUserRoleESs.click();
        }


    }

    public void setAdminEmployeeName() throws InterruptedException {

        AdminEmployeeName.sendKeys("A");
        Actions actions= new Actions(driver);
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();

    }

    public void setAdminStatus(String value)
    {
        AdminStatusDropdown.click();

        if(value.contains("Enabled"))
        {
            AdminStatusEnabled.click();
        }
        else
        {
            AdminStatusDisabled.click();
        }
    }

    public void setAdminUserName(String name)
    {
        Actions actions = new Actions(driver);
        actions.click(AdminUserName).sendKeys(name).perform();
    }

    public void setAdminPassword(String password)
    {
        Actions actions = new Actions(driver);
        actions.click(AdminPassword).sendKeys(password).perform();


    }

    public void setAdminConfirmPassword(String confirm)
    {

        Actions actions = new Actions(driver);

        actions.click(AdminConfirmPassword).sendKeys(confirm).perform();
    }

    public void clickAddSaveButton()
    {
        AdminSaveButton.click();
    }

    public void CheckSuccessValidation() throws InterruptedException {
        Thread.sleep(3000);
        String text=AdminSuccessNotification.getText();
        if(text.contains("Success"))
        {
            Assert.assertTrue(true);

        }
        else
        {
            Assert.assertFalse(false);
        }
    }

    public void  clickAdminAddButton()
    {
        AdminAddButton.click();
    }

    public void searchByUserName(String userName)
    {
        Actions actions = new Actions(driver);
        actions.click(AdminSearchUseName).sendKeys(userName).perform();

    }
    public void clickOnSearchButton()
    {

        Actions actions = new Actions(driver);
        actions.click(AdminSearchButton).perform();


    }

    public boolean getAdminSearchResult(String string)
    {
       String value= AdminSearchRecord.getText();
       if(value.contains(string))
       {
           return true;
       }
       else
       {
           return false;
       }
    }
}
