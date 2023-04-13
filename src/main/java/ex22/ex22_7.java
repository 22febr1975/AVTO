package ex22;
/*найти 10 элементов на странице, для нахождения которых можно использовать
        только айди и с которыми можно взаимодействовать. (Кликнуть, ввести текст и т.д.)*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ex22_7 {
    private static class url{
        private static final String school = "https://www.w3schools.com/";
    }
    private static class Locators {
        private static final By a = By.id("proFromDefault");
        private static final By b = By.id("signupbtn_topnav");
        private static final By c = By.id("myLearningFromDefault");
        private static final By d = By.id("nav_search_btn");
        private static final By e = By.id("nav_translate_btn");
        private static final By f = By.id("navbtn_references");
        private static final By g = By.id("navbtn_tutorials");
        private static final By h = By.id("navbtn_exercises");
        private static final By l = By.id("navbtn_menu");
        private static final By w = By.id("cert_navbtn");
    }
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url.school);
//        driver.findElement(Locators.a).click();
//        driver.findElement(Locators.b).click();
//        driver.findElement(Locators.c).click();
//        driver.findElement(Locators.d).click();
//        driver.findElement(Locators.e).click();
//        driver.findElement(Locators.f).click();
//        driver.findElement(Locators.g).click();
//        driver.findElement(Locators.h).click();
//        driver.findElement(Locators.l).click();
        driver.findElement(Locators.w).click();

    }
}
