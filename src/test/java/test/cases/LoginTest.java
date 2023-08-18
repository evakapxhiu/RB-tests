package test.cases;

import base.tests.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTests {

    @Test
    public void logInSuccessful(){
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS);
        LoginPage loginPage=new LoginPage(driver);
        loginPage.logInDetails("stuart","Test123");
        HomePage homePage=loginPage.clickButton();
        assertTrue(homePage.isLogIn());
    }
    @Test
    public void logInUnsuccessful(){
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS);
        LoginPage loginPage=new LoginPage(driver);
        loginPage.logInWithEmptyFields();
        WebElement message=driver.findElement(By.xpath("//*[@id='panelUsernamePassword']//*[@class='error-container']"));
        assertEquals("Username is required.,Password is required.",message.getText());
    }
}
