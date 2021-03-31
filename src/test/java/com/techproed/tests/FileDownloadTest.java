package com.techproed.tests;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
public class FileDownloadTest extends TestBase {
    @Test
    public void dosyaVarMi(){
        // Bilgisayarda hangi dosya yolundayiz?
        // C:\Users\sam s\IdeaProjects\TestNGProject
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home")); //C:\Users\sam s

        String kullaniciDosyaYolu = System.getProperty("user.dir");

        // C:\Users\sam s\IdeaProjects\TestNGProject\pom.xml
        String pomXmlDosyaYolu = kullaniciDosyaYolu + "/pom.xml";
        boolean varMi = Files.exists(Paths.get(pomXmlDosyaYolu));
        Assert.assertTrue(varMi);
    }
    // bilgisayardan dosya yukleme
    @Test
    public void fileUpload(){
        driver.get("https://the-internet.herokuapp.com/upload");
        //C:\Users\sam s\IdeaProjects\TestNGProject\techproed_logo.jpg
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        // Simdi istedigimiz dosyayi yukleyelim
        chooseFile.sendKeys("C:/Users/sam s/IdeaProjects/TestNGProject/techproed_logo.jpg");
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        WebElement elementalSelenium = driver.findElement(By.partialLinkText("Elemental Selenium"));
        Assert.assertTrue(elementalSelenium.isDisplayed());
    }
    // dosya indirme
    @Test
    public void fileDownload(){
        driver.get("https://the-internet.herokuapp.com/download");
        // C:\Users\sam s\Downloads
        WebElement foto = driver.findElement(By.partialLinkText("otp.png"));
        foto.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean varMi = Files.exists(Paths.get("C:/Users/sam s/Downloads/otp.png"));
        Assert.assertTrue(varMi);
    }

}
