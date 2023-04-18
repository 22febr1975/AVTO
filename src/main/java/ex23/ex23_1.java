package ex23;
/*
1)
        Написать программу, которая будет открывать пять различных страниц в новых окнах:
        https://uhomki.com.ua/ru/koshki/1074/
        https://zoo.kiev.ua/
        https://www.w3schools.com/
        https://taxi838.ua/ru/dnepr/
        https://klopotenko.com/

        Прописать цикл, который будет переключаться поочередно через все страницы,
        для каждой страницы выводить в консоль название и ссылку на эту страницу.
        И будет закрывать ту страницу в названии которой есть слово зоопарк.
*/

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.management.Descriptor;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class ex23_1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uhomki.com.ua/ru/koshki/1074/");
        String a1 = driver.getTitle();
        System.out.println(a1);
        System.out.println(driver.getCurrentUrl());
        String descrt1= driver.getWindowHandle();
        Set<String> set1 = driver.getWindowHandles();
        ((JavascriptExecutor)driver).executeScript("window.open()");
        Set<String> set2 = driver.getWindowHandles();
        set2.removeAll(set1);
        String descrt2= set2.iterator().next();
        driver.switchTo().window(descrt2);
        driver.navigate().to("https://zoo.kiev.ua/");
        String a2 = driver.getTitle();
        System.out.println(a2);
        System.out.println(driver.getCurrentUrl());
        String descrt3= driver.getWindowHandle();
        Set<String> set3 = driver.getWindowHandles();
        ((JavascriptExecutor)driver).executeScript("window.open()");
        Set<String> set4 = driver.getWindowHandles();
        set4.removeAll(set3);
        String descrt4= set4.iterator().next();
        driver.switchTo().window(descrt4);
        driver.navigate().to("https://www.w3schools.com/");
        String a3 = driver.getTitle();
        System.out.println(a3);
        System.out.println(driver.getCurrentUrl());
        String descrt5= driver.getWindowHandle();
        Set<String> set5 = driver.getWindowHandles();
        ((JavascriptExecutor)driver).executeScript("window.open()");
        Set<String> set6 = driver.getWindowHandles();
        set6.removeAll(set5);
        String descrt6= set6.iterator().next();
        driver.switchTo().window(descrt6);
        driver.navigate().to("https://taxi838.ua/ru/dnepr/");
        String a4 = driver.getTitle();
        System.out.println(a4);
        System.out.println(driver.getCurrentUrl());
        String descrt7= driver.getWindowHandle();
        Set<String> set7 = driver.getWindowHandles();
        ((JavascriptExecutor)driver).executeScript("window.open()");
        Set<String> set8 = driver.getWindowHandles();
        set8.removeAll(set7);
        String descrt8= set8.iterator().next();
        driver.switchTo().window(descrt8);
        driver.navigate().to("https://klopotenko.com/");
        String a5 = driver.getTitle();
        System.out.println(a5);
        System.out.println(driver.getCurrentUrl());
if (a1.contains("зоопарк")==true){driver.switchTo().window(descrt1);driver.close();}
if (a2.contains("зоопарк")==true){driver.switchTo().window(descrt2);driver.close();}
if (a3.contains("зоопарк")==true){driver.switchTo().window(descrt3);driver.close();}
if (a4.contains("зоопарк")==true){driver.switchTo().window(descrt4);driver.close();}
if (a5.contains("зоопарк")==true){driver.switchTo().window(descrt5);driver.close();}
   /*     String [] a = {descrt1,descrt2,descrt3,descrt4,descrt5};
        for (int i =0; i<4;i++){*/

        }
//        driver.findElement(By.xpath("//*[@id=\"sign-in\"]/div/a")).click();
    }

