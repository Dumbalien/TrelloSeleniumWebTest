package com.telRan.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        wd.findElement(By.cssSelector("[href='/login']")).click();

        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys("dumbalien86@gmail.com" + Keys.ENTER);

        Thread.sleep(10000);

        wd.findElement(By.id("login")).click();
        Thread.sleep(10000);

        wd.findElement(By.id("password")).click();
        wd.findElement(By.id("password")).clear();
        wd.findElement(By.id("password")).sendKeys("TrelloLO2020" + Keys.ENTER);


    }
    @AfterClass(enabled = false)
    public void tearDown(){
        wd.quit();

    }
}
