package hillel.selenium.pages;

import hillel.selenium.MainPage;
import org.openqa.selenium.WebDriver;

public class BooksSite {
    WebDriver driver;
    public BooksSite(WebDriver driver) {
        this.driver = driver;
    }
    public MainPage mainPage() {
        return new MainPage(driver);
    }
    public SearchResultPage searchResultPage() {
        return new SearchResultPage(driver);
    }
    public BookInfoPage bookInfoPage() {
        return new BookInfoPage();
    }
}
