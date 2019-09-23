package com.machinalny.automationpractice.page;

import com.machinalny.automationpractice.utils.Gender;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPage extends BasePage {

    WebDriver webDriver;
    private WebDriverWait wait;


    @FindBy(xpath = "//input[@name='id_gender' and @id='id_gender1']")
    private WebElement mrTitleRadioInput;

    @FindBy(xpath = "//input[@name='id_gender' and @id='id_gender2']")
    private WebElement mrsTitleRadioInput;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameTextInput;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameTextInput;

    @FindBy(id = "email")
    private WebElement emailTextInput;

    @FindBy(id = "passwd")
    private WebElement passwordTextInput;

    @FindBy(id = "days")
    private WebElement daysOfBirthDropdown;

    @FindBy(id = "months")
    private WebElement monthsOfBirthDropdown;

    @FindBy(id = "years")
    private WebElement yearsOfBirthDropdown;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckboxInput;

    @FindBy(id = "optin")
    private WebElement specialOfferCheckboxInput;

    @FindBy(id = "firstname")
    private WebElement addressFirstNameTextInput;

    @FindBy(id = "lastname")
    private WebElement addressLastNameTextInput;

    @FindBy(id = "company")
    private WebElement addressCompanyTextInput;

    @FindBy(id = "address1")
    private WebElement addressTextInput;

    @FindBy(id = "city")
    private WebElement addressCityTextInput;

    @FindBy(id = "id_state")
    private WebElement addressStateDropdown;

    @FindBy(id = "postcode")
    private WebElement addressPostCodeTextInput;

    @FindBy(id = "id_country")
    private WebElement addressCountryDropdown;

    @FindBy(id = "other")
    private WebElement additionalInformationTextInput;

    @FindBy(id = "phone")
    private WebElement homePhoneTextInput;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneTextInput;

    @FindBy(id = "alias")
    private WebElement aliasTextInput;

    @FindBy(id = "submitAccount")
    private WebElement submitRegisterButton;

    public CreateAccountPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void selectTitle(Gender gender) {
        switch (gender) {
            case MRS:
                clickOnElement(mrsTitleRadioInput);
            case MR:
                clickOnElement(mrsTitleRadioInput);
        }
    }

    public void enterFirstName(String firstName) {
        enterTextTo(firstNameTextInput, firstName);
    }

    public void enterLastName(String lastName) {
        enterTextTo(lastNameTextInput, lastName);
    }

    public void enterEmail(String name) {
        enterTextTo(firstNameTextInput, name);
    }

    public String checkEmail() {
        return getTextFrom(emailTextInput);
    }

    public void enterPassword(String password) {
        enterTextTo(passwordTextInput, password);
    }

    public void selectDayOfBirth(String dayOfBirth) {
        selectFromDropdownByValue(daysOfBirthDropdown, dayOfBirth);
    }

    public void selectMonthOfBirth(String monthOfBirth) {
        selectFromDropdownByValue(monthsOfBirthDropdown, monthOfBirth);
    }

    public void selectYearOfBirth(String yearOfBirth) {
        selectFromDropdownByValue(yearsOfBirthDropdown, yearOfBirth);
    }

    public void selectNewsletter() {
        selectCheckbox(newsletterCheckboxInput);
    }

    public void selectSpecialOffers() {
        selectCheckbox(specialOfferCheckboxInput);
    }

    public void enterAddressFirstName(String firstName) {
        enterTextTo(addressFirstNameTextInput, firstName);
    }

    public String getAddressFirstName() {
        return getTextFrom(addressFirstNameTextInput);
    }

    public void enterAddressLastName(String lastName) {
        enterTextTo(addressLastNameTextInput, lastName);
    }

    public String getAddressLastName() {
        return getTextFrom(addressLastNameTextInput);
    }

    public void enterAddressCompany(String company) {
        enterTextTo(addressCompanyTextInput, company);
    }

    public void enterAddress(String address) {
        enterTextTo(addressTextInput, address);
    }

    public void enterAddressCity(String city) {
        enterTextTo(addressCityTextInput, city);
    }

    public void selectAddressState(String state) {
        selectFromDropdownByText(addressStateDropdown, state);
    }

    public void enterAddressPostalCode(String postalCode) {
        enterTextTo(addressPostCodeTextInput, postalCode);
    }

    public void selectAddressCountry(String country) {
        selectFromDropdownByText(addressCountryDropdown, country);
    }

    public void selectAddressCountry() {
        selectFromDropdownByText(addressCountryDropdown, "United States");
    }

    public void enterAdditionalInformation(String information) {
        enterTextTo(additionalInformationTextInput, information);
    }

    public void enterHomePhone(String homePhone) {
        enterTextTo(homePhoneTextInput, homePhone);
    }

    public void enterMobilePhone(String mobilePhone) {
        enterTextTo(mobilePhoneTextInput, mobilePhone);
    }

    public String getAlias() {
        return getTextFrom(aliasTextInput);
    }

    public void enterAlias(String alias) {
        enterTextTo(aliasTextInput, alias);
    }

    public void register() {
        clickOnElement(submitRegisterButton);
    }
}
