package base.tests;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.SignUpPage;
import static base.tests.DriverSetUp.getChromeDriver;
public class BaseTests {
    public static final String BASE_URL="https://c24test.raiffeisen.al/Retail/home/login";
    public static WebDriver driver;
    public SignUpPage signUpPage;
    @BeforeEach
     void setUp() {
        driver=getChromeDriver();
        SignUpPage signUpPage=new SignUpPage(driver);
    }
    @AfterEach
    void cleanUp() {
        driver.quit();
    }
}

