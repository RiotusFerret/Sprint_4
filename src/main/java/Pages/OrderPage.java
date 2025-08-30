package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constants.Colours.BLACK;
import static constants.Colours.GREY;

public class OrderPage {

    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    // Поле "Имя"
    private By firstNameField = By.xpath(".//div[@class='Order_Form__17u6u']/div[1]/input");
    // Поле "Фамилия"
    private By secondNameField = By.xpath(".//div[@class='Order_Form__17u6u']/div[2]/input");
    // Поле "Адрес"
    private By adressField = By.xpath(".//div[@class='Order_Form__17u6u']/div[3]/input");
    // Поле "Станция метро"
    private By subwayStationField = By.xpath(".//div[@class='select-search__value']/input");
    // Выпадающий список станций
    private By getSubwayStation = By.xpath(".//div[@class='select-search__select']//div");
    // Поле "Телефон"
    private By phoneNumberField = By.xpath(".//div[@class='Order_Form__17u6u']/div[5]/input");
    // Кнопка "Далее"
    private By nextButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button");
    // Поле "Когда привезти"
    private  By deliveryDateField = By.xpath(".//div[@class='Order_MixedDatePicker__3qiay']/div/div/input");
    // Кнопка "Следующий месяц"
    private By nextMonthButton = By.xpath(".//div[@class='react-datepicker-popper']//button[2]");
    // Выбор недели
    private By weekSelection = By.className("react-datepicker__week");
    // Выбор дня
    private By daySelection = By.className("react-datepicker__day");
    // Выпадающий список "Срок аренды"
    private By rentPeriodButton = By.className("Dropdown-control");
    // Выбор длительности аренды (нужен счётчик)
    private By rentPeriodSelection = By.xpath(".//div[@class='Dropdown-option']");
    // Выбор цвета (нужен счётчик)
    private By colourSelection = By.xpath(".//input[@class='Checkbox_Input__14A2w']");
    // Кнопка "Заказать"
    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    // Кнопка "Да"
    private By yesButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    // Окно "Заказ оформлен"
    private By orderSuccess = By.xpath(".//div[text()='Заказ оформлен']");

    // Ввод в поле "Имя"
    public void firstNameInput(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    // Ввод в поле "Фамилия"
    public void secondNameInput(String secondName) {
        driver.findElement(secondNameField).sendKeys(secondName);
    }
    // Ввод в поле "Адрес"
    public void addressInput(String address) {
        driver.findElement(adressField).sendKeys(address);
    }
    // Клик по полю "Станция метро"
    public void subwayStationClick() {
        driver.findElement(subwayStationField).click();
    }
    // Ввод названия станции
    public void subwayStationInput(String subwayStation) {
        driver.findElement(subwayStationField).sendKeys(subwayStation);
    }
    // Выбор станции из выпадающего списка
    public void subwayStationSelection() {
        driver.findElements(getSubwayStation).get(1).click();
    }
    // Ввод в поле "Телефон"
    public void phoneNumberInput(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }
    // Клик по кнопке "Далее"
    public void nextButtonClick() {
        driver.findElement(nextButton).click();
    }
    // Клик по полю "Когда привезти"
    public void deliveryDateClick() {
        driver.findElement(deliveryDateField).click();
    }
    // Выбор месяца
    public void monthInput(int monthCount) {
        for(int i=0; i<monthCount; i++) {
            driver.findElement(nextMonthButton).click();
        }
    }
    // Выбор дня
    public void dayOfWeekSelection(int weekCount, int dayOfWeekCount) {
        driver.findElements(weekSelection).get(weekCount).findElements(daySelection).get(dayOfWeekCount).click();

    }
    // Клик по полю "Срок аренды"
    public void rentPeriodClick() {
        driver.findElement(rentPeriodButton).click();
    }
    // Выбор срока аренды
    public void rentPeriodSelection(int rentPeriodCount) {
        driver.findElements(rentPeriodSelection).get(rentPeriodCount).click();
    }
    // Выбор цвета
    public void colourSelection(String colour) {
        if(colour.equals(BLACK)) {
            driver.findElements(colourSelection).get(0).click();
        }
        else if(colour.equals(GREY)) {
            driver.findElements(colourSelection).get(1).click();
        }
    }
    // Клик по кнопке "Заказать"
    public void orderButtonClick() {
        driver.findElement(orderButton).click();
    }
    // Клик по кнопке "Да"
    public void yesButtonClick() {
        driver.findElement(yesButton).click();
    }
    // Проверка оформления заказа
    public void orderSuccessCheck() {
        driver.findElement(orderSuccess).isEnabled();
    }
}
