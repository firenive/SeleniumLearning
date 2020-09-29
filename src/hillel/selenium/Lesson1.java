package hillel.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import var.Variable;

public class Lesson1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(Variable.CHROME, Variable.PATH_CHROME);
        WebDriver driver = new ChromeDriver();
        driver.get(Variable.EBOOKS);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.id("q")).sendKeys("Automation");
        driver.findElement(By.id("q")).sendKeys(Keys.RETURN);

        Thread.sleep(5000);
        driver.quit();
    }
}
