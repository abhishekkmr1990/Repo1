package com.crm.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    static WebDriver driver;
    static Properties prop;

    public TestBase(){
        try {
            prop=new Properties();
            FileInputStream inputStream=new FileInputStream("src/main/java/com/crm/qa/config/config.properties");
            prop.load(inputStream);

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void intilization() {
        String browserName=prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
            driver=new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
            driver=new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }
}
