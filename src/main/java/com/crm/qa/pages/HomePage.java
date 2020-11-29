package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    //PageFactory -OR:
    @FindBy(xpath = "//span[contains(text(),'Abhishek Kumar')]")
    WebElement userNameLable;

    @FindBy(xpath = "//span[contains(text(),'Contacts')]")
    WebElement contactsLinks;

    @FindBy(xpath = "//span[contains(text(),'Deals')]")
    WebElement dealsLinks;

    @FindBy(xpath = "//span[contains(text(),'Tasks')]")
    WebElement tasksLinks;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    public ContactsPage clickContactsLink(){
        contactsLinks.click();
        return  new ContactsPage();
    }
    public DealsPage clickDealsLink(){
        dealsLinks.click();
        return  new DealsPage();
    }

    public TasksPage clickTasksLink(){
        tasksLinks.click();
        return  new TasksPage();
    }

    public boolean verifyUserName(){
        return  userNameLable.isDisplayed();
    }

}
