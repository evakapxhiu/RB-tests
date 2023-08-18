package base.tests;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static base.tests.DriverSetUp.getChromeDriver;
public class BaseTests {
    public static final String BASE_URL="https://c24test.raiffeisen.al/Retail/home/login";
    public static WebDriver driver;

    @BeforeEach
     void setUp(){
        driver=getChromeDriver();
    }
    @AfterEach
    void cleanUp(){
        driver.quit();
    }
}



//    public static void takeScreenshot(){
//        var camera=(TakesScreenshot)driver;
//        File screenshot=camera.getScreenshotAs(OutputType.FILE);
//        System.out.println("Screenshots taken : " +screenshot.getAbsolutePath());
//        try {
//            Files.move(screenshot,new File("resources/screenshots/test.png"));
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//    }
