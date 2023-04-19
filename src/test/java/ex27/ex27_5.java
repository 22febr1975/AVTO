package ex27;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/*
Открыть сайт http://only-testing-blog.blogspot.com/2014/01/textbox.html?. Написать тест, проверяющий содержит ли модальное окно,
 которое появляется после нажатия на кнопку “Show Me Alert”необходимый текст.
*/
public class ex27_5 {
    private static class url{
        private static final String test = "http://only-testing-blog.blogspot.com/2014/01/textbox.html?";
    }
    private static class Locators {
        private static final By c = By.xpath("//*[@id=\"post-body-4292417847084983089\"]/div[1]/input");


    }
    @Test
    public void haveString() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ex27_5.url.test);
        Thread.sleep(3000);
        WebElement alert1 = driver.findElement(ex27_5.Locators.c);
        alert1.click();
        Thread.sleep(3000);
        Alert alertfirst = driver.switchTo().alert();
       System.out.println(alertfirst.getText());

        assertTrue(alertfirst.getText().equals("Hi.. This is alert message!"), "Текст совпадает");
//       assertEquals(alertfirst.getText(), "Hi.. This is alert message!", "Названия страниц не совпадают");
        alertfirst.accept();
        Thread.sleep(3000);

        driver.quit();
    }
}

