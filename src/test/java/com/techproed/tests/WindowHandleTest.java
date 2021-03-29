package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleTest extends TestBase {
    // TestBase class'ini miras almis oluyoruz
    // Artik @beforeClass veya @AfterClass yazmaya gerek yok

    @Test
    public void cokluPencereTest(){
        driver.get("https://the-internet.herokuapp.com/windows");

        String sayfainHandle = driver.getWindowHandle();
        System.out.println("Birinci sayfanin handle degeri: " + sayfainHandle); // CDwindow-9268C2D367367FF0F25C83EF2DD6FD19

        driver.findElement(By.partialLinkText("Click Here")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        String ikinciSayfaHAndle = driver.getWindowHandle();
//        System.out.println(ikinciSayfaHAndle);
        // tum sayfalarin handle'ni set ile alabiliriz ve foreach ile yazdirabiliriz
        Set<String> tumPencereler = driver.getWindowHandles();
        for(String handle : tumPencereler) {
            System.out.println("Tum pencerelerin handle degerleri: " +handle); // CDwindow-763B9305B84E2CEA36243DECD09A0F59
        }
        // Son sayfanin handle'ni bulalim
        String ikinciSayfaHandle = (String)((tumPencereler.toArray())[tumPencereler.size()-1]);
        System.out.println("Ikinci sayfanin handle degeri: " + ikinciSayfaHandle);

        // Array hakkinda bilgiler
        // tumPencereler.toArray();
        // Alttaki set icindeki arraylara kolay yoldan ulasma yontemi
//        String[] array = (String[]) tumPencerelerim.toArray();  // java cast konusu
//        String ikinciSayfaHandli = array[array.length-1];
//        System.out.println("Uzun array yontemiyle son sayfa handle degeri: " + ikinciSayfaHandli);
    }
}
