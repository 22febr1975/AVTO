package ex22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ex22_2 {
    private static class url{
        private static final String uhomki = "https://uhomki.com.ua/koshki/1074/";
    }
    private static class Locators {
        private static final By a = By.xpath("/html/body/div[2]/div[2]/div/div[3]/div/div/div/div/div/ul/li[3]/div[1]/a");
    }
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url.uhomki);
        driver.findElement(Locators.a).click();
    }
}