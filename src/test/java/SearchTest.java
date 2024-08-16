import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import reports.ExtentFactory;

import java.time.Duration;

public class SearchTest {

    public WebDriver driver;
    public WebDriverWait wait;

    static ExtentSparkReporter info = new ExtentSparkReporter("target/Reporte.html");
    static ExtentReports extent;

    @BeforeAll
    public static void createReport() {
        //report
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void preconditions() throws InterruptedException {
        //driver
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        SearchPage searchPage = new SearchPage(driver, wait);
        driver.manage().window().maximize();
        searchPage.url("https://digital-booking-front.digitalhouse.com/");
        Thread.sleep(1000);
    }

    @Test
    @Tag("BUSQUEDA")
    @Tag("SMOKE")
    public void BusquedaExitosa_Grecia() throws InterruptedException {
        ExtentTest test = extent.createTest("Busqueda exitosa en Grecia");
        test.log(Status.INFO, "Comienza nuestro test de busqueda");

        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.writeSearch("Paros");
        searchPage.clickSearch();
        test.log(Status.PASS, "Se realizo la busqueda de Uruguay exitosamente");

        searchPage.searchResult();
        test.log(Status.PASS,"Se valida que la busqueda ha sido exitosa");
    }

    @Test
    @Tag("BUSQUEDA")
    @Tag("REGRESSION")
    public void BusquedaExitosa_Uruguay() throws InterruptedException {
        ExtentTest test = extent.createTest("Busqueda exitosa en Uruguay");
        test.log(Status.INFO, "Comienza nuestro test de busqueda");

        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.writeSearch("Punta del este");
        searchPage.clickSearch();
        test.log(Status.PASS, "Se realizo la busqueda de Uruguay exitosamente");

        searchPage.searchResult();
        test.log(Status.PASS,"Se valida que la busqueda ha sido exitosa");
    }

    @AfterEach
    public void close() {
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.close();
    }

    @AfterAll
    public static void saveReport() {
        extent.flush();
    }

}