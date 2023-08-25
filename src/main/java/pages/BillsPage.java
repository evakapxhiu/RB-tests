package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BillsPage {
    private WebDriver driver;
    @FindBy(how= How.CLASS_NAME,
            using = "s-page")
    private WebElement billsPageContent;
    public BillsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public boolean billsPageIsDisplayed() {
        try {
           return billsPageContent.isDisplayed();
        }catch (Exception e){
            e.getStackTrace();
            return false;
        }
    }
}
