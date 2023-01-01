package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TotalPriceTest extends BaseTest {

    String itemName1 = "Sauce Labs Backpack";
    String itemName2 = "Sauce Labs Fleece Jacket";

    @Test(groups = {"smoke"}, description = "проверка расчета итоговой суммы покупки")
    public void totalPriceTest() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        productsPage.clickAddToCartButton(itemName1);
        productsPage.clickAddToCartButton(itemName2);

        productsPage.clickShoppingCartButton();

        cartPage.checkoutButtonClick();

        checkoutStepOnePage.setFirstName("firstName");
        checkoutStepOnePage.setLastName("lastName");
        checkoutStepOnePage.setPostalCode("12345");

        checkoutStepOnePage.continueButtonClick();

        Assert.assertEquals(checkoutStepTwoPage.actualItemTotal(), checkoutStepTwoPage.expectedItemTotal());
    }
}
