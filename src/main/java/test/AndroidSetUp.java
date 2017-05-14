package test;

import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * Created by dell on 13.05.17.
 */
public class AndroidSetUp {
    private static final Logger log = Logger.getLogger(AndroidSetUp.class);
    AndroidDriver driver;
    protected void prepareAndroidForAppium()  {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "LATEST");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "4.4.2");
        capabilities.setCapability("deviceName", "Samsung galaxy s2 (i9100)");
        capabilities.setCapability("app","src/main/resources/android_app/RingCentral_9.0.2.1.6_apk-dl.com.apk");
        capabilities.setCapability("appPackage", "com.ringcentral.android");
        capabilities.setCapability("appActivity", "com.ringcentral.android.LoginScreen");
        try {
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        }catch (Exception e){
            log.error("PROBLEM WITH CONNECTION TO HOST",e);
        }
    }
}
