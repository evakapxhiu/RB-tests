package test.cases;
import base.tests.BaseTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.SignUpPage;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class SignUpTest extends BaseTests {
    @BeforeEach
    public void beforeEach() {
        driver.get(BASE_URL);
        signUpPage=new SignUpPage(driver);
    }
    @Test
    public void signUpUnsuccessfulTest() {
        signUpPage.signUpWithEmptyFields();
        WebElement message=driver.findElement(By.xpath("//span[contains(@class,'validationMessage')]"));
       assertEquals("This field is reqired!",message.getText());
    }
    @Test
    public void signUpWithInvalidMobNumberTest() {
        signUpPage.signUpWithInvalidMobNumberAndEmail("Eva","Kapxhiu","K1234567K","3456tgfgf","test@gmail.com");
        WebElement message=driver.findElement(By.xpath("//span[@class='validationMessage'][text()='Invalid mobile number']"));
        assertEquals("Invalid mobile number",message.getText());
    }
    @Test
    public void signUpWithInvalidEmailTest() {
        signUpPage.signUpWithInvalidMobNumberAndEmail("Eva","Kapxhiu","K1234567K","0645122343","prov");
        WebElement message=driver.findElement(By.xpath( "(//span[@class='validationMessage'])[5]"));
        assertEquals("Please supply valid email address!",message.getText());
    }
}
