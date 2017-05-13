package test;

import org.apache.log4j.Logger;
import org.junit.*;
import pages.FirstPage;
import pages.LoginPage;

/**
 * Created by dell on 12.05.17.
 */
public class TestPack1 extends AndroidSetUp {
    private static final Logger log = Logger.getLogger(TestPack1.class);

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
        new FirstPage(driver).signIn();


    }

    @Test
    public void loginWithBadCellPhone() throws Exception {
        new FirstPage(driver).signIn();
        new LoginPage(driver).badCellPhone();

    }

    @Test
    public void loginWithBadPass() throws Exception {
        new FirstPage(driver).signIn();
        new LoginPage(driver).badPass();

    }


}
