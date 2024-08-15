import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchTest {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeEach

    public void preconditions() throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        SearchPage searchPage = new SearchPage(driver, wait);
        driver.manage().window().maximize();
        searchPage.url("https://digital-booking-front.digitalhouse.com/");
        Thread.sleep(1000);
    }

    @Test
    public void BusquedaExitosa_Grecia() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.writeSearch("Paros");

        searchPage.clickSearch();
        searchPage.searchResult();
    }

    @Test
    public void BusquedaExitosa_Uruguay() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.writeSearch("Punta del este");

        searchPage.clickSearch();
        searchPage.searchResult();
    }

    @AfterEach
    public void close() {
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.close();
    }

}