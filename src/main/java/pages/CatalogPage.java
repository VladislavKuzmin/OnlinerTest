package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CatalogPage extends BasePage{

    By electronicsButton = By.xpath("//li[@data-id='1']");
    By phonesPanel = By.xpath("//*[@id='container']/div/div/div/div/div[1]/div[4]/div/div[2]/div[1]/div/div[1]/div[1]");
    By smartPhonesButton = By.xpath("//a[@href='https://catalog.onliner.by/mobile']");
    //By appleCheckBox = By.xpath("//input[@value='apple']");
    By appleCheckBox = By.xpath("//*[@id='schema-filter']/div[5]/div[4]/div[2]/ul/li[1]/label");
    By priceLabel = By.xpath("//*[@id='schema-products']/div[2]/div/div[3]/div[1]/div/div/div[1]/div[1]/a/span");
    By phoneModelLabel = By.xpath("//span[@data-bind='html: product.extended_name || product.full_name']");  //!

    String str;

    public CatalogPage(WebDriver driver){
        super(driver);
    }

    public CatalogPage pressElectronicsButton(){
        click(electronicsButton);
        return this;
    }

    public CatalogPage moveToPhones(){
        click(phonesPanel);
        return this;
    }

    public CatalogPage pressSmartPhonesButton(){
        click(smartPhonesButton);
        return this;
    }

    public CatalogPage scrollToAppleCheckBox(){
        scrollBy300();
        return this;
    }

    public CatalogPage pressAppleCheckBox(){
        str = findElement(priceLabel).getText();
        click(appleCheckBox);

        return this;
    }

    public String getPhoneModel(){
        return getText(phoneModelLabel);
    }

    public CatalogPage waitForPriceToUpdate(){
        wait.until(ExpectedConditions.invisibilityOfElementWithText(priceLabel,str));
        return this;
    }

    public String getPrice(){
        return getText(priceLabel).replaceAll("[,. р]", "");
    }
}
