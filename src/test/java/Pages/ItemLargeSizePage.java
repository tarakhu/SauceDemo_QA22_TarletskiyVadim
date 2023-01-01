package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemLargeSizePage extends BasePage {

    public ItemLargeSizePage(WebDriver driver) {
        super(driver);
    }

    private static final By LARGE_SIZE_NAME_LOCATOR = By.xpath("//div[@class='inventory_details_name large_size']");
    private static final By LARGE_SIZE_DESC_LOCATOR = By.xpath("//div[@class='inventory_details_desc large_size']");
    private static final By LARGE_SIZE_PRICE_LOCATOR = By.xpath("//div[@class='inventory_details_desc large_size']");

    public String itemName = driver.findElement(LARGE_SIZE_NAME_LOCATOR).getText();
    public String itemDesc = driver.findElement(LARGE_SIZE_DESC_LOCATOR).getText();
    public String itemPrice = driver.findElement(LARGE_SIZE_PRICE_LOCATOR).getText();





}
