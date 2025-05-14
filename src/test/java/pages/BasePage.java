package pages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
    protected static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    static{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    public WebElement Find(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath(locator)
        ));
    }

    public boolean isElementVisible(String locator) {
        return Find(locator).isDisplayed();
    }

    public void clickElement(String locator) {
        Find(locator).click();
    }

    public void write(String locator, String text) {
        Find(locator).clear();
        Find(locator).sendKeys(text);
    }

    public void selectDropdownByValue(String locator, String value) {
       Select dropdown = new Select(Find(locator));
       dropdown.selectByValue(value);
    }

    public void selectDropdownByIndex(String locator, int index) {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(index);
     }

     public int dropdownSize(String locator) {
        Select dropdown = new Select(Find(locator));
        return dropdown.getOptions().size();
     }

     public List<String> dropdownOptions(String locator) {
        Select dropdown = new Select(Find(locator));

        List<String> options = dropdown.getOptions().stream()
            .map(e -> e.getText())
            .collect(Collectors.toList());
        return options;
     }

    public static void closeBrowser() {
        driver.quit();
    }
}
