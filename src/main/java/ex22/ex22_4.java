package ex22;
//Найти путь к данному элементу
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ex22_4 {
    private static class url{
        private static final String uhomki = "https://uhomki.com.ua";
    }
    private static class Locators {
        private static final By a = By.xpath("/html/body/div[2]/div[2]/div/div[3]/div/div/div/div/div/ul/li[8]/div[2]/ul/li[2]/a/span");
        private static final By b = By.xpath("/html/body/div[2]/div[2]/div/div[3]/div/div/div/div/div/ul/li[8]/div[1]/a");    }
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url.uhomki);

        /*int startX = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[3]/div/div/div/div/div/ul/li[8]/div[1]/a"))
                .getLocation().x;
        System.out.println(startX);
        int startY = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[3]/div/div/div/div/div/ul/li[8]/div[1]/a"))
                .getLocation().y;
        System.out.println(startY);*/
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.moveByOffset(774,184).pause(5).release().build().perform();
        Thread.sleep(2000);
        driver.findElement(Locators.a).click();
    }
}