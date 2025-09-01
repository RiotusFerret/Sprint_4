import org.junit.Assert;
import pages.HomePage;
import pages.OrderPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static constants.URLs.HOME_PAGE;

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
    private final boolean expected;


    public FullOrderTest(String orderButtonSelect, String firstName, String secondName, String address, String subwayStation, String phoneNumber, int monthCount, int weekCount, int dayOfWeekCount, int rentPeriodCount, String colour, boolean expected) {
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
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {1} {2} {0} {11}")
    public static Object[][] getListData() {
        return new Object[][]{
                {"top", "Олег", "Совков", "ул.Нескучная", "Марьино", "88005553535", 0, 2, 2, 1, "black", true},
                {"bottom", "Дженерик", "Мэн", "ул.Ленина", "Охотный ряд", "899911122233", 2, 3, 1, 5, "grey", true},
        };
    }
    @Test
    public void OrderTest() {
        HomePage homePageObj = new HomePage(driver);
        OrderPage orderPageObj = new OrderPage(driver);
        driver.get(HOME_PAGE);
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
        Assert.assertEquals(expected, orderPageObj.orderSuccessCheck());
    }
}
