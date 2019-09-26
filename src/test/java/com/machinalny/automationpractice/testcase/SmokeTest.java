package com.machinalny.automationpractice.testcase;

import com.machinalny.automationpractice.page.CreateAccountPage;
import com.machinalny.automationpractice.page.MainPage;
import com.machinalny.automationpractice.page.MyAccountPage;
import com.machinalny.automationpractice.page.SignInPage;
import com.machinalny.automationpractice.utils.Gender;
import com.machinalny.automationpractice.utils.JSONDataProvider;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.xml.bind.DatatypeConverter;
import java.util.Calendar;
import java.util.logging.Logger;

public class SmokeTest extends BaseTest {

    Logger logger = Logger.getLogger("SmokeTests");
    // DANE TESTOWE
    private String email = "user@2w53.com";
    private String password = "hasloLL1";

    @BeforeTest
    public void setupTest() {
        super.setupTest();
        this.driver.get("http://automationpractice.com/index.php");
    }

    @Test(dataProvider = "fetchUser_JSON", dataProviderClass = JSONDataProvider.class, enabled = true)
    public void testCreateAnAccount(String rowID,
                                    JSONObject testData) {
        logger.info("Row id of the data " + rowID);
        // Click on signIn on the main page
        MainPage mainPage = new MainPage(this.driver);
        mainPage.signIn();

        // Create a new account
        SignInPage signInPage = new SignInPage(this.driver);
        signInPage.enterEmailForNewAccount(testData.get("email").toString());
        signInPage.createAnAccount();

        // Fill up a new user form
        CreateAccountPage createAccountPage = new CreateAccountPage(this.driver);
        createAccountPage.selectTitle(Gender.valueOf(testData.get("gender").toString()));
        createAccountPage.enterFirstName(testData.get("first_name").toString());
        createAccountPage.enterLastName(testData.get("last_name").toString());
        createAccountPage.enterPassword(testData.get("password").toString());
        Calendar birthdayDate = DatatypeConverter.parseDateTime(testData.get("birthday").toString());

        createAccountPage.selectDayOfBirth(Integer.toString(birthdayDate.get(Calendar.DAY_OF_MONTH)));
        createAccountPage.selectMonthOfBirth(Integer.toString(birthdayDate.get(Calendar.MONTH) + 1));
        createAccountPage.selectYearOfBirth(Integer.toString(birthdayDate.get(Calendar.YEAR)));
        if (Boolean.parseBoolean(testData.get("newsletter").toString())) {
            createAccountPage.selectNewsletter();
        }

        createAccountPage.enterAddressCompany(testData.get("company_name").toString());
        createAccountPage.enterAddress(testData.get("address").toString());
        createAccountPage.enterAddressCity(testData.get("city").toString());
        createAccountPage.selectAddressState(testData.get("state").toString());
        createAccountPage.enterAddressPostalCode(testData.get("postal_code").toString());
        createAccountPage.selectAddressCountry();
        createAccountPage.enterHomePhone(testData.get("phone").toString());
        createAccountPage.enterMobilePhone(testData.get("phone").toString());
        createAccountPage.register();

        // Check that a user was created
        Assert.assertEquals("My account - My Store", driver.getTitle(), "A new User was not created");
        MyAccountPage myAccountPage = new MyAccountPage(this.driver);
        myAccountPage.signOut();

    }
}
