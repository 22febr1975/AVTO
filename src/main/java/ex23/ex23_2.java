package ex23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/*
2)
        Написать метод в параметры которого принимаются два ВебЭлемента.
        метод выводит в консоль информацию какой из двух элементов располагается  выше на странице,
        какой из элементов располагается левее на странице,
        а также какой из элементов занимает большую площадь.
        Параметры метода могут также включать в себя другие аргументы, если это необходимо.
*/
public class ex23_2 {
    public static void main(String[] args) throws InterruptedException, ex23_3_1 {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://uhomki.com.ua/ru/");
        WebElement dog = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[3]/div/div/div/div/div/ul/li[1]/div[1]/a"));
        WebElement hitSale = driver.findElement(By.xpath("//*[@id='special_offers_40cd750bba9870f18aada2478b24840a']/div/div/div/nav/ul/li/span"));
        System.out.println("Координаты первого элемента - " + dog.getText() + dog.getLocation());
        System.out.println("Координаты второго элемента - " + hitSale.getText() + hitSale.getLocation());
        if (dog.getLocation().x>hitSale.getLocation().x){System.out.println("Второй элемент находится левее первого");
        }else {System.out.println("Первый элемент находится левее второго");}
        if (dog.getLocation().y>hitSale.getLocation().y){System.out.println("Второй элемент находится выше первого");
        }else {System.out.println("Первый элемент находится выше второго");}
        if (dog.getLocation().x*dog.getLocation().y>hitSale.getLocation().x*hitSale.getLocation().y){System.out.println("Первый элемент занимает большую площадь чем второй");
        }else {System.out.println("Второй элемент занимает большую площадь чем первый");}
    }
}