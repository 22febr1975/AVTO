package ex22;
/*найти локаторы к двум данным кнопкам.
        Пользоваться любыми локаторами и методами.*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ex22_10 {
    private static class url{
        private static final String idea = "https://www.jetbrains.com/idea/download/#section=windows";
    }
    private static class Locators {
        private static final By a = By.xpath("//*[@id=\"download-block\"]/section[1]/div/div/div[2]/div/div/div[2]/div[1]/div/div[1]/div/div[2]/span/a");
        private static final By b = By.xpath("//*[@id=\"download-block\"]/section[1]/div/div/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[2]/span/a");
    }
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url.idea);
//        driver.findElement(Locators.a).click();
  driver.findElement(Locators.b).click();
    }
}
