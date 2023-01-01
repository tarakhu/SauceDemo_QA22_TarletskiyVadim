package Tests;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected CheckoutStepOnePage checkoutStepOnePage;
    protected CheckoutStepTwoPage checkoutStepTwoPage;
    protected CheckoutCompletePage checkoutCompletePage;
    protected ItemLargeSizePage itemLargeSizePage;

    @BeforeClass(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) {

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            loginPage = new LoginPage(driver);
            productsPage = new ProductsPage(driver);
            cartPage = new CartPage(driver);
            checkoutStepOnePage = new CheckoutStepOnePage(driver);
            checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
            checkoutCompletePage = new CheckoutCompletePage(driver);
            itemLargeSizePage = new ItemLargeSizePage(driver);
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