package com.telRan.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTrelloTest {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
      wd = new ChromeDriver();
      wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      wd.manage().window().maximize();

        wd.navigate().to("https://trello.com/");

    }
    @Test
    public void loginAtlassianAccPositiveTest() throws InterruptedException {
        login("dumbalien86@gmail.com", "TrelloLO2020");

        Assert.assertTrue(isAvatarPresent());;


    }

    public void login(String email, String password) throws InterruptedException {
        click(By.cssSelector("[href='/login']"));
        type(By.name("user"), email + Keys.ENTER);
        Thread.sleep(10000);

        click(By.id("login"));
        Thread.sleep(10000);

        type(By.id("password"), password + Keys.ENTER);
        click(By.id("login-submit"));
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator){
        wd.findElement(locator).click();

    }



    public boolean isAvatarPresent(){

        return isElementPresent(By.xpath
                ("//button[@data-test-id='header-member-menu-button']"));

    }

    public boolean isElementPresent(By locator) {

        return wd.findElements(locator).size() > 0;
    }

    @AfterClass(enabled = false)
    public void tearDown(){
        wd.quit();

    }
}
