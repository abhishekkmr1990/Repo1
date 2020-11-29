package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactPageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    ContactsPage contactsPage;

    public ContactPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        intilization();
        loginPage = new LoginPage();
        contactsPage = new ContactsPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        homePage.clickContactsLink();
    }

    @Test(priority = 1)
    public void selectContactByName() {
        contactsPage.selectContactsName("Abhishek Kumar");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
