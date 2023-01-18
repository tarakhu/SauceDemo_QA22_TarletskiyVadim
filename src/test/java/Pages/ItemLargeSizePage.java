package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemLargeSizePage extends BasePage {



    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    private WebElement largeSizeNameLocator;
    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    private WebElement largeSizeDescLocator;
    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    private WebElement largeSizePriceLocator;

    public ItemLargeSizePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean isPageOpened() {
        return largeSizeNameLocator.isDisplayed();
    }

    public String getItemName() {
        String itemName = largeSizeNameLocator.getText();
        return itemName;
    }

    public String getItemPrice() {
        String itemPrice = largeSizePriceLocator.getText();
        return itemPrice;
    }

    public String getItemDesc() {
        String itemDesc = largeSizeDescLocator.getText();
        return itemDesc;
    }

}
