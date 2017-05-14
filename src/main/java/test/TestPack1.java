package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.FirstPage;
import pages.LoginPage;

/**
 * Created by dell on 12.05.17.
 */
public class TestPack1 extends AndroidSetUp {
    FirstPage firstPage;
    LoginPage loginPage;

    public TestPack1() {
        firstPage = new FirstPage(driver);
        loginPage = new LoginPage(driver);
    }


    @Before
    public void setup() {
        prepareAndroidForAppium();

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void signIn() throws Exception {
        firstPage.signIn();


    }

    @Test
    public void wrongCellPhone() throws Exception {
        firstPage.signIn();
        loginPage.badCellPhone();

    }

    @Test
    public void wrongPass() throws Exception {
        firstPage.signIn();
        loginPage.badPass();

    }

    @Test
    public void clickableSignIn() throws Exception {
        firstPage.signIn();
        loginPage.clikableSignIn();
    }

    @Test
    public void countryListContainsUkraine() throws Exception {
    loginPage.countryList();
    }

}
