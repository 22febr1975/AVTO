package ex22;
/*Отыскать один элемент на основе другого.
        Для нахождения первого элемента можете использовать любые методы и локаторы,
        для прописывания дальнейшего поиска второго элемента не использовать текст.*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ex22_8 {
    public static class url{
        private static final String danIt = "https://dan-it.com.ua/uk/";
    }
    private static class Locators {
        private static final By a = By.xpath("/html/body/main/div[1]/div/a[1]");
        private static final By b = By.xpath("/html/body/header/div/nav/ul/li[7]/a");
        private static final By c = By.tagName("input");
//        Локатор второго элемента из рисунка к этому заданию
        private static final By d = By.xpath("/html/body/main/section[2]/div/div[1]/ul/li[3]");
    }
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url.danIt);
//        driver.findElement(Locators.a).click();
        driver.findElement(Locators.b).click();
        driver.findElements(Locators.c).get(7).sendKeys("Bahian");
            }
}
