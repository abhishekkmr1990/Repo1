package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends TestBase {

    //PageFactory -OR:


    public ContactsPage() {
        PageFactory.initElements(driver, this);
    }


    public void selectContactsName(String name) {
        Actions act =  new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//td[text()='"+name+"']//preceding-sibling::td//div[@class='ui fitted read-only checkbox']//input[@type='checkbox']"))).click().perform();

    }

}
