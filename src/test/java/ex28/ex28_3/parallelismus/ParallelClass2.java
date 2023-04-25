package ex28.ex28_3.parallelismus;

import ex26.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

public class ParallelClass2 {
    private static class url{
        private static final String homki = "https://uhomki.com.ua/ru/";
    }
    private static class Locators {
        private static final By c = By.cssSelector(".search__input");


    }
    @Test
    public void parallel6() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://klopotenko.com/");
        WebElement element = (new Waiters(driver)
                .waitForPresenceOfElementLocated(By.xpath("//a[@aria-label='dismiss cookie message']")));
        element.click();
        assertTrue(driver.getTitle().equals("Євген Клопотенко - Кулінарні рецепти від Євгена Клопотенка"), "Названия страниц не совпадают," +
                " я ожидал другого");
        assertFalse(driver.getTitle().equals("Євген Клоп4отенко - Кулінарні рецепти від Євгена Клопотенка"), "Названия страниц не совпадают," +
                " я ожидал другого");
//        assertEquals(driver.getTitle(), "Євген Клопотенко - Кулінарні рецепти від Євгена Клопотенка", "Названия страниц не совпадают");
        assertNotEquals(driver.getTitle(), "Євген Клопот4енко - Кулінарні рецепти від Євгена Клопотенка", "Названия страниц не совпадают");
        driver.quit();
    }

    @Test
    public void parallel7() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://klopotenko.com/login/");
        WebElement element = (new Waiters(driver)
                .waitForPresenceOfElementLocated(By.xpath("//a[@aria-label='dismiss cookie message']")));
        element.click();
        WebElement checkbox = (new Waiters(driver)
                .waitForPresenceOfElementLocated(By.xpath("//i[@class='um-icon-android-checkbox-outline-blank']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        assertFalse(checkbox.isSelected(), "Чекбокс уже нажат");
        checkbox.click();
        WebElement newCheckBox = (new Waiters(driver)
                .waitForPresenceOfElementLocated(By.xpath("//i[@class='um-icon-android-checkbox-outline']")));
        (new Waiters(driver)).waitForVisabilityOfElement(driver.findElement(By.xpath("//i[@class='um-icon-android-checkbox-outline']")));
        assertFalse(newCheckBox.isSelected(), "Чекбокс уже нажат");
        checkbox.click();
        assertFalse(checkbox.isSelected(), "Чекбокс уже нажат");
        driver.quit();
    }

    @Test
    public void parallel8() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://klopotenko.com/solodko-yaskravo-aromatno-zapechena-morkva-z-rozmarynom-i-mandarynovym-sokom-vid-yevgena-klopotenka/");
        WebElement element = (new Waiters(driver)
                .waitForPresenceOfElementLocated(By.xpath("//a[@aria-label='dismiss cookie message']")));
        element.click();
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='col-12 col-md-6']/div/div"));
        assertTrue(elements.size() == 5, "Количество ингридиентов не равно 5, оно равно "
                + elements.size());
        driver.quit();
    }

    @Test
    public void parallel9() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uhomki.com.ua/ru/");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/div/div[1]/div/nav/span[3]/a")).click();
        System.out.println(driver.getTitle());
        assertEquals(driver.getTitle(), "Оплата и доставка - \"У Хомки\" Интернет-зоомагазин | Днепр, пр. А. Поля, 59. (остановка \"Медтехника\")",
                "Страница не открыта, я ожидал другого");
        driver.quit();
    }
    @Test
    public void parallel10() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ParallelClass2.url.homki);
        Thread.sleep(3000);
        driver.findElement(ParallelClass2.Locators.c).sendKeys("смесь"+"\n");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/form/div[1]"));
        Thread.sleep(3000);
        String str = driver.getPageSource();
        if (str.contains("смесь")==true){System.out.println("Слово “смесь” присутствует в сообщении о результатах поиска");}
        else {System.out.println("Слово “смесь” отсутствует в сообщении о результатах поиска");}
        Thread.sleep(3000);
        Actions action = new Actions(driver);
        Action dblclick = action.doubleClick(driver.findElement(ParallelClass2.Locators.c)).build();
        ((Action) dblclick).perform();
        Thread.sleep(1000);
        driver.findElement(ParallelClass2.Locators.c).sendKeys("спесь"+"\n");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/form/div[1]"));
        Thread.sleep(3000);
        String str1 = driver.getPageSource();
        if (str.contains("спесь")==true){System.out.println("Слово “спесь” присутствует в сообщении о результатах поиска");}
        else {System.out.println("Слово “спесь” отсутствует в сообщении о результатах поиска");}
        Actions action1 = new Actions(driver);
        Action dblclick1 = action1.doubleClick(driver.findElement(ParallelClass2.Locators.c)).build();
        ((Action) dblclick1).perform();
        Thread.sleep(1000);
        driver.findElement(ParallelClass2.Locators.c).sendKeys("ересь"+"\n");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/form/div[1]"));
        Thread.sleep(3000);
        String str2 = driver.getPageSource();
        if (str.contains("ересь")==true){System.out.println("Слово “ересь” присутствует в сообщении о результатах поиска");}
        else {System.out.println("Слово “ересь” отсутствует в сообщении о результатах поиска");}
        driver.quit();
    }
}
