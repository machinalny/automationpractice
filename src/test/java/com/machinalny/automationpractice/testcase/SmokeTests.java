package com.machinalny.automationpractice.testcase;

import com.machinalny.automationpractice.page.CreateAccountPage;
import com.machinalny.automationpractice.page.MainPage;
import com.machinalny.automationpractice.page.SignInPage;
import com.machinalny.automationpractice.utils.Gender;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class SmokeTests extends BaseTest {

    // DANE TESTOWE
    private String email = "user@2w53.com";
    private String password = "hasloLL1";

    Logger logger = Logger.getLogger("SmokeTests");

    @BeforeTest
    public void setupTest(){
        super.setupTest();
        this.driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void testCreateAnAccount(){
        // Click on signIn on the main page
        MainPage mainPage = new MainPage(this.driver);
        mainPage.signIn();

        // Create a new account
        SignInPage signInPage = new SignInPage(this.driver);
        signInPage.enterEmailForNewAccount(email);
        signInPage.createAnAccount();

        // Fill up a new user form
        CreateAccountPage createAccountPage = new CreateAccountPage(this.driver);
        createAccountPage.selectTitle(Gender.MR);
        createAccountPage.enterFirstName("Tester");
        createAccountPage.enterLastName("Automator");
        createAccountPage.enterPassword(password);
        createAccountPage.selectDayOfBirth("1");
        createAccountPage.selectMonthOfBirth("7");
        createAccountPage.selectYearOfBirth("1993");
        createAccountPage.selectNewsletter();
        createAccountPage.enterAddressCompany("Company");
        createAccountPage.enterAddress("Company Address");
        createAccountPage.enterAddressCity("Wrocław");
        createAccountPage.selectAddressState("Alabama");
        createAccountPage.enterAddressPostalCode("00000");
        createAccountPage.selectAddressCountry();
        createAccountPage.enterHomePhone("712123123");
        createAccountPage.enterMobilePhone("712123123");
        createAccountPage.register();

        // Check that a user was created
        Assert.assertEquals("My account - My Store", driver.getTitle(), "A new User was not created");
    }
}
