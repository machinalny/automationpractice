package com.machinalny.automationpractice.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private static final int TIMEOUT = 15;
    private static final int POLLING = 100;

    WebDriver webDriver;
    private WebDriverWait wait;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(this.webDriver, TIMEOUT, POLLING);
    }

    public void enterTextTo(WebElement element, String text) {
        waitUntilVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    public String getTextFrom(WebElement element) {
        waitUntilVisible(element);
        return element.getText();
    }

    public void clickOnElement(WebElement webElement) {
        waitUntilClickable(webElement);
        webElement.click();
    }

    public void selectCheckbox(WebElement webElement) {
        if (!getCheckboxState(webElement)) {
            webElement.click();
        }
    }

    public void unSelectCheckbox(WebElement webElement) {
        if (getCheckboxState(webElement)) {
            webElement.click();
        }
    }

    public boolean getCheckboxState(WebElement webElement) {
        return webElement.isSelected();
    }

    public void selectFromDropdownByValue(WebElement webElement, String value) {
        Select dropdownSelect = new Select(webElement);
        dropdownSelect.selectByValue(value);
    }

    public void selectFromDropdownByText(WebElement webElement, String text) {
        Select dropdownSelect = new Select(webElement);
        dropdownSelect.selectByVisibleText(text);
    }

    public void waitUntilVisible(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitUntilClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitUntilSelectable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeSelected(webElement));
    }

}
