package com.techproed.tests;

import com.techproed.utilities.TestBase;
import javafx.beans.value.WeakChangeListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ImplicitlyWaitTest extends TestBase {

    // implicitlyWait()
    @Test
    public void implicitlyWait(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement remove = driver.findElement(By.xpath("//*[.='Remove']"));
        remove.click();
        WebElement button = driver.findElement(By.xpath("//*[.='Add']"));
        // button.click();
    }
    // explicitWait()
    @Test
    public void explicitWait(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // explicitWait() kullanmak icin WebDriverWait class'indan nesne uretmeliyiz
        WebDriverWait wait = new WebDriverWait(driver,30);
        // remove butonuna tiklayalim
        // <button autocomplete="off" type="button" onclick="swapCheckbox()">Remove</button>
        WebElement remove = driver.findElement(By.xpath("//*[.='Remove']"));
        remove.click();
        // WebElement done = driver.findElement(By.id("message"));
        // Simdi explicitWait kullanarak bekletme yapalim
        WebElement done = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        System.out.println(done.getText());

    }
}
