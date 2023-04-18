package ex24;
/*
2) http://www.ashortjourney.com/
        Написать программу, которая будет автоматизировать сценарий показанный на видео "Сценарий для автоматизии.mp4".
*/
import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class ex24_2 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("http://www.ashortjourney.com/");
        Thread.sleep(4000);
       /* WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.partialLinkText("CREDITS")));*/

        int startX = driver.findElement(By.id("ui-credits"))
                .getLocation().x;
        System.out.println(startX);
        int startY = driver.findElement(By.id("ui-credits"))
                .getLocation().y;
        System.out.println(startY);
        int finishX = driver.findElement(By.id("ui-credits"))
                .getLocation().x+144;
        System.out.println(finishX);
        int finishY = driver.findElement(By.id("ui-credits"))
                .getLocation().y-418;
        System.out.println(finishY);
        Actions actions = new Actions(driver);
       WebElement drag = driver.findElement(By.id("ui-credits"));
        actions.moveByOffset(finishX,finishY).clickAndHold().pause(5)
                .moveToElement(drag,70,306).release().build().perform();
    }
}