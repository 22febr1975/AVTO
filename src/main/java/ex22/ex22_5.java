package ex22;
//Найти путь к данному элементу
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ex22_5 {
    private static class url{
        private static final String danIt = "https://dan-it.com.ua/uk/";
    }
    private static class Locators {
        private static final By a = By.xpath("/html/body/header/div/a[2]");
    }
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url.danIt);
        Thread.sleep(5000);
        driver.findElement(Locators.a).click();
    }
}
