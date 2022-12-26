package Pages;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final static By USERNAME_INPUT_LOCATOR = By.cssSelector("#user-name");
    private final static By PASSWORD_INPUT = By.cssSelector("#password");
    private final static By LOGIN_BUTTON = By.cssSelector("#login-button");
    private final static By ERROR_MESSAGE_CONTAINER = By.cssSelector(".error-message-container");

    public boolean isUserNameButtonPresent() {
        try {
            driver.findElement(USERNAME_INPUT_LOCATOR);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton()  {
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void setUsername(String username)   {
        driver.findElement(USERNAME_INPUT_LOCATOR).sendKeys(username);
    }

    public void setPassword(String password)    {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public String getErrorMessageText()  {
        return driver.findElement(ERROR_MESSAGE_CONTAINER).getText();
    }
}