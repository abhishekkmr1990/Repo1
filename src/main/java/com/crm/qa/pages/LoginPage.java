package com.crm.qa.pages;
import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    //PageFactory -OR:
    @FindBy(xpath = "//input[@name='email']")
    WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//div[text()='Login']")
    WebElement loginbutton;

    @FindBy(xpath = "//div[@class='ui navbar fixed main menu']/child::div[1]")
    WebElement crmcogmentoLogo;

    //Initializing the Page object
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean validateCRMLogo() {
        return crmcogmentoLogo.isDisplayed();
    }

    public HomePage login(String uname, String pwd) {
        username.sendKeys(uname);
        password.sendKeys(pwd);
        loginbutton.click();
        return new HomePage();
    }

}
