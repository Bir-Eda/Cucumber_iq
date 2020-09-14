package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.sql.Driver;
import java.util.List;

// How do handle dynamic table?
public class HandlingDynamicTable {

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        // Dynamic element: sayfa yenilendiginde icindeki bilgilerde degisir

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/web-table-element.php");
//        List<WebElement> colm = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/td"));
//        List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td[1]/a"));

        // 1. yol
//        System.out.println(colm.size());
//        System.out.println(rows.size());
//
//        for(WebElement eachColm: colm){
//            System.out.println(eachColm.getText());
//        }
//        for(WebElement eachRow: rows){
//            System.out.println(eachRow.getText());
//
//            if(eachRow.getText().equals("Kwality")){
//                eachRow.click();
//            }
//        }

        // 2.  yol
        String beforeXpath ="//*[@id=\"leftcontainer\"]/table/tbody/tr[";
        String afterXpath ="]/td[1]/a";
        List<WebElement> totalColm = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
        List<WebElement> toatlRows = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr"));
        int rowCount=toatlRows.size();
        int colCount= totalColm.size();
        System.out.println(rowCount);
        System.out.println(colCount);
        for(int i=0; i<=rowCount; i++){
            String companyXpath=beforeXpath+i+afterXpath;
            WebElement companyName=driver.findElement(By.xpath(companyXpath));
            System.out.println(companyName.getText());
            if(companyName.getText().equals("UCO Bank")){
                System.out.println(companyName.getText()+i);
                break;
    }
}

        // 1. yol icin  assert
//        Assert.assertEquals(5, colm.size());
//        Assert.assertEquals(26, rows.size());
//        Thread.sleep(2000);
//        driver.quit();


        // 2. yol icin assert
        Assert.assertEquals(5, colCount);
        Assert.assertEquals(26, rowCount);
        Thread.sleep(2000);
        driver.quit();

    }

}

















