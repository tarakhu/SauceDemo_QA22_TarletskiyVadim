package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage{

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    private static final By COMPLETE_LOCATOR = By.xpath("//h2[@class='complete-header']");

    @Step("Complete message check")
    public boolean isCompleteMessageDisplayed() {
        return driver.findElement(COMPLETE_LOCATOR).isDisplayed();
    }

}
