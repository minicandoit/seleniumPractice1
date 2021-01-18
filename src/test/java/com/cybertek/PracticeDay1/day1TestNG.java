package com.cybertek.PracticeDay1;

import com.cybertek.utillities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class day1TestNG {

    public static void main(String[] args) throws InterruptedException {
        //1. Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        //WebDriver driver = WebDriverFactory.getDriver("chrome");
        //2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html

        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //by default 0....given time will be used as additional wait time.it will wait until condition happens
        //3. Verify "Success – Check box is checked" message is NOT displayed.
        WebElement successMessage= driver.findElement(By.xpath("//div[@id='txtAge']"));
        //option#2 xpath and style   //div[@style='display: block;']
        //op#3      xpath and text value  //div[.='Success - Check box is checked']

        //location check box
        WebElement checkBox1= driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        if(!checkBox1.isSelected()&& !successMessage.isDisplayed()){
            System.out.println("checkbox is not selected and message is not displayed pass");
        }else{
            System.out.println("fail");
        }
        //4. Click to checkbox under "Single Checkbox Demo" section
        Thread.sleep(2000);
        checkBox1.click();

        // 5. Verify "Success – Check box is checked" message is displayed.
        if(checkBox1.isSelected()&& successMessage.isDisplayed()){
            System.out.println("checkbox is  selected and message is  displayed pass");
        }else{
            System.out.println("fail");
        }
        driver.close();


    }
    }


