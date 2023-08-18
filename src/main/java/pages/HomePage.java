package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    private By homePage = By.className("menu-open");
    private By hideButton=By.xpath("//*[@data-resource-key='Widgets.AccountBalancePreview.HideAccounts']");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

        public void waitForSpinner(){
        WebDriverWait waitDriver=new WebDriverWait(driver, Duration.ofSeconds(20));
        waitDriver.until(
                ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner"))
        );
    }
    public boolean isLogIn() {
        waitForSpinner();
        try {
            return driver.findElement(homePage).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public void clickShowMoreAccounts(){
        waitForSpinner();
        WebDriverWait waitDriver=new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement show = driver.findElement(By.xpath("//a[@data-bind='click: showMoreAccounts']"));
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-bind='click: showMoreAccounts']")));
        show.click();
    }
    public boolean hideButtonIsVisible(){
        waitForSpinner();
        try {
            return driver.findElement(hideButton).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public List<Integer> listWithAccountsIsVisible(){
//        waitForSpinner();
        WebDriverWait waitDriver=new WebDriverWait(driver, Duration.ofSeconds(20));
        List<WebElement> accounts = driver.findElements(By.xpath("//ul[@data-bind='foreach: accounts']//li"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@data-bind='foreach: accounts']//li")));
        return Collections.singletonList(accounts.size());
    }
    public void clickButton(){
        waitForSpinner();
        WebDriverWait waitDriver=new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement buttonPay= driver.findElement(By.xpath("//a[@data-bind='click: $root.goToPayment']"));
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-bind='click: $root.goToPayment']")));
        buttonPay.click();
    }

    public boolean payments(){
        waitForSpinner();
        try {
            return driver.findElement(By.xpath("//*[@id='widget_148402']")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private Select findDropEle(){
        return new Select(driver.findElement(By.xpath("")));
    }
    public void selectDropDown(String option){
        findDropEle().selectByVisibleText(option);
    }
    public List<String> getSelectedOption(){
        List<WebElement> selectedEl = findDropEle().getAllSelectedOptions();
        return selectedEl.stream().map(e->e.getText()).collect(Collectors.toList());
    }


}
