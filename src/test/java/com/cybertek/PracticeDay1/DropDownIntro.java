package com.cybertek.PracticeDay1;

import com.cybertek.utillities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropDownIntro {

    WebDriver driver;

     @BeforeClass
     public void setupClass(){


         //TC#1: Verifying "Simple dropdown" and "State selection" dropdown default values

         //1. Open Chrome browser

         //2. Go to http://practice.cybertekschool.com/dropdown
          driver= WebDriverFactory.getDriver("chrome");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

         driver.get("http://practice.cybertekschool.com/dropdown");
     }
       @Test
       public void dropdown_test1(){
         //3. Verify "Simple dropdown" default selected value is correct
           //Expected: "Please select an option"
           WebElement simpleDropDown= driver.findElement(By.xpath("//select[@id='dropdown']"));
           Select select =new Select(simpleDropDown);
           //this method will return us the currently selected option of a web element
           WebElement currentlySelectedOption=select.getFirstSelectedOption();
           String expectedDefaultValue="Please select an option";
         String actualDefaultValue = currentlySelectedOption.getText();

           Assert.assertEquals(actualDefaultValue,expectedDefaultValue);
           //4. Verify "State selection" default selected value is correct
           //Expected: "Select a State"

           WebElement stateSelection= driver.findElement(By.xpath("//select[@id='state']"));
           Select select1=new Select(stateSelection);
          WebElement currentlyStateSelection =select1.getFirstSelectedOption();
          String expectStateDefault="Select a State";
          String actualStateDefault=currentlyStateSelection.getText();

    }
}
