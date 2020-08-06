package chapter3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import var.Variable;

public class Lesson3_1 {


    public static void main(String[] args) {
        // Create Driver object for Chrome Browser
        System.setProperty(Variable.CHROME, Variable.PATH_CHROME);
        WebDriver driver = new ChromeDriver();
        driver.get(Variable.YANDEX);
        System.out.println(driver.getTitle());
        driver.close();


    }
}
