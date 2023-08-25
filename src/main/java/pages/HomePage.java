package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(how=How.CLASS_NAME,
            using = "menu-open")
    private WebElement homePage;
    public boolean isLogIn() {
        waitForSpinner();
        try {
            return homePage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    //HOME PAGE , TOP MENU BAR
    @FindBy(how=How.XPATH,
            using = "//ul[@class='top-actions']//a[@data-bind='attr: { href: url1 }']")
    private WebElement myAccountButton;
    @FindBy(how = How.XPATH,
            using = "//ul[@class='top-actions']//li[3]")
    private WebElement payBillsButton;
    public AccountsPage clickCheckMyAccounts() {
        waitForSpinner();
        myAccountButton.click();
        return new AccountsPage(driver);
    }
    public BillsPage clickPayBills() {
        waitForSpinner();
        payBillsButton.click();
        return new BillsPage(driver);
    }
    //LIST WITH MY ACCOUNTS (SHOW MORE ACCOUNTS)
    @FindBy(how=How.XPATH,
            using = "//ul[@class='top-actions']//li[2]")
    private WebElement makePaymentButton;
    @FindBy(how=How.XPATH,
            using = "//a[@data-bind='click: showMoreAccounts']")
    private WebElement showMoreButton;
    @FindBy(how=How.XPATH,
            using = "//*[@class='less'][text()='Hide accounts']")
    private WebElement hideButton;
    public void clickMakePayment(){
        makePaymentButton.click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(makePaymentButton));
    }
    public void clickShowMoreButton() {
        waitForSpinner();
     showMoreButton.click();
    }
    public void clickHideButton() {
        hideButton.click();
    }
    public boolean hideButtonIsDisplayed(){
        try {
            return hideButton.isDisplayed();
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
