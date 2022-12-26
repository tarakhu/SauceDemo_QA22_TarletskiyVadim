package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage extends BasePage {

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    public static final By FIRST_NAME_FIELD_LOCATOR = By.id("first-name");
    public static final By LAST_NAME_FIELD_LOCATOR = By.id("last-name");
    public static final By POSTAL_CODE_LOCATOR = By.id("postal-code");
    public static final By CONTINUE_BUTTON_LOCATOR = By.cssSelector("#continue");
    public static final By ERROR_TEXT_LOCATOR = By.xpath("//div[@class='error-message-container error']");

    public void continueButtonClick() {
        driver.findElement(CONTINUE_BUTTON_LOCATOR).click();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_TEXT_LOCATOR).getText();
    }

    public void setFirstName(String firstName)   {
        driver.findElement(FIRST_NAME_FIELD_LOCATOR).sendKeys(firstName);
    }

    public void setLastName(String lastName)   {
        driver.findElement(LAST_NAME_FIELD_LOCATOR).sendKeys(lastName);
    }

    public void setPostalCode(String postalCode)   {
        driver.findElement(POSTAL_CODE_LOCATOR).sendKeys(postalCode);
    }



}
