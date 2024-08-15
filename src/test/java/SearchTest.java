import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest {

    public WebDriver driver;

    @BeforeEach

    public void preconditions() throws InterruptedException {
        driver = new ChromeDriver();
        SearchPage searchPage = new SearchPage(driver);
        driver.manage().window().maximize();
        searchPage.url("https://digital-booking-front.digitalhouse.com/");
        Thread.sleep(1000);
    }

    @Test
    public void BusquedaExitosa_Grecia() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.writeSearch("Paros");
        Thread.sleep(1000);

        searchPage.clickSearch();
        Thread.sleep(2000);

        searchPage.searchResult();
    }

    @Test
    public void BusquedaExitosa_Uruguay() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.writeSearch("Punta del este");
        Thread.sleep(1000);

        searchPage.clickSearch();
        Thread.sleep(2000);

        searchPage.searchResult();
    }

    @AfterEach
    public void close() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.close();

        driver.quit();

    }

}