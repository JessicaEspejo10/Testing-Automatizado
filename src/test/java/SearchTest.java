<<<<<<< HEAD
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
=======
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
>>>>>>> fe279fe (BeforeEach y AfterEach anotaciones)
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest {

    public WebDriver driver;

    @BeforeEach
<<<<<<< HEAD
    public void precondition() throws InterruptedException {
        driver = new ChromeDriver();
        SearchPage searchPage = new SearchPage(driver);

        searchPage.setup();
        searchPage.url("https://digital-booking-front.digitalhouse.com/");
=======
    public void preconditions() throws InterruptedException {
        driver = new ChromeDriver();
        SearchPage searchPage = new SearchPage(driver);
        driver.manage().window().maximize();
        searchPage.url("https://digital-booking-front.digitalhouse.com/");
        Thread.sleep(1000);
>>>>>>> fe279fe (BeforeEach y AfterEach anotaciones)
    }


    @Test
    public void BusquedaExitosa_Grecia() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);
<<<<<<< HEAD

        searchPage.writeSearch("Paros");
=======
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

>>>>>>> fe279fe (BeforeEach y AfterEach anotaciones)
        searchPage.clickSearch();
        Thread.sleep(2000);

        searchPage.searchResult();
    }

<<<<<<< HEAD
    @Test
    public void BusquedaExitosa_Uruguay() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);

        searchPage.writeSearch("Punta del Este");
        searchPage.clickSearch();

        searchPage.searchResult();
    }

=======
>>>>>>> fe279fe (BeforeEach y AfterEach anotaciones)
    @AfterEach
    public void close() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.close();
<<<<<<< HEAD
=======
        driver.quit();
>>>>>>> fe279fe (BeforeEach y AfterEach anotaciones)
    }

}