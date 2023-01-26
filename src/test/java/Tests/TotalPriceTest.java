package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TotalPriceTest extends BaseTest {

    String itemNameOne = "Sauce Labs Backpack";
    String itemNameTwo = "Sauce Labs Fleece Jacket";

    @Test(groups = {"smoke"}, description = "проверка расчета итоговой суммы покупки")
    public void totalPriceTest() {
        loginPage.setUsername("standard_user")
                .setPassword("secret_sauce")
                .clickLoginButton()
                .clickAddToCartButton(itemNameOne);

        productsPage.clickAddToCartButton(itemNameTwo);

        productsPage.clickShoppingCartButton();

        cartPage.checkoutButtonClick();

        checkoutStepOnePage.setFirstName("firstName")
                .setLastName("lastName")
                .setPostalCode("12345")
                .continueButtonClick();

        Assert.assertEquals(checkoutStepTwoPage.actualItemTotal(), checkoutStepTwoPage.expectedItemTotal());
    }
}
