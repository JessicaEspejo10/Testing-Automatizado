import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class SearchTest {

    public WebDriver driver;

    @BeforeEach
    public void precondition() throws InterruptedException {
        driver = new ChromeDriver();
        SearchPage searchPage = new SearchPage(driver);

        searchPage.setup();
        searchPage.url("https://digital-booking-front.digitalhouse.com/");
    }

    @Test
    public void BusquedaExitosa_Grecia() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);

        searchPage.writeSearch("Paros");
        searchPage.clickSearch();

        searchPage.searchResult();
    }

    @Test
    public void BusquedaExitosa_Uruguay() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);

        searchPage.writeSearch("Punta del Este");
        searchPage.clickSearch();

        searchPage.searchResult();
    }

    @AfterEach
    public void close() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.close();
    }

}