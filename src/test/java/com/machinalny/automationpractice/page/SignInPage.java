package com.machinalny.automationpractice.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//input[@id='email_create']")
    private WebElement emailAddressField;

    @FindBy(xpath = "//button[@id='SubmitCreate']")
    private WebElement createAnAccountButton;

    public SignInPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void enterEmailForNewAccount(String email) {
        super.enterTextTo(emailAddressField, email);
    }

    public void createAnAccount() {
        super.clickOnElement(createAnAccountButton);
    }

}
