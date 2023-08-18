package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By username=By.xpath("//*[@id='panelUsernamePassword']//input[@type='text']");
    private By password=By.xpath("//div[@id='panelUsernamePassword']//input[@type='password']");
    private By logInButton=By.xpath("//div[@id='panelUsernamePassword']//button");

    public void waitForSpinner() {
        WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitDriver.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner"))
        );
    }

    public void logInDetails(String userN,String pass){
        waitForSpinner();
        driver.findElement(username).sendKeys(userN);
        driver.findElement(password).sendKeys(pass);
    }
    public void logInWithEmptyFields(){
        waitForSpinner();
        driver.findElement(logInButton).click();
    }
    public HomePage clickButton(){
        waitForSpinner();
        driver.findElement(logInButton).click();
        return new HomePage(driver);
    }

}
