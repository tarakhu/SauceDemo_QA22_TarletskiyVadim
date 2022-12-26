package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class SortByNameZ_ATest extends BaseTest {

    @DataProvider()
    public Object[][] productTest() {
        return new Object[][]{
                //testItemName, expectedItemPrice, expectedItemDescription
                {"Test.allTheThings() T-Shirt (Red)", "$15.99", "This classic Sauce Labs t-shirt is perfect to wear when " +
                        "cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton."},
                {"Sauce Labs Onesie", "$7.99", "Rib snap infant onesie for the junior automation engineer in development. " +
                        "Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel."},
                {"Sauce Labs Fleece Jacket", "$49.99", "It's not every day that you come across a midweight quarter-zip " +
                        "fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office."},
                {"Sauce Labs Bolt T-Shirt", "$15.99", "Get your testing superhero on with the Sauce Labs bolt T-shirt. " +
                        "From American Apparel, 100% ringspun combed cotton, heather gray with red bolt."},
                {"Sauce Labs Bike Light", "$9.99", "A red light isn't the desired state in testing but it sure helps when " +
                        "riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included."},
                {"Sauce Labs Backpack", "$29.99", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds " +
                        "uncompromising style with unequaled laptop and tablet protection."},
        };
    }

    @Test(dataProvider = "productTest", retryAnalyzer = Retry.class)
    public void productsTest(String testItemName, String expectedItemPrice, String expectedItemDescription)  {

        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(productsPage.isShoppingCartButtonPresent());



        Assert.assertEquals(productsPage.getItemPrice(testItemName), expectedItemPrice);
        Assert.assertEquals(productsPage.getItemDescription(testItemName), expectedItemDescription);
    }




}
