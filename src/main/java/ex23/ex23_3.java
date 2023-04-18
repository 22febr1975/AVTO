package ex23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/*3)
        Написать метод который выводит сообщение об айди элемента,
        значении тэга элемента , значении класса элемента,
        значении атрибута name элемента, текста данного элемента,
        а также о координатах центра контейнера данного элемента.
        Создать свой тип исключений, который будет вызываться если у элемента
        нет определенного атрибута и на экран будет выводиться сообщение об отсутствии данного атрибута.*/
public class ex23_3 {
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
        WebElement input = driver.findElement(By.cssSelector(".search__input"));
        String a1 = input.getAttribute("id");
        if (a1 ==""){throw new ex23_3_1();
        }else {System.out.println(a1);}
        String a2 = input.getTagName();
        if (a2==""){throw new ex23_3_1();
        }else {System.out.println(input.getTagName());}
        String a3 = input.getText();
        if (a3 == ""){throw new ex23_3_1();
        }else {System.out.println(input.getText());}
        String a4 = input.getAttribute("class");
        if (a4==""){throw new ex23_3_1();
        }else {System.out.println(input.getAttribute("class"));}
        String a5 = input.getAttribute("name");
        if (a5==""){throw new ex23_3_1();
        }else {System.out.println(input.getAttribute("name"));}
        String a6 = input.getAttribute("placeholder");
        if (a6==""){throw new ex23_3_1();
        }else {System.out.println(input.getAttribute("placeholder"));}
        System.out.println("Центер контейнера координата x " + input.getLocation().x / 2);
        System.out.println("Центер контейнера координата y " + input.getLocation().y / 2);

    }
    }