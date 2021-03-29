package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonRegistretion extends TestBase {

    @Test
    public void test01(){
        driver.get("https://amazon.com");
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountList).perform();
        WebElement startLink = driver.findElement(By.partialLinkText("Start here."));
        startLink.click();
        WebElement emailText = driver.findElement(By.id("ap_customer_name"));
        emailText.sendKeys("");
        Assert.assertTrue(driver.getTitle().equals("Amazon Registration"));
        Assert.assertFalse(!driver.getTitle().equals("Amazon Registration"));
        Assert.assertEquals(driver.getTitle(), "Amazon Registration");
    }
    @Test
    public void test02(){
        WebElement name = driver.findElement(By.id("ap_customer_name"));
        name.sendKeys("recep bayram");
        WebElement email = driver.findElement(By.id("ap_email"));
        email.sendKeys("rectekbay@gmail.com");
        WebElement passwoordOne = driver.findElement(By.id("ap_password"));
        passwoordOne.sendKeys("rectekbay632");
        WebElement passwoordTwo = driver.findElement(By.id("ap_password_check"));
        passwoordTwo.sendKeys("rectekbay632");
        WebElement createButton = driver.findElement(By.id("continue"));
        createButton.click();
    }
}
