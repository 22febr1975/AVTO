package ex23;

import ex22.ex22_8;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*5)
        Написать программу, которая повторит действия на видео "Задание 5.mp4".*/
public class ex23_5 {
    private static class url{
        private static final String homki = "https://uhomki.com.ua/ru/";
    }
    private static class Locators {
                private static final By c = By.cssSelector(".search__input");
        private static final By a = By.cssSelector(".search-results__title");
        private static final By b = By.cssSelector(".comparison-button__text");
        private static final By d = By.cssSelector(".comparison-view__button-text");
        private static final By w = By.cssSelector(".compare-close j-close");

    }
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ex23_5.url.homki);
       driver.findElement(ex23_5.Locators.c).sendKeys("Хорек");
       Thread.sleep(3000);
        driver.findElement(ex23_5.Locators.a).click();
        Thread.sleep(2000);
        driver.findElement(ex23_5.Locators.b).click();
        Thread.sleep(2000);
        driver.findElement(ex23_5.Locators.c).sendKeys("Медведь");
        Thread.sleep(3000);
        driver.findElement(ex23_5.Locators.a).click();
        Thread.sleep(2000);
        driver.findElement(ex23_5.Locators.b).click();
        Thread.sleep(2000);
        driver.findElement(ex23_5.Locators.d).click();
        Thread.sleep(2000);
//        driver.findElement(ex23_5.Locators.w).click();
        driver.close();
        Thread.sleep(2000);
        driver.quit();
    }

}
