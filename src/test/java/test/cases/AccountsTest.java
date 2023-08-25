package test.cases;
import base.tests.BaseTests;
import org.junit.jupiter.api.BeforeEach;
import pages.AccountsPage;
import pages.HomePage;
public class AccountsTest extends BaseTests {
    private HomePage homePage;
    private AccountsPage accountsPage;
    @BeforeEach
    public void beforeEach() {
        driver.get(BASE_URL);
        homePage=new HomePage(driver);
        accountsPage=new AccountsPage(driver);
    }
}
