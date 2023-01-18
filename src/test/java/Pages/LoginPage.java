package Pages;

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
        PageFactory.initElements(driver,this);
    }

    public boolean isUserNameButtonPresent() {
        try {
            driver.findElement(USERNAME_INPUT_LOCATOR);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public ProductsPage clickLoginButton()  {
        loginButton.click();
        return new ProductsPage(driver);
    }

    public LoginPage setUsername(String username)   {
        driver.findElement(USERNAME_INPUT_LOCATOR).sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password)    {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Get error message")
    public String getErrorMessageText()  {
        return errorMessageContainer.getText();
    }
}