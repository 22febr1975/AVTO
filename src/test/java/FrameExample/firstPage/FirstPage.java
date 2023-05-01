package FrameExample.firstPage;

import ex26.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FirstPage {
    //    проверка поиска
    @Test
    public void haveStrings() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pampik.com/ua");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='search-form__input']")).sendKeys("каші" + "\n");
        driver.findElement(By.xpath("//*[@id='search-form']/div[1]/button")).click();
        Thread.sleep(2000);
        String str = driver.getPageSource();
        if (str.contains("каші") == true) {
            System.out.println("Слово “каші” присутствует в сообщении о результатах поиска");
        } else {
            System.out.println("Слово “каші” отсутствует в сообщении о результатах поиска");
        }
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        Action dblclick = action.doubleClick(driver.findElement(By.xpath("//*[@id='search-form__input']"))).build();
        ((Action) dblclick).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='search-form__input']")).sendKeys("маша" + "\n");
        driver.findElement(By.xpath("//*[@id='search-form']/div[1]/button")).click();
        Thread.sleep(3000);
        String str1 = driver.getPageSource();
        if (str.contains("спесь") == true) {
            System.out.println("Слово “маша” присутствует в сообщении о результатах поиска");
        } else {
            System.out.println("Слово “маша” отсутствует в сообщении о результатах поиска");
        }
        Actions action1 = new Actions(driver);
        Action dblclick1 = action1.doubleClick(driver.findElement(By.xpath("//*[@id='search-form__input']"))).build();
        ((Action) dblclick1).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='search-form__input']")).sendKeys("анальгин" + "\n");
        driver.findElement(By.xpath("//*[@id='search-form']/div[1]/button")).click();
        Thread.sleep(3000);
        String str2 = driver.getPageSource();
        if (str.contains("анальгин") == true) {
            System.out.println("Слово “анальгин” присутствует в сообщении о результатах поиска");
        } else {
            System.out.println("Слово “анальгин” отсутствует в сообщении о результатах поиска");
        }
        driver.quit();
    }

    // проверка на открытие страницы
    @Test
    public void openWebPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pampik.com/ua");
        driver.findElement(By.xpath("//*[@id=\"category-menu\"]/ul/li[1]/a/span[2]")).click();
        System.out.println(driver.getTitle());
        assertEquals(driver.getTitle(), "Пiдгузки та товари для сповивання ᐉ PAMPIK | Купити з доставкою додому",
                "Страница не открыта, я ожидал другого");
        driver.findElement(By.xpath("//*[@id=\"category-menu\"]/ul/li[4]/a/span[2]")).click();
        System.out.println(driver.getTitle());
        assertEquals(driver.getTitle(), "Догляд, купання і гігієна | | Интернет магазин детских товаров в Украине. Купить товары для детей с доставкой - Pampik.",
                "Страница не открыта, я ожидал другого");
        driver.findElement(By.xpath(" //*[@id=\"category-menu\"]/ul/li[8]/a/span[2]")).click();
        System.out.println(driver.getTitle());
        assertEquals(driver.getTitle(), "Побутова хімія та товари для догляду за домом - купити з доставкою додому в Києві та по Україні - Pampik",
                "Страница не открыта, я ожидал другого");
        driver.quit();
    }

    // проверка выбора локации
    @Test
    public void chengeLocations() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pampik.com/ua");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"current-city\"]/a")).click();
        Thread.sleep(5000);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("popup-city-autocomplete"))).sendKeys("Крюківщина" + "\n").perform();
        Thread.sleep(2000);
    /*(new Waiters(driver)).waitForVisabilityOfElement(driver.findElement(By.linkText("Крюківщина (Київська обл.)(Києво-Святошинський р-н.)")));
    WebElement city = driver.findElement(By.id("ui-id-17"));
    actions.click(city).build().perform();*/
        driver.quit();
    }
//  проверка входа в кабинет
    @Test
    public void entranceToOffise() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pampik.com/ua");
        driver.findElement(By.xpath("//*[@id=\"personal-profile-link\"]/span[2]")).click();
        System.out.println(driver.getTitle());
        assertEquals(driver.getTitle(), "Вхід до особистого кабінету pampik.com",
                "Страница не открыта, я ожидал другого");
        driver.findElement(By.xpath("//*[@id=\"login\"]/div[1]/input")).sendKeys("123456789" + "\n");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"login\"]/div[2]/input")).sendKeys("123456789" + "\n");
        Thread.sleep(2000);
        driver.quit();
    }
// проверка горячих кнопок нижней части сайта
    @Test
    public void logistPay() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pampik.com/ua");
        driver.findElement(By.xpath("//*[@id=\"footer\"]/div[2]/div/div[1]/div/div[2]/ul/li[1]/a")).click();
        System.out.println(driver.getTitle());
      assertEquals(driver.getTitle(), "Акції та знижки| Pampik.",
                "Страница не открыта, я ожидал другого");
        driver.quit();
    }
}
