package com.cybertek.PracticeDay1;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGIntro {
  @BeforeMethod
   public void setupMethod(){
      System.out.println("Before method is running.....");
   }
   @AfterMethod
   public void teardownMethod(){
       System.out.println("After method is running.....");
   }
    @BeforeClass
  public void setupClass(){
      System.out.println("Before class is running.....");
  }
  @AfterClass
  public void teardownClass(){
      System.out.println("After class is running....");
  }
   @Test
    public void test1(){
       System.out.println("Running Test 1....");
   }
   @Test
    public void test2(){
       System.out.println("Running test2......");
   }
   @Test
   public void test3(){
       System.out.println("Running test3 .......");

       String str1="hello";
       String str2="hello";
       String str3="hello";

       //asserTrue: expects a boolean value is passed
       Assert.assertTrue(str1.equals(str2),"comparing hello worlds failed");

       Assert.assertEquals(str1,str3,"Asserting with asstEquals on line56");
   }
}
