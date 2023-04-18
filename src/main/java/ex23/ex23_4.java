package ex23;
/*
4)
        Написать метод, который будет выводить в консоль тексты всех
        элементов, которые можно найти по заданнму параметру.
        Например при помощи него можно будет получить значения всех элементов
        из списков заданных на "Рисунок 4.png" и "Рисунок 5.png".
*/
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;
public class ex23_4 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://uhomki.com.ua/ru/koshki/1074/");
        driver.findElements(By.cssSelector(".products-menu__title"));
        ArrayList<WebElement> listOfElem = new ArrayList<>(driver.findElements(By.cssSelector(".products-menu__title")));
        System.out.println("Список текстов элементов с \"Рисунок 4.png\"");
        for (WebElement webElement : listOfElem) {

            System.out.println(webElement.getText());
        }
        driver.findElements(By.cssSelector(".footer__menu-item "));
        ArrayList<WebElement> listOfElem1 = new ArrayList<>(driver.findElements(By.cssSelector(".footer__menu-item ")));
        System.out.println("Список текстов элементов с \"Рисунок 5.png\"");
        for (WebElement webElement : listOfElem1) {

            System.out.println(webElement.getText());
        }
    }
}