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
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) {

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else {
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