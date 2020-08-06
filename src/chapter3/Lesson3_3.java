package chapter3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import var.Variable;

public class Lesson3_3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(Variable.FIREFOX, Variable.PATH_FIREFOX);
        WebDriver driver = new FirefoxDriver();
        driver.get(Variable.YANDEX);
        System.out.println(driver.getCurrentUrl());
        if(driver.getCurrentUrl().equals(Variable.YANDEX)) System.out.println("Url correct");
        // driver.getPageSource(); // source code page
        driver.get("https://pikabu.ru");
        driver.navigate().back(); // back to previous page (yandex)
        Thread.sleep(5000);
        driver.close(); // it closes current browser
        // driver.quit(); // it closes all the browsers opened by selenium script
    }
}
