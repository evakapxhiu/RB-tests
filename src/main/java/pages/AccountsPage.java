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
public class AccountsPage {
    private WebDriver driver;
    public AccountsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(how= How.ID,
            using = "content_wrap")
    private WebElement accountPageContent;
    public boolean accountsPageIsDisplayed() {
        waitForSpinner();
        try {
            return accountPageContent.isDisplayed();
        }catch (Exception e){
            e.getStackTrace();
            return false;
        }
    }
    //----GENERAL METHODS----
    public void waitForSpinner() {
        WebDriverWait waitDriver=new WebDriverWait(driver, Duration.ofSeconds(20));
        waitDriver.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner")));
    }
}
