package chapter4;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import var.Variable;

public class Lesson45_CSS_Xpath {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(Variable.FIREFOX, Variable.PATH_FIREFOX);
        WebDriver driver = new FirefoxDriver();
        driver.get(Variable.FACEBOOK);
        try {
            driver.findElement(By.xpath("//*[@name = 'email']")).sendKeys("12346");

            driver.findElement(By.cssSelector("input[id='pass']")).sendKeys("12345678"); // or
            driver.findElement(By.cssSelector("input#pass")).sendKeys("12345678");

            driver.findElement(By.xpath("//input[@value='Вход']")).click();
        }catch (NoSuchElementException e) {
            driver.findElement(By.xpath("//input[@value='Log In']")).click();
            e.printStackTrace();
        } finally {
            Thread.sleep(5000);
            driver.quit();
        }
    }
}
