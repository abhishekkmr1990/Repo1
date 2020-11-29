package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    ContactsPage contactsPage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        intilization();
        loginPage = new LoginPage();
        contactsPage=new ContactsPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest() {
        String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle, "Cogmento CRM");
    }

    @Test(priority = 2)
    public void verifyUserNameTest() {
       homePage.verifyUserName();
       Assert.assertTrue(homePage.verifyUserName());
    }

    @Test(priority = 3)
    public void verifyContactsLinkTest() {
        contactsPage=homePage.clickContactsLink();
    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
