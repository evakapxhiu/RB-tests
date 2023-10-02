package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class SignUpPage {
    private WebDriver driver;
    private WebDriverWait waitDriver;

    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.waitDriver = new WebDriverWait(driver, Duration.ofSeconds(20));
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
           using = "//a[contains(@data-resource-key,'HolosRetailLogin.signup')]")
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
    @FindBy(how=How.XPATH,
    using = "//div[contains(@class,'popup-box')]")
    private WebElement popUp;
    @FindBy(how=How.XPATH,
            using="(//span[contains(@class,'question-icon')])[1]")
    private WebElement personalNumberQuestionIcon;
    @FindBy(how=How.XPATH,
            using = "//h3[@data-resource-key='HolosRetailLogin.personalNumber']")
    private WebElement personalNumberTextHeader;
    @FindBy(how=How.TAG_NAME,
    using="img")
    private WebElement image;
    public void contextMenu(){
        changeTabs();
        waitDriver.until(ExpectedConditions.visibilityOf(personalNumberQuestionIcon));
        personalNumberQuestionIcon.click();
    }
    public boolean isPopUpDisplayed() {
        return popUp.isDisplayed();
    }
    public String popUpText() {
        return personalNumberTextHeader.getText();
    }
    public String image(){
        return image.getAttribute("src");
    }
}
