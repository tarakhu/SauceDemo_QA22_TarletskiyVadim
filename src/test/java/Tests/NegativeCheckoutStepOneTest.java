package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeCheckoutStepOneTest extends BaseTest {

    String itemName = "Sauce Labs Backpack";

    @DataProvider
    public Object[][] productTest() {
        return new Object[][]{
                {"Vadim", "Tarletskiy", "", "Error: Postal Code is required"},
                {"", "Tarletskiy", "12454", "Error: First Name is required"},
                {"Vadim", "", "12454", "Error: Last Name is required"},
        };
    }

    @Test(dataProvider = "productTest", groups = {"regression"}, description = "негативный тест ввода данных покупателя")
    public void negativeCheckoutStepOneTest(String firstName, String lastName, String postCode, String errorMessage) {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        productsPage.clickAddToCartButton(itemName);

        productsPage.clickShoppingCartButton();

        cartPage.checkoutButtonClick();

        checkoutStepOnePage.setFirstName(firstName);
        checkoutStepOnePage.setLastName(lastName);
        checkoutStepOnePage.setPostalCode(postCode);

        checkoutStepOnePage.continueButtonClick();

        Assert.assertEquals(errorMessage, checkoutStepOnePage.getErrorMessage());
    }


}
