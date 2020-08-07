package chapter4;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import var.Variable;

public class Lesson46_regularExpression {
    /* при создании Xpath необходимо закладывать вариант, который предполагает, что используемый атрибут может изменится
     например Xpath вида //input[@id='username']. В результате изменений на сайте id элемента может изменится на
     id = username13. Для того чтобы не менять Xpath имеет смысл использовать регулярные выражения следующего формата:
       //tagName[contains(@attribute, 'value')] Пример: //input[contains(@name, 'username')]
       Для CSS также используются регулярные выражения в формате: tagName[attribute *=' value'] Пример:
       input[name *= 'username'] */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(Variable.FIREFOX, Variable.PATH_FIREFOX);
        WebDriver driver = new FirefoxDriver();
        driver.get(Variable.REDIFF);
        // <a href="https://mail.rediff.com/cgi-bin/login.cgi" title="Already a user? Sign in" class="signin">Sign in</a>

        try {
            driver.findElement(By.cssSelector("a[title*='Sign in']")).click();
            // в качестве regular expression используем title. Но не все что содержится в тэге, а только проверяем на наличием
            // символов 'Sign in'
            driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("123456");
            driver.findElement(By.cssSelector("input#password")).sendKeys("123456");
            Thread.sleep(3000);
            // <input type="submit" name="proceed" value="Sign in" title="Sign in" tabindex="4" class="signinbtn">
            driver.findElement(By.xpath("//input[contains(@name, 'proc')]")).click();

        }catch (NoSuchElementException e) {

            e.printStackTrace();
        } finally {
            Thread.sleep(5000);
            driver.quit();
        }
    }
}
