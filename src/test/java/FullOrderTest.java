import Pages.HomePage;
import Pages.OrderPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FullOrderTest extends BaseTest{
    private final String orderButtonSelect; // Кнопка заказать верняя/нижняя
    private final String firstName; // Имя
    private final String secondName; // Фамилия
    private final String address; // Адрес
    private final String subwayStation; // Станция метро
    private final String phoneNumber; // Номер телефона
    private final int monthCount; // Выбор месяца
    private final int weekCount; // Выбор недели
    private final int dayOfWeekCount; // Выбор дня недели
    private final int rentPeriodCount; // Выбор срока аренды
    private final String colour; // Цвет самоката


    public FullOrderTest(String orderButtonSelect, String firstName, String secondName, String address, String subwayStation, String phoneNumber, int monthCount, int weekCount, int dayOfWeekCount, int rentPeriodCount, String colour) {
        this.orderButtonSelect = orderButtonSelect;
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.subwayStation = subwayStation;
        this.phoneNumber = phoneNumber;
        this.monthCount = monthCount;
        this.weekCount = weekCount;
        this.dayOfWeekCount = dayOfWeekCount;
        this.rentPeriodCount = rentPeriodCount;
        this.colour = colour;
    }

    @Parameterized.Parameters
    public static Object[][] getListData() {
        return new Object[][]{
                {"top", "Олег", "Совков", "ул.Нескучная", "Марьино", "88005553535", 0, 2, 2, 1, "black"},
                {"bottom", "Дженерик", "Мэн", "ул.Ленина", "Охотный ряд", "899911122233", 2, 3, 1, 5, "grey"},
        };
    }
    @Test
    public void checkFullOrder() {
        HomePage homePageObj = new HomePage(driver);
        OrderPage orderPageObj = new OrderPage(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        homePageObj.acceptCookies();
        homePageObj.pushOrderButton(orderButtonSelect);
        orderPageObj.firstNameInput(firstName);
        orderPageObj.secondNameInput(secondName);
        orderPageObj.addressInput(address);
        orderPageObj.subwayStationClick();
        orderPageObj.subwayStationInput(subwayStation);
        orderPageObj.subwayStationSelection();
        orderPageObj.phoneNumberInput(phoneNumber);
        orderPageObj.nextButtonClick();
        orderPageObj.deliveryDateClick();
        orderPageObj.monthInput(monthCount);
        orderPageObj.dayOfWeekSelection(weekCount, dayOfWeekCount);
        orderPageObj.rentPeriodClick();
        orderPageObj.rentPeriodSelection(rentPeriodCount);
        orderPageObj.colourSelection(colour);
        orderPageObj.orderButtonClick();
        orderPageObj.yesButtonClick();
        orderPageObj.orderSuccessCheck();
    }
}
