import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Locators {
    WebDriver driver;

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void justLocatorsTesting() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement q1 = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        WebElement q2 = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        WebElement q3 = driver.findElement(By.tagName("div"));

        //поиск по xpath

        WebElement q4 = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        WebElement q5 = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        WebElement q6 = driver.findElement(By.xpath("//div[contains(@class,'bm-burger-button')]"));
        WebElement q7 = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]"));
        WebElement q8 = driver.findElement(By.xpath("//div[@class='inventory_item_name']/ancestor::div"));//предок
        WebElement q9 = driver.findElement(By.xpath("//*[@id='inventory_container']/descendant::div"));//потомок
        WebElement q10 = driver.findElement(By.xpath("//div[@class='inventory_item']//following::div"));
        WebElement q11 = driver.findElement(By.xpath("//div[@class='inventory_item']/parent::div"));
        WebElement q12 = driver.findElement(By.xpath("//div[@class='inventory_item']/preceding::div"));
        WebElement q13 = driver.findElement(By.xpath("//div[@id='inventory_container' and @class='inventory_container']"));

        //поиск по css

        WebElement q14 = driver.findElement(By.cssSelector(".inventory_item_price"));
        WebElement q15 = driver.findElement(By.cssSelector("button.btn.btn_primary.btn_small.btn_inventory"));
        WebElement q16 = driver.findElement(By.cssSelector("div.inventory_item .inventory_item_img"));
        WebElement q17 = driver.findElement(By.cssSelector("#inventory_container"));
        WebElement q18 = driver.findElement(By.cssSelector("div"));
        WebElement q19 = driver.findElement(By.cssSelector("div.inventory_item_price"));
        WebElement q20 = driver.findElement(By.cssSelector("[class=inventory_item_price]"));
        WebElement q21 = driver.findElement(By.cssSelector("[class~=btn_primary]"));
        WebElement q22 = driver.findElement(By.cssSelector("[class|=inventory_item]"));
        WebElement q23 = driver.findElement(By.cssSelector("[class^=pr]"));
        WebElement q24 = driver.findElement(By.cssSelector("[class$=price]"));
        WebElement q25 = driver.findElement(By.cssSelector("[class*=pricebar]"));

        //home task

        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        addToCartButton.click();

        WebElement cartButton = driver.findElement(By.cssSelector(".shopping_cart_link"));
        cartButton.click();

        WebElement productPrice = driver.findElement(By.xpath("//div[@class='inventory_item_price']"));
        Assert.assertEquals(productPrice.getText(), "$9.99");

        WebElement productName = driver.findElement(By.cssSelector("[class='inventory_item_name']"));
        Assert.assertEquals(productName.getText(), "Sauce Labs Bike Light");

    }
}