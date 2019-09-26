package com.machinalny.automationpractice.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage {

    @FindBy(xpath = "/html//header[@id='header']//nav//a[@title='Log me out']")
    private WebElement signOutButton;

    public MyAccountPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void signOut(){
        clickOnElement(signOutButton);
    }

}
