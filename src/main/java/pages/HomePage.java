package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constants.OrderButtonPlacement.ORDER_BUTTON_BOTTOM;
import static constants.OrderButtonPlacement.ORDER_BUTTON_TOP;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String resultText; // Сюда записывается текст вопроса
    public String resultAnswer; // Сюда записывается текст ответа

    // Вопросы и открывающиеся тексты
    private By questionI = By.xpath(".//div[@class='accordion__heading']");
    private By answerI = By.xpath(".//div[@class='accordion__panel']");
    // Кнопка "Принять куки"
    private By cookAcceptButton = By.id("rcc-confirm-button");

    // Кнопки "Заказать"
    private By orderButtonTop = By.xpath(".//div[@class='Header_Header__214zg']//button[text()='Заказать']");
    private By orderButtonBottom = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");

    // Принятие кук
    public void acceptCookies() {
        driver.findElement(cookAcceptButton).click(); // Принятие кук
    }

    // Клик по кнопке "Заказать"
    public void pushOrderButton(String orderButtonSelect) {
        if (orderButtonSelect.equals(ORDER_BUTTON_TOP)) {
            driver.findElement(orderButtonTop).click();
        }
        else if (orderButtonSelect.equals(ORDER_BUTTON_BOTTOM)) {
            driver.findElement(orderButtonBottom).click();
        }
    }
    // Клик на вопрос
    public void questionClick(int questionCounter) {
        driver.findElements(questionI).get(questionCounter).click();
    }
    // Получение текста вопроса
    public String questionGetText(int questionCounter) {
        resultText = driver.findElements(questionI).get(questionCounter).getText();
        return resultText;
    }
    // Получение текста ответа
    public String questionGetAnswer(int questionCounter) {
        resultAnswer = driver.findElements(answerI).get(questionCounter).getText();
        return resultAnswer;
    }

}
