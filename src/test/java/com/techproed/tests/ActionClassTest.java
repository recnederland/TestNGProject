package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class ActionClassTest extends TestBase {
    @Test
    public void rightClick(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement element = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }
    @Test
    public void ciftTiklama(){
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        // <button ondblclick="myFunction()">Double-Click Me To See Alert</button>
        WebElement button = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(button).perform();
    }
    @Test
    public void hoverOver(){
        driver.get("https://amazon.com");
        WebElement menu = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).perform();
    }
    @Test
    public void downUp(){
        driver.get("https://amazon.com");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.sendKeys(Keys.END).perform();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.sendKeys(Keys.PAGE_UP).perform();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.sendKeys(Keys.HOME).perform();
        // yon tuslari
        actions.sendKeys(Keys.ARROW_RIGHT).perform();
    }
    // Sonraki gun
    @Test
    public void buyukKucukYazma(){
        driver.get("http://google.com");
//        WebElement gaAkkord = driver.findElement(By.className("jyfHyd"));
//        gaAkkord.click();
        WebElement searchBox = driver.findElement(By.name("q"));
//        searchBox.sendKeys("fiets");
        // klavye kullanarak buyuk yazma
//        searchBox.sendKeys(Keys.SHIFT + "fiets");
//        searchBox.click();
        // klavye kullanarak bazen buyuk harfle
        // bazen de kucuk harfle yamak icin action class kullanmaliyiz
        Actions actions = new Actions(driver);
        actions.moveToElement(searchBox).click()
                .keyDown(Keys.SHIFT).sendKeys("Kazim")
                .keyUp(Keys.SHIFT).sendKeys("Merhaba")
                .keyDown(Keys.SHIFT).sendKeys("Nasilsiniz?")
                .perform();


    }
}
