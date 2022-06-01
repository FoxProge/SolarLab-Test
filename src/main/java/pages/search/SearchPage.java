package pages.search;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SearchPage {
    protected WebDriver driver;
    Logger log = LogManager.getLogger(SearchPage.class);

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }
    //находим для того, чтобы снять галочку с 223-ФЗ
    private final By fz_223 = By.xpath("//div[@class='grid-column-4-1']//label[text()='223-ФЗ']");
    //находим для того, чтобы поставить галочку в 615-ПП РФ
    private final By pprf_615 = By.xpath("//div[@class='grid-column-4-1']//label[text()='615-ПП РФ']");
    private final By searchSettingsBtn = By.xpath("//div[@class='main-search__settings']");
    private final By regionBtn = By.xpath("//div[text()='Регион поставки']");
    private final By altayLbl = By.xpath("//div[@class='modal-settings-row']//label[text()='Алтайский край']");
    private final By excludeCoopBuy = By.xpath("//div[@class='grid-column-4-1']//label[text()='Исключить совместные закупки']");
    private final By dateFilter = By.xpath("//div[text()='Фильтры по датам']");
    private final By inputDatePicker = By.xpath("//*[@id='ftfbn-portal']/div[2]/div/div/div/div[1]/div[5]/div[12]/div[2]/div/div/div[1]/div[2]/div[3]");
    private final By dateNowBtn = By.xpath("//div[@aria-label='Choose вторник, 31 мая 2022 г.']");
    //находим для того, чтобы снять галочку с checkBox 'Активные'
    private final By statusActiveCheckBox = By.xpath("//div[@class='grid-column-4-1 grid-column-2']//label[text()='Активные']");
    private final By goFindBtn = By.xpath("//button[@class='search__btn bottomFilterSearch']");

    public void pprf_615_Click(){
        driver.findElement(pprf_615).click();
    }
    public void fz_223_Click(){
        driver.findElement(fz_223).click();
    }
    public void searchSettingsBtn_Click(){
        driver.findElement(searchSettingsBtn).click();
    }
    public void regionBtn_Click(){
        driver.findElement(regionBtn).click();
    }
    public void altayLbl_Click(){
        driver.findElement(altayLbl).click();
    }
    public void excludeCoopBuy_Click(){
        driver.findElement(excludeCoopBuy).click();
    }
    public void dateFilter_Click(){
        driver.findElement(dateFilter).click();
    }
    public void inputDatePicker_Click(){
        driver.findElement(inputDatePicker).click();
    }
    public void dateNowBtn_Click(){
        driver.findElement(dateNowBtn).click();
    }
    public void statusActiveCheckBox_Click(){
        driver.findElement(statusActiveCheckBox).click();
    }
    public void goFindBtn_Click(){
        driver.findElement(goFindBtn).click();
    }
    public void saveDataToFile(){
        try (FileWriter writer = new FileWriter("Data.txt", false)){

            List<WebElement> num_of_purchases = driver.findElements(By.xpath("//div[@class='card-item']"));
            List<WebElement> price_list = driver.findElements(By.xpath("//div[@itemprop='price']"));

            writer.write("Количество закупок: " + num_of_purchases.size() + "\n");
            int sum = 0;
            for(int i = 0; i < price_list.size(); i++){
                String price = price_list.get(i).getText();
                writer.write("Товар №" + i + "; Цена: " + price + "\n");
                System.out.println("Товар №" + i + "; Цена: " + price + "\n");

                int num = Integer.parseInt(
                        price
                                .substring(0, price.length()-5)
                                .replaceAll(" ", ""));
                sum+=num;
            }
            log.log(Level.INFO,"Общая сумма: " + String.valueOf(sum));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
