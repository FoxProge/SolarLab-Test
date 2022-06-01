package tests.test_task_1.stepDefinitions;

import common.CommonActions;
import constants.Constant;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import pages.home.HomePage;
import pages.search.SearchPage;
import pages.supplier.SupplierPage;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;

public class Steps {
    private WebDriver driver;
    private HomePage homePage;
    private SearchPage searchPage;
    private SupplierPage supplierPage;

    @Given("Пользователь открывает браузер")
    public void пользовательОткрываетБраузер() {
        driver = CommonActions.createDriver();
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        supplierPage = new SupplierPage(driver);
    }

    @And("Переходит на сайт rts-tender.ru")
    public void переходитНаСайтRtsTenderRu() {
        driver.get(Constant.Urls.RTS_TENDER_HOME_PAGE);
    }

    @When("Пользователь нажимает на кнопку Поставщикам внизу сайта")
    public void пользовательНажимаетНаКнопкуПоставщикамВнизуСайта() {
        homePage.goToSuppliersPage();
    }

    @And("Нажимает кнопку Расширенный поиск")
    public void нажимаетКнопкуРасширенныйПоиск() {
        supplierPage.goToSearchPage();
    }

    @And("Нажимает кнопку Настройки поиска")
    public void нажимаетКнопкуНастройкиПоиска() {
        searchPage.searchSettingsBtn_Click();
    }

    @And("снимает галочку с ФЗ")
    public void снимаетГалочкуСФЗ() {
        searchPage.fz_223_Click();
    }

    @And("ставит галочку на ПП РФ")
    public void ставитГалочкуНаППРФ() {
        searchPage.pprf_615_Click();
    }

    @And("выбирает фильтр: Исключить совместные покупки")
    public void выбираетФильтрИсключитьСовместныеПокупки() {
        searchPage.excludeCoopBuy_Click();
    }

    @And("нажимает кнопку Регион поставки")
    public void нажимаетКнопкуРегионПоставки() {
        searchPage.regionBtn_Click();
    }

    @And("выбирает регион - Алтайский край")
    public void выбираетРегионАлтайскийКрай() {
        searchPage.altayLbl_Click();
    }

    @And("нажимает кнопку  фильтр по дате")
    public void нажимаетКнопкуФильтрПоДате() {
        searchPage.dateFilter_Click();
    }

    @And("настраивает даты подачи заявок, указывая сегодняшнюю дату")
    public void настраиваетДатыПодачиЗаявокУказываяСегодняшнююДату() {
        searchPage.inputDatePicker_Click();
        searchPage.dateNowBtn_Click();
    }

    @And("исключает активные закупки")
    public void исключаетАктивныеЗакупки() {
        searchPage.statusActiveCheckBox_Click();
    }

    @And("нажимает кнопку Найти")
    public void нажимаетКнопкуНайти() {
        searchPage.goFindBtn_Click();
    }

    @Then("Найденные данные сохраняются в файл")
    public void найденныеДанныеСохраняютсяВФайл() {
        searchPage.saveDataToFile();
    }
    //после прохождения сценария очищает куки и историю браузера, а также выходит из браузера
    @After
    public void clearCookiesAndHistoryAndCloseBrowser(){
        if(CLEAR_COOKIES_AND_STORAGE){
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
        driver.close();
        driver.quit();
    }
}
