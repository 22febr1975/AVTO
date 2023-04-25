package ex28.ex28_1;
/*Создать отдельный пакет priority. В нем класс Priority1. В этом классе создать тесты a, b, c, d, e , f, g такого плана:

        Сделать так, чтобы при запуске данного класса эти тесты проходили в порядке обратном алфавитному. Придумать по
        крайней мере два способа, как это можно сделать.*/
/*
Второй способ:
@Test (priority = 1)
*/

import ex26.Waiters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.Keys.CONTROL;
import static org.testng.Assert.*;

public class priority1 {
    private static class url{
        private static final String homki = "https://uhomki.com.ua/ru/";
    }
    private static class Locators {
        private static final By c = By.cssSelector(".search__input");


    }
    @Test
    public void ga() {
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
    public void fb() {
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
    public void ec() {
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
    public void dd() {
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
    public void ce() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(priority1.url.homki);
        Thread.sleep(3000);
        driver.findElement(priority1.Locators.c).sendKeys("смесь"+"\n");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/form/div[1]"));
        Thread.sleep(3000);
        String str = driver.getPageSource();
        if (str.contains("смесь")==true){System.out.println("Слово “смесь” присутствует в сообщении о результатах поиска");}
        else {System.out.println("Слово “смесь” отсутствует в сообщении о результатах поиска");}
        Thread.sleep(3000);
        Actions action = new Actions(driver);
        Action dblclick = action.doubleClick(driver.findElement(priority1.Locators.c)).build();
        ((Action) dblclick).perform();
        Thread.sleep(1000);
        driver.findElement(priority1.Locators.c).sendKeys("спесь"+"\n");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/form/div[1]"));
        Thread.sleep(3000);
        String str1 = driver.getPageSource();
        if (str.contains("спесь")==true){System.out.println("Слово “спесь” присутствует в сообщении о результатах поиска");}
        else {System.out.println("Слово “спесь” отсутствует в сообщении о результатах поиска");}
        Actions action1 = new Actions(driver);
        Action dblclick1 = action1.doubleClick(driver.findElement(priority1.Locators.c)).build();
        ((Action) dblclick1).perform();
        Thread.sleep(1000);
        driver.findElement(priority1.Locators.c).sendKeys("ересь"+"\n");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/form/div[1]"));
        Thread.sleep(3000);
        String str2 = driver.getPageSource();
        if (str.contains("ересь")==true){System.out.println("Слово “ересь” присутствует в сообщении о результатах поиска");}
        else {System.out.println("Слово “ересь” отсутствует в сообщении о результатах поиска");}
        driver.quit();
    }
    @Test
    public void bf() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dan-it.com.ua/uk/");
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
        a = a + 1;
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(driver.findElement(By.xpath("//a[text()='Для дорослих']"))).perform();
        (new Waiters(driver)).waitForVisabilityOfElement(driver.findElement
                (By.xpath
                        ("/html/body/header/div/nav/ul/li[2]/ul/li[6]/a")));
        WebElement java = driver.findElement
                (By.xpath
                        ("/html/body/header/div/nav/ul/li[2]/ul/li[6]/a"));
        actions1.keyDown(CONTROL).click(java).keyUp(CONTROL).build().perform();
        a = a + 1;
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(driver.findElement(By.xpath("//a[text()='Для дорослих']"))).perform();
        (new Waiters(driver)).waitForVisabilityOfElement(driver.findElement
                (By.xpath
                        ("/html/body/header/div/nav/ul/li[2]/ul/li[8]/a")));
        WebElement qualityAssurance = driver.findElement
                (By.xpath
                        ("/html/body/header/div/nav/ul/li[2]/ul/li[8]/a"));
        actions2.keyDown(CONTROL).click(qualityAssurance).keyUp(CONTROL).build().perform();
        a = a + 1;
        if (a == 4) {
            System.out.println("Тест пройден.");
        } else {
            System.out.println("Тест не пройден.");
        }

        driver.quit();
    }

    @Test
    public void ag() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.guinnessworldrecords.com/Account/Login");

        WebElement checkbox = (new Waiters(driver)
                .waitForPresenceOfElementLocated(By.id("RememberMe")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(102,465)");
        assertFalse(checkbox.isSelected(), "Чекбокс уже нажат");
        checkbox.click();
        WebElement newCheckBox = (new Waiters(driver)
                .waitForPresenceOfElementLocated(By.id("RememberMe")));
        (new Waiters(driver)).waitForVisabilityOfElement(driver.findElement(By.id("RememberMe")));
        assertTrue(newCheckBox.isSelected(), "Чекбокс уже нажат");
        checkbox.click();
        assertFalse(checkbox.isSelected(), "Чекбокс уже нажат");
        driver.quit();
    }

}
