package ex25;

import ex23.ex23_5;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class ex25 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/search");
        String descrt1 = driver.getWindowHandle();
        Set<String> set1 = driver.getWindowHandles();
        ((JavascriptExecutor) driver).executeScript("window.open()");
        Set<String> set2 = driver.getWindowHandles();
        set2.removeAll(set1);
        String descrt2 = set2.iterator().next();
        driver.switchTo().window(descrt2);
        driver.navigate().to("https://www.guinnessworldrecords.com/account/register?");
        String descrt3 = driver.getWindowHandle();
        Set<String> set3 = driver.getWindowHandles();
        ((JavascriptExecutor) driver).executeScript("window.open()");
        Set<String> set4 = driver.getWindowHandles();
        set4.removeAll(set3);
        String descrt4 = set4.iterator().next();
        driver.switchTo().window(descrt4);
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");
        String descrt5 = driver.getWindowHandle();
        Set<String> set5 = driver.getWindowHandles();
        ((JavascriptExecutor) driver).executeScript("window.open()");
        Set<String> set6 = driver.getWindowHandles();
        set6.removeAll(set5);
        String descrt6 = set6.iterator().next();
        driver.switchTo().window(descrt6);
        driver.navigate().to("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
        Thread.sleep(4000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//iframe[@id='iframeResult']")));
        driver.switchTo().frame(iframe);
        Thread.sleep(2000);
        driver.findElement(By.id("fname")).clear();
        driver.findElement(By.id("fname")).sendKeys("Artur");
        Thread.sleep(1000);
        driver.findElement(By.id("lname")).clear();
        driver.findElement(By.id("lname")).sendKeys("Bahian");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/form/input[3]")).click();
        Thread.sleep(2000);
        WebElement text = driver.findElement(By.xpath("/html/body/div[2]/p"));
        System.out.println(text.getText());


        driver.switchTo().window(descrt3);
        driver.findElement(By.id("LastName")).sendKeys("Bahian");
        driver.findElement(By.id("FirstName")).sendKeys("Artur");
        driver.findElement(By.id("DateOfBirthDay")).sendKeys("22");
        driver.findElement(By.id("DateOfBirthMonth")).sendKeys("02");
        driver.findElement(By.id("DateOfBirthYear")).sendKeys("1975");
        WebElement countrySelect = driver.findElement(By.id("Country"));
        Select country = new Select(countrySelect);
        Thread.sleep(2000);
        country.selectByVisibleText("Ukraine");
        Thread.sleep(1000);
        driver.findElement(By.id("State")).sendKeys("Kyiv");
        Thread.sleep(1000);
        driver.findElement(By.id("EmailAddress")).sendKeys("mailmail@mails.cim");
        Thread.sleep(1000);
        driver.findElement(By.id("ConfirmEmailAddress")).sendKeys("mailmail@mails.cim");
        Thread.sleep(1000);
        driver.findElement(By.id("Password")).sendKeys("22feb75");
        Thread.sleep(1000);
        driver.findElement(By.id("ConfirmPassword")).sendKeys("22feb76"+ "\n");

        System.out.println("'Confirm password' and 'Password' do not match.");
        Thread.sleep(1000);
        driver.switchTo().window(descrt5);
//        driver.findElement(By.id("alertBox")).click();
        WebElement alert1 = driver.findElement
                (By.id("alertBox"));
        WebElement alert2 = driver.findElement
                (By.id("confirmBox"));
        WebElement alert3 = driver.findElement
                (By.id("promptBox"));
        alert1.click();
        Alert alertfirst = driver.switchTo().alert();
        System.out.println(alertfirst.getText());
        alertfirst.accept();

        alert2.click();
        Alert alertSecond = driver.switchTo().alert();
        System.out.println(alertSecond.getText());
        Thread.sleep(2000);
        alertSecond.dismiss();

        //result
        alert3.click();
        Alert alertThird = driver.switchTo().alert();
        System.out.println(alertThird.getText());
        Thread.sleep(2000);







    }
}