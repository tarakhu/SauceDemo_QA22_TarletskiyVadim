package Tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTest extends BaseTest {

    String itemName = "Sauce Labs Backpack";

    @Description("Checkout test")
    @Test(groups = {"smoke"})
    public void checkoutTest() {
        loginPage.setUsername("standard_user")
                .setPassword("secret_sauce")
                .clickLoginButton()
                .clickAddToCartButton(itemName);

        productsPage.clickShoppingCartButton();
        cartPage.checkoutButtonClick();

        checkoutStepOnePage.setFirstName("firstName")
                .setLastName("lastName")
                .setPostalCode("12345")
                .continueButtonClick()
                .finishButtonClick();

        Assert.assertTrue(checkoutCompletePage.isCompleteMessageDisplayed());

    }
}