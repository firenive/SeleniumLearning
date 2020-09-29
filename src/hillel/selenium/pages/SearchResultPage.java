package hillel.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage {
    WebDriver driver;
    WebDriverWait wait;
    public  SearchResultPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
    public void waitForSearchResult() {

    }
    public void openBookFromResult(String titleBook) { // прокодимся по таблице с наименованиями книг и выбираем ту,
        // которую передаем в качестве параметра
        List<WebElement> books = driver.findElement(By.className("gsc-expansionArea")).findElements(By.cssSelector("div[class='gs-title']"));
        for (WebElement book:books) {
            WebElement bookLink = book.findElement(By.tagName("a"));
            if (bookLink.getText().contains(titleBook)) {
                book.click();
                break;
            }
        }

    }
    public void switchTabs() { // Переключение между вкладками
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
}

