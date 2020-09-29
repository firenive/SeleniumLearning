package hillel.selenium;

import hillel.selenium.pages.BooksSite;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import var.Variable;

public class Lesson2 {

    WebDriver driver;
    MainPage mainPage;
    BooksSite website;
    WebDriverWait wait;

    /* выполняет поиск элемента. пока элемент не будет найден - ждет.. Конструктор принимает сам драйвер, количество
         секунд ожидания, интервал между проверками в миллисекундах*/

    @Before
    public void setUp() {
        System.setProperty(Variable.CHROME, Variable.PATH_CHROME);
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        website = new BooksSite(driver);
         wait = new WebDriverWait(driver, 10, 500);
        driver.get(Variable.EBOOKS);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        mainPage.setSearchBox("Automation");
        mainPage.goSearch();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("gsc-expansionArea")));
    }

    @After
    public void tearDown() {
        if (driver != null) // Условие на тот случай если во время теста браузер крашится
        driver.quit();
    }

    @Test
    public void firstCase() {
        int element = driver.findElement(By.className("gsc-expansionArea")).findElements(By.cssSelector("div[class='gs-title']")).size();
        Assert.assertTrue(element == 10);

    }

    @Test
    public void secondCase() {
        Assert.assertTrue(driver.getCurrentUrl().contains("Automation"));

    }
    @Test
    public void openBookInfoFromSearch() {
        String title = "Python Automation Cookbook";
        System.out.println("Open book info");
        website.searchResultPage().openBookFromResult(title);
        website.searchResultPage().switchTabs();
        wait.until(ExpectedConditions.urlContains("store"));
        Assert.assertTrue(driver.getTitle().contains(title));
    }

}
