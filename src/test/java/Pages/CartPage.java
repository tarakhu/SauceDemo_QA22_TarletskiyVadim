package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    private final static String ITEM_CONTAINER_LOCATOR = "//div[@class='inventory_item_name' and text()='%s']/ancestor::div[@class='cart_item_label']";
    private final static By ITEM_NAME_LOCATOR = By.xpath(".//div[@class='inventory_item_name']");
    private final static By ITEM_PRICE_LOCATOR = By.xpath(".//div[@class='inventory_item_price']");
    private final static By ITEM_DESCRIPTION_LOCATOR = By.xpath(".//div[@class ='inventory_item_desc']");
    private final static String ITEM_REMOVE_LOCATOR = "//button[@id='remove-%s']";
    private final static By CHECKOUT_BUTTON_LOCATOR = By.xpath("//button[@id ='checkout']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return driver.findElement(CHECKOUT_BUTTON_LOCATOR).isDisplayed();
    }

    public CheckoutStepOnePage checkoutButtonClick() {
        logger.debug("Click to checkout button");
        driver.findElement(CHECKOUT_BUTTON_LOCATOR).click();
        return new CheckoutStepOnePage(driver);
    }

    public String getItemPrice(String itemName) {
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_PRICE_LOCATOR).getText();
    }

    public boolean isItemDescriptionDisplayed(String itemName) {
       try {
           return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_DESCRIPTION_LOCATOR).isDisplayed();
       } catch (NoSuchElementException e) {
           return false;
       }
    }

    private By getRemoveButtonByItemName(String itemName) {
        return By.xpath(String.format(ITEM_REMOVE_LOCATOR, itemName));
    }

    public void removeButtonClick(String itemName) {
        logger.debug(String.format("Click to remove button by name %s", itemName));
        driver.findElement(getRemoveButtonByItemName(itemName)).click();
    }


    private By getItemContainerByName(String itemName) {
        return By.xpath(String.format(ITEM_CONTAINER_LOCATOR, itemName));
    }


}