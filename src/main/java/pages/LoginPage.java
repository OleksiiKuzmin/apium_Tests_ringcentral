package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by dell on 12.05.17.
 */
public class LoginPage extends Page {


    String warningText = "Invalid phone number or password. Please try again.";

    By cellPhoneEdt = By.id("com.ringcentral.android:id/phone");
    By passdEdt = By.id("et_password");
    By extensionNumberEdit = By.id("com.ringcentral.android:id/extension");
    By signInButton = By.id("com.ringcentral.android:id/btnSignIn");
    By countrySelection = By.id("com.ringcentral.android:id/login_left_view");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage badCellPhone() {
        String[] badNumbers = {"abcdfgh", "a222 22 a 222", "2222a2222", "099887766^%", "23123"};
        Boolean answer = true;
        waitForVisibilityOf(signInButton);

        for (int i = 0; i < badNumbers.length; i++) {
            driver.findElement(cellPhoneEdt).clear();
            driver.findElement(passdEdt).clear();
            driver.findElement(cellPhoneEdt).sendKeys(badNumbers[i]);
            driver.findElement(passdEdt).sendKeys("Pass2000");
            driver.findElement(signInButton).click();
            if (driver.findElement(By.id("android:id/message")).getText().contains(warningText)) {
                driver.findElement(By.id("android:id/button1")).click();
                answer = false;
            }
        }
        Assert.assertTrue(answer);
        return new LoginPage(driver);

    }

    public LoginPage badPass() {
        String[] badPass = {"_bcdfgh", "a222 22 a 222", "~sddasd", "099887766^%", "23d+123"};
        Boolean answer = true;
        waitForVisibilityOf(signInButton);

        for (int i = 0; i < badPass.length; i++) {
            driver.findElement(cellPhoneEdt).clear();
            driver.findElement(passdEdt).clear();
            driver.findElement(cellPhoneEdt).sendKeys("7772332909");
            driver.findElement(passdEdt).sendKeys(badPass[i]);
            driver.findElement(signInButton).click();
            if (driver.findElement(By.id("android:id/message")).getText().contains(warningText)) {
                driver.findElement(By.id("android:id/button1")).click();
                answer = false;
            }
        }
        Assert.assertTrue(answer);
        return new LoginPage(driver);

    }


}
