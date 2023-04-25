package ex28.ex28_5;
/*    Решить предыдущую задачи используя аннотацию @Parameters. А также создать для работы с данным тестом дополнительный
    xml файл testngParametersHome.xml.*/
import ex26.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
public class ex28_5 {
    @Test
    @Parameters({"input"})
    public void checkSearc(String text) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.foxtrot.com.ua/");
        Waiters waiters = new Waiters(driver);
        WebElement search = waiters.waitForVisabilityOfElementReturn(By.xpath("//*[@id=\"js-fix-header\"]/div/div/div[2]/input[1]"));
        search.sendKeys(text);
        WebElement button = waiters.waitForVisabilityOfElementReturn(By.xpath("//*[@id=\"js-fix-header\"]/div/div/div[2]/input[2]"));
        button.click();
        waiters.waitForTitleContains("Знайдено по запиту");
        if((driver.findElement(By.tagName("h1")).getText()).contains("Результати пошуку")){
            waiters.waitForVisabilityOfElement(By.xpath("//div[@class='search-page__box-title']/label"));
            assertEquals((driver.findElement(By.xpath("//div[@class='search-page__box-title']/label")).getText()),"«"+text+"»",
                    "Actual result = "+ (driver.findElement(By.xpath("//div[@class='search-page__box-title']/label")).getText())+
                            " Expected "+ text);
        }else {
            waiters.waitForVisabilityOfElement(By.tagName("h1"));
            String result = driver.findElement(By.tagName("h1")).getText().replace("Знайдено по запиту ","");
            assertEquals(result,"«"+text+"»",
                    "Actual result = "+ (driver.findElement(By.tagName("h1")).getText())+
                            " Expected "+text);
        }
        driver.quit();
    }
}
