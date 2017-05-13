package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by dell on 12.05.17.
 */
public class FirstPage extends Page {
    public static final Logger log = Logger.getLogger(FirstPage.class);
    By signButton = By.id("com.ringcentral.android:id/sign_in");

    public FirstPage(WebDriver driver) {
        super(driver);
    }

    public FirstPage signIn() {
        log.info("sign in button press");
        driver.findElement(signButton).click();
        log.info("OK!");
        return  new FirstPage(driver);
    }

}

