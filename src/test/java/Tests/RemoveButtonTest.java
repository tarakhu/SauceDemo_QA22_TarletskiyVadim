package Tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class RemoveButtonTest extends BaseTest {

    String itemName = "Sauce Labs Backpack";

    @Test(retryAnalyzer = Retry.class, groups = {"regression"}, description = "проверка работоспособности кнопки ремува")
    public void removeButtonTest() {

        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        productsPage.clickAddToCartButton(itemName);

        productsPage.clickShoppingCartButton();

        cartPage.removeButtonClick(itemName.replaceAll(" ", "-").toLowerCase());

        Assert.assertFalse(cartPage.isItemDescriptionDisplayed(itemName));

    }
}
