package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage{

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    private static final By PONY_EXPRESS_IMG_LOCATOR = By.xpath("//img[@class='pony_express']");

    public boolean isPonyExpressImgDisplayed() {
        return driver.findElement(PONY_EXPRESS_IMG_LOCATOR).isDisplayed();
    }

}
