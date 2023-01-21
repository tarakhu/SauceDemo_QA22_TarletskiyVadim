package Pages;

import Tests.AllureUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    private final static By USERNAME_INPUT_LOCATOR = By.cssSelector("#user-name");
    @FindBy(css = "#password")
    private WebElement passwordInput;
    @FindBy(css = "#login-button")
    private WebElement loginButton;
    @FindBy(css = ".error-message-container")
    private WebElement errorMessageContainer;

    public boolean isPageOpened() {
        return loginButton.isDisplayed();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserNameButtonPresent() {
        try {
            driver.findElement(USERNAME_INPUT_LOCATOR);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public ProductsPage clickLoginButton() {
        logger.info("Click to login button");
        loginButton.click();
        return new ProductsPage(driver);
    }

    public LoginPage setUsername(String username) {
        logger.debug(String.format("Entered username value %s ", username));
        driver.findElement(USERNAME_INPUT_LOCATOR).sendKeys(username);
        AllureUtils.attachScreenshot(driver);
        return this;
    }

    @Step("Set password")
    public LoginPage setPassword(String password) {
        logger.debug(String.format("Entered password value %s ", password));
        passwordInput.sendKeys(password);
        AllureUtils.attachScreenshot(driver);
        return this;
    }

    @Step("Get error message")
    public String getErrorMessageText()  {
        return errorMessageContainer.getText();
    }
}