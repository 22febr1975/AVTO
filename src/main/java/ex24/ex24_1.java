package ex24;
/*1) http://only-testing-blog.blogspot.com/2014/01/textbox.html?
        Написать программу реализующую действие показанное на "видео1.mp4".
        После выполнения программы на консоли должна выводится информация в следующем виде:

        Автомобили доступные для выбора:
        Volvo, BMW, Opel, Audi, Toyota, Renault, Maruti Car.
        Страны из первой таблицы:
        USA, Russia, Japan, Mexico, India, Malaysia, Greece.
        Страны из второй таблицы:
        France, Germany, Italy, Spain.*/
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
public class ex24_1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" http://only-testing-blog.blogspot.com/2014/01/textbox.html?");
        WebElement avtoSelect = driver.findElement(By.id("Carlist"));
        Select avto = new Select(avtoSelect);
        Thread.sleep(2000);
        avto.selectByVisibleText("Renault");
        Thread.sleep(1000);
        Select country = new Select(driver.findElement(By.name("FromLB")));
        Select country1 = new Select(driver.findElement(By.name("ToLB")));
        country.selectByVisibleText("France");
        Thread.sleep(1000);
        country.selectByVisibleText("India");
        Thread.sleep(1000);
        country.deselectByVisibleText("India");
        Thread.sleep(1000);
        country.selectByVisibleText("Germany");
        Thread.sleep(1000);
        country.selectByVisibleText("Italy");
        Thread.sleep(1000);
        country.selectByVisibleText("Malaysia");
        Thread.sleep(1000);
        country.deselectByVisibleText("Malaysia");
        Thread.sleep(1000);
        country.selectByVisibleText("Spain");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"post-body-4292417847084983089\"]/div[1]/form[2]/table/tbody/tr/td[2]/input[1]")).click();
        Thread.sleep(1000);
        System.out.println("Автомобили доступные для выбора:");
        List<WebElement> elements = avto.getOptions();
        for (WebElement element : elements) {
            System.out.print(element.getText());
            System.out.print(", ");
        }
        System.out.println("\nСтраны из первой таблицы:");
        List<WebElement> elements1 = country.getOptions();
        for (WebElement element1 : elements1) {
            System.out.print(element1.getText());
            System.out.print(", ");
        }
        System.out.println("\nСтраны из второй таблицы:");
        List<WebElement> elements2 = country1.getOptions();
        for (WebElement element2 : elements2) {
            System.out.print(element2.getText());
            System.out.print(", ");
        }
    }
}