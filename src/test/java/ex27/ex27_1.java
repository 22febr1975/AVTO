package ex27;
/*
Открыть сайт https://dan-it.com.ua/uk/ . На этой странице открыть в новых вкладках ссылки “Java”, “Quality Assurance (QA)”,
 “FrontEnd”. Прописать тест, проверяющий количество открытых окон. Он должен проходить, если количество открытых окон равно 4.
*/

import ex26.Waiters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

import static java.sql.DriverManager.getDriver;
import static org.openqa.selenium.Keys.CONTROL;
import static org.testng.Assert.*;

import static org.testng.AssertJUnit.assertEquals;

public class ex27_1 {
    private static class url{
        private static final String test = "https://dan-it.com.ua/uk/";
    }
    private static class Locators {
        private static final By c = By.xpath("/html/body/header/div/nav/ul/li[2]/a");


    }
    @Test
    public void openWebPages() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ex27_1.url.test);
        int a = 1;
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a[text()='Для дорослих']"))).perform();
        (new Waiters(driver)).waitForVisabilityOfElement(driver.findElement
                (By.xpath
                        ("/html/body/header/div/nav/ul/li[2]/ul/li[3]/a")));
        WebElement frontEnd = driver.findElement
                (By.xpath
                        ("/html/body/header/div/nav/ul/li[2]/ul/li[3]/a"));
        actions.keyDown(CONTROL).click(frontEnd).keyUp(CONTROL).build().perform();
        a = a+1;
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(driver.findElement(By.xpath("//a[text()='Для дорослих']"))).perform();
        (new Waiters(driver)).waitForVisabilityOfElement(driver.findElement
                (By.xpath
                        ("/html/body/header/div/nav/ul/li[2]/ul/li[6]/a")));
        WebElement java = driver.findElement
                (By.xpath
                        ("/html/body/header/div/nav/ul/li[2]/ul/li[6]/a"));
        actions1.keyDown(CONTROL).click(java).keyUp(CONTROL).build().perform();
        a = a+1;
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(driver.findElement(By.xpath("//a[text()='Для дорослих']"))).perform();
        (new Waiters(driver)).waitForVisabilityOfElement(driver.findElement
                (By.xpath
                        ("/html/body/header/div/nav/ul/li[2]/ul/li[8]/a")));
        WebElement qualityAssurance = driver.findElement
                (By.xpath
                        ("/html/body/header/div/nav/ul/li[2]/ul/li[8]/a"));
        actions2.keyDown(CONTROL).click(qualityAssurance).keyUp(CONTROL).build().perform();
        a=a+1;
        if (a==4){System.out.println("Тест пройден.");}else {System.out.println("Тест не пройден.");}

      driver.quit();
    }
}
