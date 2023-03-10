package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {

    private final static String ITEM_CONTAINER_LOCATOR = "//div[@class='inventory_item_name' and text()='%s']/ancestor::div[@class='inventory_item_description']";
    private final static By SHOPPING_CART_BUTTON = By.cssSelector(".shopping_cart_link");
    private final static By ADD_TO_CART_BUTTON = By.xpath("//button[text()='Add to cart']");
    private final static By ITEM_PRICE_LOCATOR = By.xpath(".//div[@class = 'inventory_item_price']");
    private final static By ITEM_DESCRIPTION_LOCATOR = By.xpath(".//div[@class = 'inventory_item_desc']");
    private final static By LARGE_SIZE_BUTTON_CONTAINER = By.xpath(".//a");
    private final static By MENU_BUTTON = By.id("react-burger-menu-btn");
    private final static By LOGOUT_BUTTON = By.id("logout_sidebar_link");

    public boolean isPageOpened() {
        try {
            driver.findElement(SHOPPING_CART_BUTTON);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click to item, for look large size page")
    public ItemLargeSizePage clickLargeSizeItemPage(String itemName) {
        logger.info(String.format("Click to large size item %s page", itemName));
        driver.findElement(getItemContainerByName(itemName)).findElement(LARGE_SIZE_BUTTON_CONTAINER).click();
        return new ItemLargeSizePage(driver);
    }

    public List<WebElement> getActualNamesElements() {
        return driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
    }

    @Step("Get actual collection names on page")
    public List<String> getProductNames() {
        List<String> actualItemNames = new ArrayList<>();
        for (WebElement x : getActualNamesElements()) {
            actualItemNames.add(x.getText());
        }
        logger.info("Actual list of items - ", actualItemNames);
        return actualItemNames;
    }

    @Step("Sorting")
    public ProductsPage selectSortingOption(String sortByValue) {
        Select select = new Select(driver.findElement(By.tagName("select")));
        logger.debug(String.format("Select sorting option %s", sortByValue));
        select.selectByValue(sortByValue);
        return this;
    }

    @Step("Click to logout button")
    public LoginPage logoutButtonClick() {
        logger.info("Click logout button");
        driver.findElement(LOGOUT_BUTTON).click();
        return new LoginPage(driver);
    }

    @Step("Click to menu button")
    public ProductsPage menuButtonClick() {
        logger.info("Click to menu button");
        driver.findElement(MENU_BUTTON).click();
        return this;
    }

    @Step("Click to shopping cart button")
    public void clickShoppingCartButton() {
        logger.debug("Click to shopping cart button");
        driver.findElement(SHOPPING_CART_BUTTON).click();
    }

    public String getItemPrice(String itemName) {
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_PRICE_LOCATOR).getText();
    }

    public String getItemDescription(String itemName) {
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_DESCRIPTION_LOCATOR).getText();
    }

    @Step("Add some item to cart")
    public void clickAddToCartButton(String itemName) {
        logger.info(String.format("Add to cart button %s item", itemName));
        driver.findElement(getItemContainerByName(itemName)).findElement(ADD_TO_CART_BUTTON).click();
    }

    private By getItemContainerByName(String itemName) {
        return By.xpath(String.format(ITEM_CONTAINER_LOCATOR, itemName));
    }
}
