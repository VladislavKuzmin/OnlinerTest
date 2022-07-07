package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{

    By catalogButton = By.xpath("//a[contains(text(),'Каталог')]");

    public MainPage(WebDriver driver){
        super(driver);
    }

    public CatalogPage pressCatalogButton(){
        click(catalogButton);
        return new CatalogPage(driver);
    }
}
