package test.cases;
import base.tests.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTests extends BaseTests {
    @Test
    public void testMyAccountsList(){
        driver.get(BASE_URL);
        HomePage homePage=new HomePage(driver);
        LoginPage loginPage=new LoginPage(driver);
        loginPage.logInDetails("stuart","Test123");
        loginPage.clickButton();
        homePage.clickShowMoreAccounts();
        assertTrue(homePage.hideButtonIsVisible());
        assertEquals(homePage.listWithAccountsIsVisible(),"[8]");
        System.out.println(homePage.listWithAccountsIsVisible());
    }

    @Test
public void clickPayButton(){
        driver.get(BASE_URL);
        HomePage homePage=new HomePage(driver);
        LoginPage loginPage=new LoginPage(driver);
        loginPage.logInDetails("stuart","Test123");
        loginPage.clickButton();
        List<Integer>  accounts=homePage.listWithAccountsIsVisible();
        for (int i=0;i<accounts.size();i++){
            homePage.clickButton();
            Assertions.assertTrue(homePage.payments());
            driver.navigate().back();
            homePage.clickShowMoreAccounts();
            System.out.println("Current account size: " + accounts.get(i));
        }
    }
}
