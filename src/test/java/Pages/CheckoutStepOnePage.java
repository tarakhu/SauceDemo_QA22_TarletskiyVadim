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
        PageFactory.initElements(driver,this);
    }

    public CheckoutStepTwoPage continueButtonClick() {
        continueButtonLocator.click();
        return new CheckoutStepTwoPage(driver);
    }

    @Step("Get error message")
    public String getErrorMessage() {
        return errorTextLocator.getText();
    }

    public CheckoutStepOnePage setFirstName(String firstName)   {
        firstNameFieldLocator.sendKeys(firstName);
        return this;
    }

    public CheckoutStepOnePage setLastName(String lastName)   {
        lastNameFieldLocator.sendKeys(lastName);
        return this;
    }

    public CheckoutStepOnePage setPostalCode(String postalCode)   {
        postalCodeLocator.sendKeys(postalCode);
        return this;
    }
}
