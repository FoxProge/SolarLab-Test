package pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private final By supplierBtn = By.xpath("//nav[@class=\"nav nav-223-fz\"]/ul[@class=\"nav-platform\"]/li[1]");

    public void goToSuppliersPage(){
        driver.findElement(supplierBtn).click();
    }

}
