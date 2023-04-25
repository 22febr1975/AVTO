package ex28.ex28_2.grouping;
/*Создать отдельный пакет grouping. В нем класс Groups. В этом классе создать тесты one, two, three, four, five, six, seven,
        eight такого плана:

        Сделать так, чтобы тесты, которые называются нечетными числами принадлежали группе first, а тесты четных чисел
        принадлежали группе second.
        Создать отдельный xml файл testngGroupingHome.xml в котором последовательно прогонялись вначале файлы группы first,
        а после файлы группы second.
        P.S. В каждой группе тесты должны проходить в порядке возрастания.*/

import ex26.Waiters;
import ex27.ex27_1;
import ex27.ex27_5;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.Keys.CONTROL;
import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

public class Groups {
    @Test(groups = {"first"}, priority = 1)
    public void one() {
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

    @Test(groups = {"second"}, priority = 1)
    public void two() {
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

    @Test(groups = {"first"}, priority = 2)
    public void bthree() {
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

    @Test(groups = {"second"}, priority = 2)
    public void four() {
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

    @Test(groups = {"first"}, priority = 3)
    public void cfive() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uhomki.com.ua/ru/");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".search__input")).sendKeys("смесь" + "\n");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/form/div[1]"));
        Thread.sleep(3000);
        String str = driver.getPageSource();
        if (str.contains("смесь") == true) {
            System.out.println("Слово “смесь” присутствует в сообщении о результатах поиска");
        } else {
            System.out.println("Слово “смесь” отсутствует в сообщении о результатах поиска");
        }
        Thread.sleep(3000);
        Actions action = new Actions(driver);
        Action dblclick = action.doubleClick(driver.findElement(By.cssSelector(".search__input"))).build();
        ((Action) dblclick).perform();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".search__input")).sendKeys("спесь" + "\n");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/form/div[1]"));
        Thread.sleep(3000);
        String str1 = driver.getPageSource();
        if (str.contains("спесь") == true) {
            System.out.println("Слово “спесь” присутствует в сообщении о результатах поиска");
        } else {
            System.out.println("Слово “спесь” отсутствует в сообщении о результатах поиска");
        }
        Actions action1 = new Actions(driver);
        Action dblclick1 = action1.doubleClick(driver.findElement(By.cssSelector(".search__input"))).build();
        ((Action) dblclick1).perform();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".search__input")).sendKeys("ересь" + "\n");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/form/div[1]"));
        Thread.sleep(3000);
        String str2 = driver.getPageSource();
        if (str.contains("ересь") == true) {
            System.out.println("Слово “ересь” присутствует в сообщении о результатах поиска");
        } else {
            System.out.println("Слово “ересь” отсутствует в сообщении о результатах поиска");
        }
        driver.quit();
    }

    @Test(groups = {"second"}, priority = 3)
    public void six() throws InterruptedException {
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

    @Test(groups = {"first"}, priority = 4)
    public void dseven() {
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

    @Test(groups = {"second"}, priority = 4)
    public void eight() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html?");
        Thread.sleep(3000);
        WebElement alert1 = driver.findElement(By.xpath("//*[@id=\"post-body-4292417847084983089\"]/div[1]/input"));
        alert1.click();
        Thread.sleep(3000);
        Alert alertfirst = driver.switchTo().alert();
        System.out.println(alertfirst.getText());

        assertTrue(alertfirst.getText().equals("Hi.. This is alert message!"), "Текст совпадает");
        alertfirst.accept();
        Thread.sleep(3000);

        driver.quit();
    }
}