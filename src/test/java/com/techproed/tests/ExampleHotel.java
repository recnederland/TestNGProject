package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExampleHotel extends TestBase {

    @Test
    public void girisTest(){
        driver.get("http://www.fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);
    }
    // https://fhctrip-qa.com/admin/HotelAdmin/Create
    @Test(dependsOnMethods = "girisTest")
    public void hotelCreate(){
        WebElement code = driver.findElement(By.id("Code"));
        code.sendKeys("1234");
        WebElement name = driver.findElement(By.id("Name"));
        name.sendKeys("Hagi");
        WebElement address = driver.findElement(By.id("Address"));
        address.sendKeys("Eindhoven");
        WebElement phone = driver.findElement(By.id("Phone"));
        phone.sendKeys("632145987");
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("hagi@hagi.com");

        WebElement idGroup = driver.findElement(By.id("IDGroup"));
        Select select = new Select(idGroup);
        select.selectByIndex(1);

        WebElement saveButton = driver.findElement(By.id("btnSubmit"));
        saveButton.click();

        WebElement okButton = driver.findElement(By.xpath("//button[@data-bb-handler='ok']"));
        WebDriverWait wait = new WebDriverWait(driver,15);
        WebElement succesText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));
        Assert.assertTrue(succesText.isDisplayed());
        okButton.click();

        WebElement hotelRoomsLink = driver.findElement(By.partialLinkText("Hotel Rooms"));
        hotelRoomsLink.click();

        WebElement listOfHotelRoomsText = driver.findElement(By.xpath("//*[.='List Of Hotelrooms']"));
        Assert.assertTrue(listOfHotelRoomsText.isDisplayed());
    }
}
