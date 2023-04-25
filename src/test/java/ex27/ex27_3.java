package ex27;
/*
Открыть сайт https://uhomki.com.ua/ru/. Ввести в строку поиска слово “смесь” и совершить поиск. Проверить что слово
“смесь” присутствует в сообщении о результатах поиска. После ввести в строку поиска слово “спесь” и совершить поиск.
        Проверить что слово “спесь” присутствует в сообщении о результатах поиска. После ввести в строку поиска слово
        “ересь” и совершить поиск. Проверить что слово “ересь” присутствует в сообщении о результатах поиска.
*/
import ex23.ex23_5;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ex27_3 {
    public static class url{
        public static final String homki = "https://uhomki.com.ua/ru/";
    }
    public static class Locators {
        public static final By c = By.cssSelector(".search__input");


    }
    @Test
    public void haveStrings() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url.homki);
        Thread.sleep(3000);
        driver.findElement(Locators.c).sendKeys("смесь"+"\n");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/form/div[1]"));
        Thread.sleep(3000);
        String str = driver.getPageSource();
        if (str.contains("смесь")==true){System.out.println("Слово “смесь” присутствует в сообщении о результатах поиска");}
        else {System.out.println("Слово “смесь” отсутствует в сообщении о результатах поиска");}
        Thread.sleep(3000);
        Actions action = new Actions(driver);
        Action dblclick = action.doubleClick(driver.findElement(Locators.c)).build();
        ((Action) dblclick).perform();
        Thread.sleep(1000);
        driver.findElement(Locators.c).sendKeys("спесь"+"\n");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/form/div[1]"));
        Thread.sleep(3000);
        String str1 = driver.getPageSource();
        if (str.contains("спесь")==true){System.out.println("Слово “спесь” присутствует в сообщении о результатах поиска");}
        else {System.out.println("Слово “спесь” отсутствует в сообщении о результатах поиска");}
        Actions action1 = new Actions(driver);
        Action dblclick1 = action1.doubleClick(driver.findElement(Locators.c)).build();
        ((Action) dblclick1).perform();
        Thread.sleep(1000);
        driver.findElement(Locators.c).sendKeys("ересь"+"\n");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/form/div[1]"));
        Thread.sleep(3000);
        String str2 = driver.getPageSource();
        if (str.contains("ересь")==true){System.out.println("Слово “ересь” присутствует в сообщении о результатах поиска");}
        else {System.out.println("Слово “ересь” отсутствует в сообщении о результатах поиска");}
         driver.quit();
    }
}
