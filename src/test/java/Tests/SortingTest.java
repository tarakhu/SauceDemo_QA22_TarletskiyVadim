package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SortingTest extends BaseTest {

    @DataProvider()
    public Object[][] sorting() {
        return new Object[][]{
                //sortByValue, itemNames
                {"za", Arrays.asList("Test.allTheThings() T-Shirt (Red)", "Sauce Labs Onesie", "Sauce Labs Fleece Jacket",
                "Sauce Labs Bolt T-Shirt", "Sauce Labs Bike Light", "Sauce Labs Backpack")},
                {"lohi", Arrays.asList("Sauce Labs Onesie", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
                        "Test.allTheThings() T-Shirt (Red)", "Sauce Labs Backpack", "Sauce Labs Fleece Jacket")},
                {"hilo", Arrays.asList("Sauce Labs Fleece Jacket", "Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt",
                        "Test.allTheThings() T-Shirt (Red)", "Sauce Labs Bike Light", "Sauce Labs Onesie")},
        };
    }

    @Test(dataProvider = "sorting", retryAnalyzer = Retry.class, groups = {"regression"}, description = "тест сортировки вещей на странице")
    public void sortingTest(String sortByValue, List<String> itemNames)  {

        loginPage.setUsername("standard_user")
                .setPassword("secret_sauce")
                .clickLoginButton()
                .selectSortingOption(sortByValue);

        Assert.assertEquals(productsPage.getProductNames(), itemNames);

    }




}
