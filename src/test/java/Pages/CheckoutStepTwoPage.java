package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepTwoPage extends BasePage{

    @FindBy(id = "finish")
    private WebElement finishButtonLocator;
    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    private WebElement summarySubtotalLabelLocator;
    @FindBy(xpath = "//div[@class='summary_tax_label']")
    private WebElement summaryTaxLabelLocator;
    @FindBy(xpath = "//div[@class='summary_total_label']")
    private WebElement summaryTotalLabelLocator;

    public boolean isPageOpened() {
        return finishButtonLocator.isDisplayed();
    }

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click to finish button")
    public CheckoutCompletePage finishButtonClick() {
        logger.info("Use click to finish button");
        finishButtonLocator.click();
        return new CheckoutCompletePage(driver);
    }

    public double itemSubtotal() {
        String subtotalFull = summarySubtotalLabelLocator.getText();
        String subtotalString = subtotalFull.substring(13);
        double subtotal = Double.parseDouble(subtotalString);
        return subtotal;
    }

    public double itemTax() {
        String taxFull = summaryTaxLabelLocator.getText();
        String taxString = taxFull.substring(6);
        double tax = Double.parseDouble(taxString);
        return tax;
    }

    @Step("Actual item total price")
    public double actualItemTotal() {
        String itemTotalFull = summaryTotalLabelLocator.getText();
        String itemTotalString = itemTotalFull.substring(8);
        double actualTotal = Double.parseDouble(itemTotalString);
        return actualTotal;
    }

    @Step("Expected item total price")
    public double expectedItemTotal() {
        logger.info(String.format("Calculation for total price subtotal %s + itemtax %s", itemSubtotal(), itemTax()));
        double expectedTotal = itemSubtotal() + itemTax();
        return expectedTotal;
    }
}
