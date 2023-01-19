package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends BasePage{

    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement completeLocator;

    @Step("Complete message check")
    public boolean isCompleteMessageDisplayed() {
        return completeLocator.isDisplayed();
    }

    public boolean isPageOpened() {
        return completeLocator.isDisplayed();
    }

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }
}
