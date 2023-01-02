package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwoPage extends BasePage{

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    private static final By FINISH_BUTTON_LOCATOR = By.id("finish");
    private static final By SUMMARY_SUBTOTAL_LABEL_LOCATOR = By.xpath("//div[@class='summary_subtotal_label']");
    private static final By SUMMARY_TAX_LABEL_LOCATOR = By.xpath("//div[@class='summary_tax_label']");
    private static final By SUMMARY_TOTAL_LABEL_LOCATOR = By.xpath("//div[@class='summary_total_label']");


    public boolean isFinishButtonDisplayed() {
            return driver.findElement(FINISH_BUTTON_LOCATOR).isDisplayed();
    }

    public void finishButtonClick() {
        driver.findElement(FINISH_BUTTON_LOCATOR).click();
    }

    public double itemSubtotal() {
        String subtotalFull = driver.findElement(SUMMARY_SUBTOTAL_LABEL_LOCATOR).getText();
        String subtotalString = subtotalFull.substring(13);
        double subtotal = Double.parseDouble(subtotalString);
        return subtotal;
    }

    public double itemTax() {
        String taxFull = driver.findElement(SUMMARY_TAX_LABEL_LOCATOR).getText();
        String taxString = taxFull.substring(6);
        double tax = Double.parseDouble(taxString);
        return tax;
    }

    @Step("Actual item total price")
    public double actualItemTotal() {
        String itemTotalFull = driver.findElement(SUMMARY_TOTAL_LABEL_LOCATOR).getText();
        String itemTotalString = itemTotalFull.substring(8);
        double actualTotal = Double.parseDouble(itemTotalString);
        return actualTotal;
    }

    @Step("Expected item total price")
    public double expectedItemTotal() {
        double expectedTotal = itemSubtotal() + itemTax();
        return expectedTotal;
    }
}
