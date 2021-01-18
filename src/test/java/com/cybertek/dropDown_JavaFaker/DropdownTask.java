package com.cybertek.dropDown_JavaFaker;

import com.cybertek.utillities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownTask {
WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
driver= WebDriverFactory.getDriver("chrome");
driver.get("http://practice.cybertekschool.com/dropdown");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @Test
    public void test2_verify_state_dropDown(){

    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }




    /*
    3. Select Illinois
    4. Select Virginia
    5. Select California
    6. Verify final selected option is California.
     */

}
