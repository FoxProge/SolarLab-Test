package pages.supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SupplierPage{
    protected WebDriver driver;

    public SupplierPage(WebDriver driver){
        this.driver = driver;
    }

    private final By searchBtn = By.xpath("//div[@class=\"service__item\"]/a[@href=\"/poisk/poisk-223-fz/\"]");

    public void goToSearchPage(){
        driver.findElement(searchBtn).click();
    }
}
