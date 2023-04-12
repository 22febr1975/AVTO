import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class ClassA {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://zoo.kiev.ua");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div[1]/div[2]/div[1]/center/a[1]/b"));
WebElement a = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div[1]/div[2]/div[1]/center/a[1]/b"));
        System.out.println(a);
        System.out.println(a.getCssValue("background"));
        System.out.println(a.getCssValue("color"));
    }
}