package FrameExample.firstPage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SecondPage {
    @Test
    public void openPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pampik.com/ua");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"category-menu\"]/ul/li[1]/a/span[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[3]/ul/li[1]/a[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"products-list\"]/li[1]/div/a/span/span[1]/img")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"1630\"]")).click();
        System.out.println(driver.getTitle());
        assertEquals(driver.getTitle(), "≡ Підгузки на липучках Pampers Premium Care 4 (9-14 кг), 104 шт. ᐈ Купити Pampers Premium Care 4 - ціна PAMPIK",
                "Страница не открыта, я ожидал другого");
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void purchaseGoods() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pampik.com/ua/catalog/podguzniki-pampers-premium-care-4-9-14-kg-168-sht");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"307647\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"cart-block\"]/a[1]/span[1]")).click();
        System.out.println(driver.getTitle());
        assertEquals(driver.getTitle(), "Оформлення замовлення",
                "Страница не открыта, я ожидал другого");
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void ordering() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pampik.com/ua/catalog/podguzniki-pampers-premium-care-4-9-14-kg-168-sht");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"307647\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"cart-block\"]/a[1]/span[1]")).click();
        System.out.println(driver.getTitle());
        assertEquals(driver.getTitle(), "Оформлення замовлення",
                "Страница не открыта, я ожидал другого");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div[2]/div/button")).click();
        driver.quit();
    }

    @Test
    public void ordering1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pampik.com/ua/catalog/podguzniki-pampers-premium-care-4-9-14-kg-168-sht");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"307647\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"cart-block\"]/a[1]/span[1]")).click();
        System.out.println(driver.getTitle());
        assertEquals(driver.getTitle(), "Оформлення замовлення",
                "Страница не открыта, я ожидал другого");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div[2]/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div[1]/div[1]/div[2]/input")).
                sendKeys(Keys.HOME + "0507737323" + "\n");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("Пупкин" + "\n");
        driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("Петя" + "\n");
        driver.findElement(By.xpath("//*[@id=\"middlename\"]")).sendKeys("Вася" + "\n");
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("1234@mail.ru" + "\n");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"house\"]")).sendKeys("1" + "\n");
        driver.findElement(By.xpath("//*[@id=\"entrance\"]")).sendKeys("1" + "\n");
        driver.findElement(By.xpath("//*[@id=\"floor\"]")).sendKeys("3" + "\n");
        driver.findElement(By.xpath("//*[@id=\"flat\"]")).sendKeys("1" + "\n");
        driver.quit();
    }

    @Test
    public void ordering2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pampik.com/ua/catalog/podguzniki-pampers-premium-care-4-9-14-kg-168-sht");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"307647\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"cart-block\"]/a[1]/span[1]")).click();
        System.out.println(driver.getTitle());
        assertEquals(driver.getTitle(), "Оформлення замовлення",
                "Страница не открыта, я ожидал другого");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div[2]/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[1]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div[1]/div[4]/div/div/section/div/div/section/div/div[3]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div[1]/div[4]/div/div/section/div/div/section/div/div[3]/section/button[2]/span")).click();
       driver.quit();
    }
}