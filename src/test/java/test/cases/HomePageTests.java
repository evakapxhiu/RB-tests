package test.cases;
import base.tests.BaseTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AccountsPage;
import pages.BillsPage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HomePageTests extends BaseTests {
    private LoginPage loginPage;
    private AccountsPage accountsPage;
    private BillsPage billsPage;
    private HomePage homePage;
    @BeforeEach
    public void beforeEach() {
        driver.get(BASE_URL);
        loginPage=new LoginPage(driver);
        accountsPage=new AccountsPage(driver);
        homePage=new HomePage(driver);
        billsPage=new BillsPage(driver);
        loginPage.logInDetails("stuart","Test123");
        loginPage.clickButton();
}
    //HOME PAGE , TOP MENU BAR
    @Test
    public void makePaymentIsCLickable() {
        homePage.clickMakePayment();
    }
    @Test
    public void accountsPageIsDisplayedTest() {
        homePage.clickCheckMyAccounts();
        assertTrue(accountsPage.accountsPageIsDisplayed());
    }
    @Test
    public void billsPAgeIsDisplayedTest() {
        homePage.clickPayBills();
        assertTrue(billsPage.billsPageIsDisplayed());
    }
    //LIST WITH MY ACCOUNTS (SHOW MORE ACCOUNTS)
    @Test
    public void showMoreButtonIsClickableTest() {
        homePage.clickShowMoreButton();
        assertTrue(homePage.hideButtonIsDisplayed());
        homePage.clickHideButton();
    }
}
