package com.telran.qa25;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    WebDriver wd;

    // before - setUp(){}
    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        wd.get("https://www.google.com/");
    }

    //Test
    @Test
    public void openGoogleTest(){
        System.out.println("Site opened!!!");
        wd.findElement(By.name("q")).click();
        wd.findElement(By.name("q")).sendKeys("Selenium" + Keys.ENTER);
        String text = wd.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(text.toLowerCase(), "Selenium");

    }

    //after - tearDown(){}
    @AfterMethod
    public void tearDown(){
    wd.quit();
    }
}
