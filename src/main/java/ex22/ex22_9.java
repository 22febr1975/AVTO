package ex22;
//Найти данный элемент не используя текст. Используя только имя класса.
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ex22_9 {
    private static class url{
        private static final String idea = "https://www.jetbrains.com/idea/";
    }
    private static class Locators {
        private static final By a = By.xpath("//a[@class = \"wt-col-inline menu-second__download-button wt-button wt-button_size_s wt-button_mode_primary\"]");
    }
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url.idea);
        driver.findElement(Locators.a).click();
    }
}