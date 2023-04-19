package ex27;

import ex26.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.testng.Assert.assertFalse;

/*
Открыть сайт https://www.guinnessworldrecords.com/Account/Login. Написать тест, проверяющий что изначально чек-бокс
“RememberMe” не выбран. Потом кликнуть на него и реализовать проверку того, что он выбран. После снова нажать на чек-бокс
        и проверить что он снова не выбран.
*/
public class ex27_4 {

               @Test
        public void checkofCheckBox(){
            System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.guinnessworldrecords.com/Account/Login");

            WebElement checkbox = (new Waiters(driver)
                    .waitForPresenceOfElementLocated(By.id("RememberMe")));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(102,465)");
            assertFalse(checkbox.isSelected(),"Чекбокс уже нажат");
            checkbox.click();
            WebElement newCheckBox = (new Waiters(driver)
                    .waitForPresenceOfElementLocated(By.id("RememberMe")));
            (new Waiters(driver)).waitForVisabilityOfElement(driver.findElement(By.id("RememberMe")));
            assertTrue(newCheckBox.isSelected(),"Чекбокс уже нажат");
            checkbox.click();
            assertFalse(checkbox.isSelected(), "Чекбокс уже нажат");
            driver.quit();
        }

}
