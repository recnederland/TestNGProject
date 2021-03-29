package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class JSAlertTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void jsAlertTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // <button onclick="jsAlert()">Click for JS Alert</button>
        // xpath, cssSelector, tagName
        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        button.click();

        // alerti kullanmak icin o alerte gecis yapmak lazim
        // alertin icerdigi mesaji almak icin
        String alertMesaji = driver.switchTo().alert().getText();
        System.out.println(alertMesaji);
        // alertin OK butonuna tiklamak icin
        driver.switchTo().alert().accept();
    }
    @Test
    public void jsConfirmTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // <button onclick="jsConfirm()">Click for JS Confirm</button>
        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        button.click();
        String mesaj = driver.switchTo().alert().getText();
        System.out.println(mesaj);
        driver.switchTo().alert().dismiss();
        System.out.println(mesaj);
    }
    @Test
    public void jsPromptTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // <button onclick="jsPrompt()">Click for JS Prompt</button>
        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        button.click();
        String text = driver.switchTo().alert().getText();
        System.out.println(text);
        driver.switchTo().alert().sendKeys("Recep");
        driver.switchTo().alert().accept();
        // text.contains("Recep");
        // <p id="result" style="color:green">You entered: null</p>
        WebElement resultText = driver.findElement(By.id("result"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("You entered: null", resultText);
    }


}
