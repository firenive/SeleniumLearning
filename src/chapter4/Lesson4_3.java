package chapter4;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import var.Variable;

public class Lesson4_3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(Variable.FIREFOX, Variable.PATH_FIREFOX);
        WebDriver driver = new FirefoxDriver();
        driver.get(Variable.SALESFORCE);
        try {
            driver.findElement(By.className("input r4 wide mb16 mt8 username")).sendKeys("qqq");
        } catch (NoSuchElementException e){
           //  e.printStackTrace();
           // driver.findElement(By.id("username")).sendKeys("qqq");
            driver.findElement(By.cssSelector("#username")).sendKeys("234");
            driver.findElement(By.name("pw")).sendKeys("123456");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@id='Login']")).click();

        } finally {
            Thread.sleep(5000);
            driver.quit();
        }


    }
}
//*[@id="Login"]
