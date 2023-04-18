import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class ClassA {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://ktokuda.net/");
        driver.findElement(By.xpath("//div[@class='hike_tour no_active']")).click();
        WebElement c1= driver.findElement(By.id("country_list"));
        Select country=new Select(c1);
        Select countries = new Select (c1);

    }
}