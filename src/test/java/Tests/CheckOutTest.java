package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTest extends BaseTest {

    String itemName = "Sauce Labs Backpack";

    @Test(groups = {"smoke"})
    public void checkoutTest() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        productsPage.clickAddToCartButton(itemName);

        productsPage.clickShoppingCartButton();

        cartPage.checkoutButtonClick();

        checkoutStepOnePage.setFirstName("firstName");
        checkoutStepOnePage.setLastName("lastName");
        checkoutStepOnePage.setPostalCode("12345");

        checkoutStepOnePage.continueButtonClick();

        checkoutStepTwoPage.finishButtonClick();

        Assert.assertTrue(checkoutCompletePage.isCompleteMessageDisplayed());

    }
}