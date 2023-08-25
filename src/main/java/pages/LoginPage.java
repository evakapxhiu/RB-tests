package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(how= How.XPATH,
            using = "//*[@id='panelUsernamePassword']//input[@type='text']")
    private WebElement username;
    @FindBy(how=How.XPATH,
            using = "//div[@id='panelUsernamePassword']//input[@type='password']")
    private WebElement password;
   @FindBy(how=How.XPATH,
           using = "//div[@id='panelUsernamePassword']//button")
    private WebElement logInButton;
    public void logInDetails(String userN,String pass) {
        waitForSpinner();
        username.sendKeys(userN);
        password.sendKeys(pass);
    }
    public void logInWithEmptyFields() {
        waitForSpinner();
        clickButton();
    }
    public void loginWithEmptyUsernameField(String pass) {
        waitForSpinner();
        password.sendKeys(pass);
        clickButton();
    }
    public void loginWithEmptyPassField(String usern) {
        waitForSpinner();
        username.sendKeys(usern);
        clickButton();
    }
    public void logInWithWrongCredentials(String name,String pass) {
        waitForSpinner();
        username.sendKeys(name);
        password.sendKeys(pass);
    }
    //---generalMethods----
    public HomePage clickButton() {
        waitForSpinner();
        logInButton.click();
        return new HomePage(driver);
    }
    public void waitForSpinner() {
        WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitDriver.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner")));
    }
}
