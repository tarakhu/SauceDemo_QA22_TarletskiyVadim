package Tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckoutStepOneTest extends BaseTest {

    String itemName = "Sauce Labs Backpack";

    @DataProvider
    public Object[][] productTest() {
        return new Object[][]{
                {"Vadim", "Tarletskiy", "", "Error: Postal Code is required"},
                {"", "Tarletskiy", "12454", "Error: First Name is required"},
                {"Vadim", "", "12454", "Error: Last Name is required"},
        };
    }

    @Description("Negative test about buyer data")
    @Test(dataProvider = "productTest", groups = {"regression"}, description = "негативный тест ввода данных покупателя")
    public void negativeCheckoutStepOneTest(String firstName, String lastName, String postCode, String errorMessage) {

        loginPage.setUsername("standard_user")
                .setPassword("secret_sauce")
                .clickLoginButton()
                .clickAddToCartButton(itemName);

        productsPage.clickShoppingCartButton();
        cartPage.checkoutButtonClick();

        checkoutStepOnePage.setFirstName(firstName).setLastName(lastName).setPostalCode(postCode).continueButtonClick();

        Assert.assertEquals(errorMessage, checkoutStepOnePage.getErrorMessage());
    }

    @Description("Positive test about buyer data")
    @Test(groups = {"smoke"}, description = "позитивный тест ввода данных покупателя")
    public void positiveCheckoutStepOneTest() {
        loginPage.setUsername("standard_user")
                .setPassword("secret_sauce")
                .clickLoginButton()
                .clickAddToCartButton(itemName);

        productsPage.clickShoppingCartButton();
        cartPage.checkoutButtonClick();

        checkoutStepOnePage.setFirstName("firstName")
                .setLastName("lastName")
                .setPostalCode("12345")
                .continueButtonClick();

        Assert.assertTrue(checkoutStepTwoPage.isPageOpened());
    }


}
