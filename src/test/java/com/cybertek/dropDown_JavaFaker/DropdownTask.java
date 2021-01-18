package com.cybertek.dropDown_JavaFaker;

import com.cybertek.utillities.WebDriverFactory;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
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
    public void test2_verify_state_dropDown() throws InterruptedException {

        Select StateDropdown=new Select(driver.findElement(By.xpath("//select[@id='state']")));
       // 3. Select
        Thread.sleep(1000);
        StateDropdown.selectByVisibleText("Illinois");
       // 4. Select Virginia
        Thread.sleep(1000);
        //StateDropdown.selectByVisibleText("Virginia");
        StateDropdown.selectByValue("VA");
       // 5. Select California
       // StateDropdown.selectByValue("CA");
        StateDropdown.selectByIndex(5);
       // 6. Verify final selected option is California.
        String expectedOption="California";
        //finding currently option
        String actualOption = StateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"Final selected option is not as expected");

    }
    @Test
    public void test3_date_dropdown_verificaton() throws InterruptedException {
        //Select "December 1 , 1922" and verify it is selected.
        Select YearDropdown=new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select MonthDropdown=new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dateDropdown=new Select(driver.findElement(By.xpath("//select[@id='day']")));
        Thread.sleep(1000);
        YearDropdown.selectByVisibleText("1922");
        Thread.sleep(1000);
        MonthDropdown.selectByValue("11");
        Thread.sleep(1000);
        dateDropdown.selectByIndex(0);

        //   Select year using : visible text
        //   Select month using : value attribute
        //   Select day using : index number
      //expected values
        String expectedYear="1922";
        String expectedMonth="December";
        String expectedDay="1";
        //getting our actual values
        String actualYear=YearDropdown.getFirstSelectedOption().getText();
        String actualMonth=MonthDropdown.getFirstSelectedOption().getText();
        String actualday=dateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualYear,expectedYear);
        Assert.assertEquals(actualMonth,expectedMonth);
        Assert.assertEquals(actualday,expectedDay);

        Assert.assertTrue(actualYear.equalsIgnoreCase(expectedYear),"not equal");
        Assert.assertTrue(actualMonth.equalsIgnoreCase(expectedMonth),"not equal");
        Assert.assertTrue(actualday.equalsIgnoreCase(expectedDay),"not equal");

    }
  @Test
   public void test4_multiple_select_dropDown() throws InterruptedException {
      //location dropdown to work on it
      Select multipleSelectDropDown=new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
      //3. Select all the options from multiple select dropdown.
      List<WebElement>allOptions=multipleSelectDropDown.getOptions();
      //loop through the list and click to each options

      for (WebElement eachOptions : allOptions) {
          Thread.sleep(3000);
          eachOptions.click();
          //4. Print out all selected values.
          System.out.println("Selected: " + eachOptions.getText());
          Assert.assertTrue(eachOptions.isSelected(),"the option "+eachOptions.getText()+"is not selected");
      }



      //5. Deselect all values.
    multipleSelectDropDown.deselectAll();
      for (WebElement each : allOptions) {
          Assert.assertTrue(!each.isSelected(),"the option "+each.getText()+"is  selected");
      }



  }
  @Test
  public void test5_non_select_dropDown() throws InterruptedException {
       //locate non-select dropDown as regular web element
      WebElement websiteDropdown= driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));

      //3. Click to non-select dropdown
      Thread.sleep(2000);
      websiteDropdown.click();
      // 4. Select Facebook from dropdown
     Thread.sleep(1000);
      WebElement facebookLink= driver.findElement(By.xpath("//a[.='Facebook']"));
      facebookLink.click();

     //5. Verify title is "Facebook - Log In or Sign Up"
      String expectedTitle="Facebook - Log In or Sign Up";
      String actualTitle=driver.getTitle();

      Assert.assertEquals(actualTitle,expectedTitle,"title are not as expected");
  }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }





}
