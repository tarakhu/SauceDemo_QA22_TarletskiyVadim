package Tests;

import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class LogoutTest extends BaseTest {

    @Test(groups = {"regression"}, description = "логаут тест")
    public void positiveLogOutTest() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        productsPage.menuButtonClick();

        productsPage.logoutButtonClick();

        Assert.assertEquals(loginPage.isUserNameButtonPresent(), true);

    }
}
