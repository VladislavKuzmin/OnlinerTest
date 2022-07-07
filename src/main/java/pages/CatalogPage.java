package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CatalogPage extends BasePage{

    By electronicsButton = By.xpath("//span[contains(text(),'Электроника')]");
    By phonesPanel = By.xpath("//div[contains(text(),'Мобильные телефоны')]");
    By smartPhonesButton = By.xpath("//a[@href='https://catalog.onliner.by/mobile']");

    By appleCheckBox = By.xpath("//span[contains(text(), 'Apple') and @class='schema-filter__checkbox-text']");
    By priceLabel = By.xpath("//div[@class='schema-product__price']//span");
    By phoneModelLabel = By.xpath("//div[@class='schema-product__title']//span");

    String priceUpdateChecker;

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
        priceUpdateChecker = findElement(priceLabel).getText();
        click(appleCheckBox);

        return this;
    }

    public CatalogPage waitForPriceToUpdate(){
        wait.until(ExpectedConditions.invisibilityOfElementWithText(priceLabel,priceUpdateChecker));
        return this;
    }

    public String getPhoneModel(){
        return getText(phoneModelLabel);
    }

    public String getPrice(){
        return  getText(priceLabel).replaceAll("[. р]", "").replace(',','.');
    }
}
