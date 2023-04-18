package ex23;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.net.Urls;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ex23_1_1 {
    public static void main(String[] args) {
        String[] urls = new String[]{"https://uhomki.com.ua/ru/koshki/1074/", "https://www.w3schools.com/",
                "https://taxi838.ua/ru/dnepr/", "https://klopotenko.com/", "https://zoo.kiev.ua/"};
        for (int i = 0; i < 5; i++) {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(urls[i]);
            String a1 = driver.getTitle();
            System.out.println(a1);
            System.out.println(driver.getCurrentUrl());
            String descrt1= driver.getWindowHandle();

        if (a1.contains("зоопарк")==true){driver.switchTo().window(descrt1);driver.close();}

    }
}}