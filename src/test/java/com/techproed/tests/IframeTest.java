package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void iframeTest1(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        // <p>Your content goes here.</p>
        // Iframe bulmak icin 3 yontem vardir:
        // 1- index degeri
        driver.switchTo().frame(0);
        // 2- id ya da name attiribute'lerini kullanarak
        // 3- Webelement olarak olsturdugumuz Iframe ile
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("Index ile Merhaba Iframe");
    }
    // 2- id ya da name attiribute'lerini kullanarak
    @Test
    public void iframeTest2(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("Id ile Merhaba Iframe");
    }
    // 3- Webelement olarak olsturdugumuz Iframe ile
    @Test
    public void iframeTest3(){
        driver.get(("https://the-internet.herokuapp.com/iframe"));
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("Bulunan Webelement ile Merhaba Iframe");
    }
    @Test
    public void iframeTest4(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(0);
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("Index ile Merhaba Iframe");
        // Iframe'den cikip normal sayfaya donmemiz lazim
        // iframe'den cikis yapmak icin iki yontem var
        // 1- defaultContent();
        // driver.switchTo().defaultContent();
        // 2- defaultContent();
        driver.switchTo().parentFrame();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // <a target="_blank" href="http://elementalselenium.com/">Elemental Selenium</a>
        WebElement seleniumElement = driver.findElement(By.partialLinkText("Elemental Selenium"));
        seleniumElement.click();
    }
}
