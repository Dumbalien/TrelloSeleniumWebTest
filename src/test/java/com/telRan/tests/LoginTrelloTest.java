package com.telRan.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTrelloTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if(isAvatarPresent()){
            logout();
        }
    }

    @Test
    public void loginAtlassianAccPositiveTest() throws InterruptedException {
        login("dumbalien86@gmail.com", "TrelloLO2020");

        Assert.assertTrue(isAvatarPresent());
    }

    @Test
    public void negativeLoginAtlassianAccPositiveTest() throws InterruptedException {
        login("dumbalien86@gmail.com", "TrelloLO");

        Assert.assertTrue(isLoginErrorPresent());
        Assert.assertFalse(isAvatarPresent());
    }


}
