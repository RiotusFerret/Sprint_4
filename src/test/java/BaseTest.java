import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    WebDriver driver;
    @Before
    public void startUp() {
       String browser = System.getProperty("browser", "chrome");
       if(browser.equals("chrome")) {
           startBrowserChrome();                    // -Dbrowser=chrome
       } else if(browser.equals("firefox")) {
           startBrowserFirefox();                   // -Dbrowser=firefox
       }
    }
    public void startBrowserChrome() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
    }
    public void startBrowserFirefox() {
        driver = new FirefoxDriver();
        WebDriverManager.firefoxdriver().setup();
    }
    @After
    public void shutDown() {
        driver.quit();
    }
}
