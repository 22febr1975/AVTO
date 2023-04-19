package ex27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ex27_4 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        Thread.sleep(4000);
        int startX = driver.findElement(By.id("RememberMe"))
                .getLocation().x;
        System.out.println(startX);
        int startY = driver.findElement(By.id("RememberMe"))
                .getLocation().y;
        System.out.println(startY);
    }
}
