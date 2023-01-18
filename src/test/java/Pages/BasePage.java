package Pages;

import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
        protected WebDriver driver;
        public abstract boolean isPageOpened();

        public BasePage(WebDriver driver) {

            this.driver = driver;
            PageFactory.initElements(driver,this);
        }
    }
