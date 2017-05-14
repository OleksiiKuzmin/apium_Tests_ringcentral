package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by dell on 12.05.17.
 */
public class LoginPage extends Page {
    Logger log = Logger.getLogger(LoginPage.class);

    String warningText = "Invalid phone number or password. Please try again.";

    By cellPhoneEdt = By.id("com.ringcentral.android:id/phone");
    By passdEdt = By.id("et_password");
    By extensionNumberEdit = By.id("com.ringcentral.android:id/extension");
    By signInButton = By.id("com.ringcentral.android:id/btnSignIn");
    By countrySelection = By.id("com.ringcentral.android:id/login_left_view");
    By warningMsg = By.id("android:id/message");
    By warnBtnOK = By.id("android:id/button1");

    By listWiew = By.id("android:id/select_dialog_listview");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage badCellPhone() {
        String[] badNumbers = {"abcdfgh", "a222 22 a 222", "2222a2222", "099887766^%", "23123"};
        boolean answer = true;
        waitForVisibilityOf(signInButton);

        for (int i = 0; i < badNumbers.length; i++) {
            driver.findElement(cellPhoneEdt).clear();
            driver.findElement(passdEdt).clear();
            driver.findElement(passdEdt).sendKeys("Pass2000");
            driver.findElement(cellPhoneEdt).sendKeys(badNumbers[i]);
            log.info("Test <wrong Number> : < " + badNumbers[i] + " >");
            driver.findElement(signInButton).click();

            if (!driver.findElement(warningMsg).getText().contains(warningText)) {
                driver.findElement(warnBtnOK).click();
                answer = false;
                break;
            }
        }
        Assert.assertTrue(answer);
        log.info(answer);
        return this;

    }

    public LoginPage badPass() {
        String[] badPass = {"_bcdfgh", "a222 22 a 222", "~sddasd", "099887766^%", "23d+123"};
        boolean answer = true;
        waitForVisibilityOf(signInButton);

        for (int i = 0; i < badPass.length; i++) {
            driver.findElement(cellPhoneEdt).clear();
            driver.findElement(passdEdt).clear();
            driver.findElement(cellPhoneEdt).sendKeys("7772332909");
            driver.findElement(passdEdt).sendKeys(badPass[i]);
            log.info("Test <wrong Pass> : < " + badPass[i] + " >");
            driver.findElement(signInButton).click();
            if (!driver.findElement(warningMsg).getText().contains(warningText)) {
                driver.findElement(warnBtnOK).click();
                answer = false;
                break;
            }
        }
        Assert.assertTrue(answer);
        log.info(answer);
        return this;

    }

    public LoginPage clikableSignIn() {
        boolean answer = true;
        log.info("Test with empty login fields. Is clickable button < signIn >");
        driver.findElement(cellPhoneEdt).clear();
        driver.findElement(passdEdt).clear();
        if (driver.findElement(signInButton).isEnabled()) {
            answer = false;
        }
        Assert.assertTrue(answer);
        log.info(answer);
        return this;
    }
    public LoginPage countryList() {
        boolean answer = true;
        log.info("Test. Is list contain <Ukraine>");
        driver.findElement(countrySelection).click();

        if (!driver.findElement(listWiew).getText().contains("Ukraine")) {
            answer = false;
        }
        Assert.assertTrue(answer);
        log.info(answer);
        return this;
    }

}
