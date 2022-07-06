package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CatalogPage extends BasePage{

    By electronicsButton = By.xpath("//li[@data-id='1']");
    By phonesPanel = By.xpath("//*[@id='container']/div/div/div/div/div[1]/div[4]/div/div[2]/div[1]/div/div[1]/div[1]");
    By smartPhonesButton = By.xpath("//a[@href='https://catalog.onliner.by/mobile']");
    //By appleCheckBox = By.xpath("//input[@value='apple']");
    By appleCheckBox = By.xpath("//*[@id='schema-filter']/div[5]/div[4]/div[2]/ul/li[1]/label");
    By priceTextBox = By.xpath("//*[@id='schema-products']/div[2]/div/div[3]/div[1]/div/div/div[1]/div[1]/a/span");
    By phoneModelButton = By.xpath("//a[@class='js-product-title-link'][1]");  //!

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
        scroll();
        return this;
    }

    public CatalogPage pressAppleCheckBox(){
        click(appleCheckBox);
        return this;
    }

    public CatalogPage pressPhoneModelButton(){
        click(phoneModelButton);
        return this;
    }

    public String getPrice(){
        return findElement(priceTextBox).getText().replaceAll("[,. р]", "");
    }
}
