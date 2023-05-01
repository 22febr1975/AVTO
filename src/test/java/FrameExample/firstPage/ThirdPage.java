package FrameExample.firstPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ThirdPage {
    @Test
    public void productCart() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pampik.com/ua/catalog/nabor-bezmolochnaya-kasha-milupa-multizlakovaya-3h170-g");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"slider-big\"]/div/div/div[1]/div/img")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[8]/div/div/div[2]/button[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[8]/div/button")).click();
        Thread.sleep(1000);
        driver.quit();
    }
    @Test
    public void productCart1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pampik.com/ua/catalog/nabor-bezmolochnaya-kasha-milupa-multizlakovaya-3h170-g");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"product-block\"]/div[2]/div[1]/div/div[2]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"start_review\"]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"add-testimonial\"]/div/div/div[2]/form/div[3]/textarea")).sendKeys("Пупкин" + "\n");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"add-testimonial\"]/div/div/div[2]/form/div[4]/div[1]/input")).sendKeys("+" + "\n");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"add-testimonial\"]/div/div/div[2]/form/div[4]/div[2]/input")).sendKeys("-" + "\n");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"add-testimonial\"]/div/div/div[2]/form/button")).click();
        Thread.sleep(1000);
        driver.quit();
    }
    @Test
    public void productCart2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pampik.com/ua/catalog/nabor-bezmolochnaya-kasha-milupa-multizlakovaya-3h170-g");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"product-block\"]/div[2]/div[2]/div[2]/div[2]/a/span[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"popup-login-input\"]")).sendKeys("507737323" + "\n");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"popup-pass\"]")).sendKeys("12345" + "\n");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"submit-login-modal\"]")).click();
        Thread.sleep(1000);
        driver.quit();
    }
    @Test
    public void productCart3() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pampik.com/ua/catalog/nabor-bezmolochnaya-kasha-milupa-multizlakovaya-3h170-g");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"product-tabs__control\"]/li[2]/a/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"product-tabs__control\"]/li[3]/a/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"product-tabs__control\"]/li[4]/a/span[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"product-tabs__control\"]/li[1]/a/span")).click();
        Thread.sleep(1000);
        driver.quit();
    }
    @Test
    public void productCart4() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pampik.com/ua/catalog/nabor-bezmolochnaya-kasha-milupa-multizlakovaya-3h170-g");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"product-view\"]/div[2]/div/div/div/div[2]/div/div/img")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"product-view\"]/div[2]/div/div/div/div[3]/div/div/img")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"product-view\"]/div[2]/div/div/div/div[1]/div/div/img")).click();
        Thread.sleep(1000);
        driver.quit();
    }
}
