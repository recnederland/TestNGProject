package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest extends TestBase {

     //   Test olmayan siradan methodlar RUN dedigimizde tek baslarina calismazlar
//    public void girisTest(){
//        driver.get("http://www.fhctrip-qa.com/admin/HotelRoomAdmin");
//        driver.findElement(By.id("UserName")).sendKeys("manager2");
//        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);
//    }
    public void girisTest(){
        driver.get("http://www.fhctrip-qa.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);
    }
    @Test
    public void table(){
        // siradan methodlar Test methodlari icerisinde cagirilabilir
        girisTest();
        try {
            Thread.sleep(4000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        // Tabloyu ekrana yazdiralim
        WebElement tbody = driver.findElement(By.xpath("//tbody"));
        System.out.println("Tablo icerigi: " + tbody.getText());
        // Basliklari ekrana yazdiralim
        //  //thead/tr/th
        List<WebElement> basliklar = driver.findElements(By.xpath("//thead/tr/th"));
        for (WebElement baslik : basliklar) {
            System.out.print("Basliklar:" + " " + baslik.getText());
        }

    }
    // tum satirlari alip ekrana yazdiralim
    @Test
    public void tumSatirlar(){
        girisTest();
        try {
            Thread.sleep(4000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        List<WebElement> tumSatirlar = driver.findElements(By.xpath("//tbody/tr"));
        for (WebElement satir : tumSatirlar) {
            System.out.print("Tum satirlar:" + " " + satir.getText());
        }

    }
    // tablodaki tum hucreleri alalim
    @Test
    public void tumHucreler(){
        girisTest();
        try {
            Thread.sleep(4000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        List<WebElement> tumHucreler = driver.findElements(By.xpath("//tbody/tr/td"));
        for (WebElement hucre : tumHucreler) {
            System.out.println("Tum hucreler:" + hucre.getText());
        }
    }
    // name sutununu yazdiralim
    //          //tbody/tr/td[4]       ya da   //tbody//td[4]
    //   tek slash / eklersek basamak basamak gittigimiz anlamina gelir, yani child aranir
    // ancak cift slash eklersek child torun veya torununun torunu olabilir
    @Test
    public void tumSutunlar(){
        girisTest();
        try {
            Thread.sleep(4000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        List<WebElement> nameSutunu = driver.findElements(By.xpath("//tbody//td[4]"));
        for (WebElement name : nameSutunu) {
            System.out.print("Dorduncu sutun / Name: " + name.getText());
        }

    }
    // tek bir hucreyi alabiliriz
    @Test
    public void tekHucre(){
        girisTest();
        try {
            Thread.sleep(4000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        List<WebElement> dorduncuHucre = driver.findElements(By.xpath("//tbody/tr[4]/td[6]"));
        for (WebElement tekHucre : dorduncuHucre) {
            System.out.print("Dorduncu satir Altinci sutun: " + tekHucre.getText());
        }

    }
    // Dinamik kodlarla tek bir hucrenin yazdirilmasi / cagrilmasi
    //   //tbody/tr[3]/td[2]  3. satir 2. sutun
    //   //tbody/tr[3]/td[4]
    public void hucreYazdir(int satir, int sutun){
        String xpathDegerim = "//tbody/tr["+ satir + "]/td[" + sutun + "]";
        WebElement hucre = driver.findElement(By.xpath(xpathDegerim));
        System.out.println(hucre.getText());
    }
    @Test
    public void calistir(){
        girisTest();
        hucreYazdir(3,4);  // Maev
    }

}
