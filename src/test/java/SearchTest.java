import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class SearchTest {

    public WebDriver driver;

    @Test
    public void BusquedaExitosa() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://digital-booking-front.digitalhouse.com/");
        Thread.sleep(1000);

        WebElement searchBox = driver.findElement(By.id("ciudad"));
        searchBox.sendKeys("Punta del Este");
        searchBox.sendKeys(Keys.ENTER);

        WebElement searchButtom = driver.findElement(By.id("btn-buscador"));
        searchButtom.click();


        WebElement searchOk = driver.findElement(By.xpath("//*[@id=\"68\"]/div[2]/div/div[1]"));
        String busquedaCorrecta = searchOk.getText();
        System.out.println(busquedaCorrecta);

        driver.quit();

    }
}