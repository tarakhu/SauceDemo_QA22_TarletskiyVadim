package Tests;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected ItemLargeSizePage itemLargeSizePage;
    protected CartPage cartPage;
    protected CheckoutStepOnePage checkoutStepOnePage;
    protected CheckoutStepTwoPage checkoutStepTwoPage;
    protected CheckoutCompletePage checkoutCompletePage;
    protected final Logger logger = LogManager.getLogger(this.getClass().getName());

    @BeforeClass(alwaysRun = true)
    public void setUp(ITestContext testContext) {
        String browserName = System.getProperty("browser", "Chrome");
        String headless = System.getProperty("headless", "false");

        if (browserName.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (headless.equals("true")) {
                options.addArguments("--headless");
            }
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        } else if(browserName.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            testContext.setAttribute("driver", driver);

            loginPage = new LoginPage(driver);
            productsPage = new ProductsPage(driver);
            itemLargeSizePage = new ItemLargeSizePage(driver);
            cartPage = new CartPage(driver);
            checkoutStepOnePage = new CheckoutStepOnePage(driver);
            checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
            checkoutCompletePage = new CheckoutCompletePage(driver);
        }

    @BeforeMethod(alwaysRun = true)
    public void navigate()  {
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown()  {
        driver.quit();
    }
}