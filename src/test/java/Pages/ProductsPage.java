package Pages;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class ProductsPage extends BasePage {

    private final static By SHOPPING_CART_BUTTON = By.cssSelector(".shopping_cart_link");
    private final static String ITEM_CONTAINER_LOCATOR = "//div[@class='inventory_item_name' and text()='%s']/ancestor::div[@class='inventory_item_description']";
    private final static By ADD_TO_CART_BUTTON = By.xpath("//button[text()='Add to cart']");
    private final static By ITEM_PRICE_LOCATOR = By.xpath(".//div[@class = 'inventory_item_price']");
    private final static By ITEM_DESCRIPTION_LOCATOR = By.xpath(".//div[@class = 'inventory_item_desc']");
    private final static By MENU_BUTTON = By.id("react-burger-menu-btn");
    private final static By LOGOUT_BUTTON = By.id("logout_sidebar_link");
    private final static By PRODUCT_SORT_CONTAINER = By.xpath("//select[@class='product_sort_container']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isShoppingCartButtonPresent() {
        try {
            driver.findElement(SHOPPING_CART_BUTTON);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

//    public void productSortContainer

    public void logoutButtonClick() {
        driver.findElement(LOGOUT_BUTTON).click();
    }

    public void menuButtonClick() {
        driver.findElement(MENU_BUTTON).click();
    }
    public void clickShoppingCartButton() {
        driver.findElement(SHOPPING_CART_BUTTON).click();
    }

    public String getItemPrice(String itemName) {
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_PRICE_LOCATOR).getText();
    }

    public String getItemDescription(String itemName) {
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_DESCRIPTION_LOCATOR).getText();
    }

    public void clickAddToCartButton(String itemName) {
        driver.findElement(getItemContainerByName(itemName)).findElement(ADD_TO_CART_BUTTON).click();
    }

    public void openItem(String itemName) {
        driver.findElement(getItemContainerByName(itemName)).findElement(ADD_TO_CART_BUTTON).click();
    }

    private By getItemContainerByName(String itemName) {
        return By.xpath(String.format(ITEM_CONTAINER_LOCATOR, itemName));

    }
}
