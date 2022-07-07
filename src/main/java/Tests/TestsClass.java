package Tests;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CatalogPage;
import pages.MainPage;

public class TestsClass {

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
        driver.quit();
    }

    @AfterAll
    public static void end(){
        System.out.println("The tests are over");
    }

    @Test
    public void verifyPriceAmount_TEST(){
        MainPage mainPage = new MainPage(driver);

        double actualPrice = Double.parseDouble(
                mainPage.pressCatalogButton()
                .pressElectronicsButton()
                .moveToPhones()
                .pressSmartPhonesButton()
                .scrollToAppleCheckBox()
                .pressAppleCheckBox()
                .waitForPriceToUpdate()
                .getPrice());

        System.out.println(actualPrice);

        if(new CatalogPage(driver).getPhoneModel().contains("iPhone")){
            Assert.isTrue(actualPrice > 100, "The price should be more than 100 BYN");
        }
    }


}
