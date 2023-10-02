package test.cases;
import base.tests.BaseTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.LoginPage;
import static org.junit.jupiter.api.Assertions.*;
public class LoginTest extends BaseTests {
    private LoginPage loginPage;
    private HomePage homePage;
    @BeforeEach
    public void beforeEach() {
        driver.get(BASE_URL);
        loginPage=new LoginPage(driver);
    }
    @Test
    public void logInSuccessfulTest() {
        loginPage.logInDetails("bobbie","Test123");
        homePage=loginPage.clickButton();
        assertTrue(homePage.isLogIn());
    }
    @Test
    public void logInUnsuccessfulTest() {
        loginPage.logInWithEmptyFields();
        WebElement message=driver.findElement(By.xpath("//*[@id='panelUsernamePassword']//*[@class='error-container']"));
        assertEquals("Username is required.,Password is required.",message.getText());
    }
    @Test
    public void loginWithEmptyUsernameFieldTest() {
        loginPage.loginWithEmptyUsernameField("Test123");
        WebElement message=driver.findElement(By.xpath("//*[@id='panelUsernamePassword']//*[@class='error-container']"));
        assertEquals("Username is required.",message.getText());
    }
    @Test
    public void loginWithEmptyPasswordFieldTest() {
        loginPage.loginWithEmptyPassField("bobbie");
        WebElement message=driver.findElement(By.xpath("//*[@id='panelUsernamePassword']//*[@class='error-container']"));
        assertEquals("Password is required.",message.getText());
    }
    @Test
    public void logInWithWrongCredentialsTest() {
        loginPage.logInWithWrongCredentials("eva","pass");
        homePage=loginPage.clickButton();

        WebElement message=driver.findElement(By.xpath("//div[@id='panelUsernamePassword']//*[text()='Wrong input data.']"));
        assertEquals( "Wrong input data.",message.getText());
    }
}
