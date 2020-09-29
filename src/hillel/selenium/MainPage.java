package hillel.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // с помощью аннотации FindBy указываем сначала селектор, отражающий элемент. Затем инициализируем переменную WebElement
    @FindBy (css = "input[value='Search']")
    private WebElement searchBtn;

    @FindBy(id = "q")
    private WebElement searchBox;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }
    public void goSearch() {
        searchBtn.click();
    }
    public void setSearchBox(String ask) {
        searchBox.clear();
        searchBox.sendKeys(ask);
    }

}
