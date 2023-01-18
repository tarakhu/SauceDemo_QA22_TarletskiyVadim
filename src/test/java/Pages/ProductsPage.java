package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement productSortContainer;

    public boolean isPageOpened() {
        return driver.findElement(SHOPPING_CART_BUTTON).isDisplayed();
    }

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isShoppingCartButtonPresent() {
        try {
            driver.findElement(SHOPPING_CART_BUTTON);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public ItemLargeSizePage clickLargeSizeItemPage(String itemName) {
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
        return actualItemNames;
    }

    @Step("Sorting")
    public ProductsPage selectSortingOption(String sortByValue) {
        Select select = new Select(driver.findElement(By.tagName("select")));
        select.selectByValue(sortByValue);
        return this;
    }

    public LoginPage logoutButtonClick() {
        logoutButton.click();
        return new LoginPage(driver);
    }

    public ProductsPage menuButtonClick() {
        menuButton.click();
        return this;
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
