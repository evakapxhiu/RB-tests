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
public class SignUpPage {
    private WebDriver driver;
    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(how = How.XPATH,
            using = "//input[@data-bind='value: name']")
    private WebElement firstName;
    @FindBy(how=How.XPATH,
            using = "//input[@data-bind='value: lastName']")
    private WebElement lastName;
    @FindBy(how = How.XPATH,
            using = "//input[@data-bind='value: personalNumber']")
    private WebElement personalNumber;
    @FindBy(how=How.XPATH,
            using = "//input[@type='tel']")
    private WebElement mobileNumber;
   @FindBy(how=How.XPATH,
           using = "//input[@data-bind='value: email']")
    private WebElement email;
   @FindBy(how=How.XPATH,
           using = "//input[@data-bind='checked: termsAndConditionsAccepted']")
   private WebElement agreeCheckButton;
   @FindBy(how=How.XPATH,
           using="//button[@data-bind='click: onGetTicketPersonalData']")
   private WebElement nextButton;
   @FindBy(how=How.XPATH,
           using = "//a[@data-method='changeTabs']")
   private WebElement changeTabs;
    public void signUpWithEmptyFields() {
        waitForSpinner();
        changeTabs();
        clickNextButton();
    }
    public void signUpWithInvalidMobNumberAndEmail(String name,String lName,String personalNo,String mob,String em) {
        waitForSpinner();
        changeTabs();
        firstName.sendKeys(name);
        lastName.sendKeys(lName);
        personalNumber.sendKeys(personalNo);
        mobileNumber.sendKeys(mob);
        email.sendKeys(em);
        clickAgreeButton();
        clickNextButton();
    }
    //----General Methods-----
    public void clickNextButton() {
        waitForSpinner();
        nextButton.click();
    }
    public void waitForSpinner() {
        WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitDriver.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner")));
    }
    public void changeTabs() {
        waitForSpinner();
        changeTabs.click();
    }
    public void clickAgreeButton() {
        waitForSpinner();
        agreeCheckButton.click();
    }
}
