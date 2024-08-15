import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    public WebDriver driver;

    protected BasePage(WebDriver driver) { this.driver = driver; }

<<<<<<< HEAD
    public void setup() {
        driver.manage().window().maximize();
    }

    public void url(String url) throws InterruptedException {
        Thread.sleep(1000);
        driver.get(url); }
=======
    public void url(String url) {
        driver.get(url);
    }
>>>>>>> fe279fe (BeforeEach y AfterEach anotaciones)

    public void close() { driver.quit(); }

<<<<<<< HEAD
    protected WebElement findElement(By locator) { return driver.findElement(locator); }

    protected void sendText(String inputText, By locator ) throws InterruptedException {
        Thread.sleep(1000);
=======
    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public void sendText(String imputText, By locator ) {
>>>>>>> fe279fe (BeforeEach y AfterEach anotaciones)
        this.findElement(locator).clear();
        this.findElement(locator).sendKeys(imputText);
    }

    protected void sendKey(CharSequence key, By locator) throws InterruptedException {
        Thread.sleep(1000);
        this.findElement(locator).sendKeys(key);
    }

    public void click(By locator) throws InterruptedException {
        Thread.sleep(1000);
        this.findElement(locator).click();
    }

    protected String getText(By locator) throws InterruptedException {
        Thread.sleep(1000);
        return this.findElement(locator).getText();
    }

}