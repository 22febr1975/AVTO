package ex22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*Найти как можно кликнуть на кнопку "Вход" элемент используя 4
        различных локатора(Это могут быть и 4 варианта xpath, нужно чтобы они отличались)*/
public class ex22_1 {
    private static class url{
        private static final String uhomki = "https://uhomki.com.ua/koshki/1074/";
           }
          private static class Locators {
           private static final By a = By.xpath("//a[@class='userbar__button __active']");
              private static final By b = By.xpath("//*[@id=\"sign-in\"]/div/a");
    }
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url.uhomki);
//        driver.findElements(By.tagName("span")).get(10).click();
//        driver.findElement(By.linkText("Вход")).click();
//        driver.findElement(By.partialLinkText("Вход")).click();
        driver.findElement(Locators.a).click();
        driver.findElement(Locators.b).click();
    }
}
