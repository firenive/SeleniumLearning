package chapter4;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import var.Variable;

public class Lesson4_1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(Variable.FIREFOX, Variable.PATH_FIREFOX);
        WebDriver driver = new FirefoxDriver();
        driver.get(Variable.FACEBOOK);
       // driver.findElement(By.xpath("//input[@type='email']")).sendKeys("Now1111");
        driver.findElement(By.xpath("//input[@class='inputtext login_form_input_box']")).sendKeys("Now1111");


      //  driver.findElement(By.id("email")).sendKeys("Now");
        driver.findElement(By.name("pass")).sendKeys("123456");
        Thread.sleep(3000);
        try {
            driver.findElement(By.linkText("Забыли аккаунт?")).click();
        } catch (NoSuchElementException e) {
            driver.findElement(By.linkText("Forgotten account?")).click();
        }
        Thread.sleep(5000);
        driver.quit();
    }
}

