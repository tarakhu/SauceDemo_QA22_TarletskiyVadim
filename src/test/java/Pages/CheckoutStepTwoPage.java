package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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



}
