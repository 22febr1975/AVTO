package ex22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ex22_3 {
    private static class url{
    private static final String danIt = "https://dan-it.com.ua/uk/";
}
 private static class Locators {
    private static final By a = By.xpath("/html/body/main/section[1]/div/div/div/a");
}
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url.danIt);
        driver.findElement(Locators.a).click();
    }
}
