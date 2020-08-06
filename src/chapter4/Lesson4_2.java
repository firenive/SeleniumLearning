package chapter4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import var.Variable;

public class Lesson4_2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(Variable.FIREFOX, Variable.PATH_FIREFOX);
        WebDriver driver = new FirefoxDriver();
        driver.get(Variable.VK);
        driver.findElement(By.id("index_email")).sendKeys("maks-ynikov@mail.ru");
        driver.findElement(By.id("index_pass")).sendKeys("23568491firenive");
        Thread.sleep(1000);
        driver.findElement(By.id("index_login_button")).click();

        Thread.sleep(5000);
        driver.findElement(By.id("top_profile_link")).click();
        driver.findElement(By.id("top_logout_link")).click();
        Thread.sleep(5000);
         driver.close();
    }
}
