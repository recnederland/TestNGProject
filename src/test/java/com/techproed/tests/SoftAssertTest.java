package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertTest {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void test01(){
        driver.get("https://amazon.com");
        String baslik = driver.getTitle();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(baslik.contains("Amazon")); // expected [false] but found [true],
        softAssert.assertTrue(baslik.contains("Car"));     // expected [true] but found [false],
        softAssert.assertEquals("Online", baslik);   // expected [Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more] but found [Online]
        softAssert.assertAll();// bit dogrulama bile yanlissa yanlis / false aliriz, hep ya da hic

    }
    @Test
    public void test02(){
        driver.get("http://a.testaddressbook.com/sign_in");
        // softAssert icin gerekli
        SoftAssert softAssert = new SoftAssert();

        WebElement emailKutusu = driver.findElement(By.id("session_email"));
        emailKutusu.sendKeys("testtechproed@gmail.com");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // softAssert yapalim
        softAssert.assertFalse(emailKutusu.getText().equals("testtechproed@gmail.com"));
        WebElement sifreKutusu = driver.findElement(By.id("session_password"));
        sifreKutusu.sendKeys("Test1234!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // softAssert yapalim
        softAssert.assertFalse(sifreKutusu.getText().equals("Test1234!"));
        WebElement sigInButton = driver.findElement(By.name("commit"));
        sigInButton.click();
        WebElement signOutLink = driver.findElement(By.partialLinkText("Sign out"));
        boolean gorunuyorMu = signOutLink.isDisplayed();
        // hardAssert
        // Assert.assertTrue(gorunuyorMu);
        // Simdi softAssert ile dogrulama yapalim, bunun icin yukariya softAssert nesnesi olusturalim
        softAssert.assertAll();// her adim icin dogrulama yapabiliriz
    }
}
