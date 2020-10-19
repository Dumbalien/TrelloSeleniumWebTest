package com.telRan.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase{

    @Test
    public void boardCreation(){
        clickOnButtonPlus();
        fillBoardForm();
        confirmBoardCreation();
        returnOnHomePage();

    }

    public void returnOnHomePage() {
        click(By.cssSelector("css='15'"));
    }

    public void confirmBoardCreation() {
        click(By.cssSelector("data-test-id='create-board-submit-button'"));
    }

    public void fillBoardForm() {
        type(By.cssSelector("[autocomplete='off']._23NUW98LaZfBpQ"), "FirstBoard");

    }

    public void clickOnButtonPlus() {
        click(By.cssSelector("div.board-tile[css='1']"));
    }

}
