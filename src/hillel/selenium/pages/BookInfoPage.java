package hillel.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookInfoPage {
    @FindBy (tagName = "h1")
    public WebElement titleBook;
}
