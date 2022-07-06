package Tests;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

public class Test {

    static WebDriver driver;

    String urlToTest = "https://www.onliner.by/";

    @BeforeAll
    public static void start(){
        System.setProperty("webdriver.chrome.driver", "chromedriver1.exe");
    }

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(urlToTest);

    }

    @AfterEach
    public void tearDown(){
       // driver.quit();
    }

    @AfterAll
    public static void end(){
        System.out.println("Tests ended");
    }

    @org.junit.jupiter.api.Test
    public void priceMatch_TEST(){
        MainPage mainPage = new MainPage(driver);

        int actualPrice = Integer.parseInt(
                mainPage.pressCatalogButton()
                .pressElectronicsButton()
                .moveToPhones()
                .pressSmartPhonesButton()
                .scrollToAppleCheckBox()
                .pressAppleCheckBox()
                        .pressPhoneModelButton()
                .getPrice());

        Assert.isTrue(actualPrice > 100, "арр");
    }
}
