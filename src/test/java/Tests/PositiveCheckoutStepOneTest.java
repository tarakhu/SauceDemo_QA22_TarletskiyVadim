package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PositiveCheckoutStepOneTest extends BaseTest{

    String itemName = "Sauce Labs Backpack";

    @DataProvider
    public Object[][] productTest() {
        return new Object[][]{
                {"Vadim", "Tarletskiy", "12345"},
        };
    }

    @Test(dataProvider = "productTest", groups = {"smoke"}, description = "негативный тест ввода данных покупателя")
    public void negativeCheckoutStepOneTest(String firstName, String lastName, String postCode) {
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

        Assert.assertTrue(checkoutStepTwoPage.isFinishButtonDisplayed());
    }
}
