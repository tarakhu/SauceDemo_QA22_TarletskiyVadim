package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOnePage extends BasePage {


    @FindBy(id = "first-name")
    private WebElement firstNameFieldLocator;
    @FindBy(id = "last-name")
    private WebElement lastNameFieldLocator;
    @FindBy(id = "postal-code")
    private WebElement postalCodeLocator;
    @FindBy(css = "#continue")
    private WebElement continueButtonLocator;
    @FindBy(xpath = "//div[@class='error-message-container error']")
    private WebElement errorTextLocator;

    public boolean isPageOpened() {
        return firstNameFieldLocator.isDisplayed();
    }

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click continue button")
    public CheckoutStepTwoPage continueButtonClick() {
        logger.debug("Click to continue button");
        continueButtonLocator.click();
        return new CheckoutStepTwoPage(driver);
    }

    @Step("Get error message")
    public String getErrorMessage() {
        return errorTextLocator.getText();
    }

    @Step("Set first name")
    public CheckoutStepOnePage setFirstName(String firstName) {
        logger.debug(String.format("Entered FirstName value -- %s", firstName));
        firstNameFieldLocator.sendKeys(firstName);
        return this;
    }

    @Step("Set last name")
    public CheckoutStepOnePage setLastName(String lastName) {
        logger.debug(String.format("Entered LastName value -- %s", lastName));
        lastNameFieldLocator.sendKeys(lastName);
        return this;
    }

    @Step("Set postal code")
    public CheckoutStepOnePage setPostalCode(String postalCode) {
        logger.debug(String.format("Entered postalcode value -- %s", postalCode));
        postalCodeLocator.sendKeys(postalCode);
        return this;
    }
}
