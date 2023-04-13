package ex22;
//Найти путь к данному элементу
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ex22_4 {
    private static class url{
        private static final String uhomki = "https://uhomki.com.ua";
    }
    private static class Locators {
        private static final By a = By.partialLinkText("Кошки");
    }
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url.uhomki);
        driver.findElement(Locators.a).click();
    }
}