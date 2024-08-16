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

public class LoginTest {
    public WebDriver driver;
    public WebDriverWait wait;

    static ExtentSparkReporter info = new ExtentSparkReporter("target/Reporte-Login.html");
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
        LoginPage loginPage = new LoginPage(driver, wait);
        driver.manage().window().maximize();
        loginPage.url("https://digital-booking-front.digitalhouse.com/login");
        Thread.sleep(1000);
    }

    @Test
    @Tag("LOGIN")
    public void login_Exitoso() throws InterruptedException {
        ExtentTest test = extent.createTest("Login Exitoso");
        test.log(Status.INFO, "Comienza nuestro test de login");
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.writeEmail("prueba365@gmail.com");
        loginPage.writePassword("123456");
        test.log(Status.PASS, "Se cargaron los datos validos del Login");

        loginPage.clickLogin();

        Assertions.assertEquals(loginPage.hello(), "Hola,");
        Assertions.assertEquals(loginPage.nameLogin(), "Sergio Pace");
        test.log(Status.PASS, "Se valida el login exitoso");
    }

    @Test
    @Tag("LOGIN")
    public void login_DatosVacios() throws InterruptedException {
        ExtentTest test = extent.createTest("Intentar loguearse sin agregar ningun dato");
        test.log(Status.INFO, "Comienza nuestro test de login vacio");
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.writeEmail("");
        loginPage.writePassword("");
        test.log(Status.PASS, "No se agregaron datos del Login");

        loginPage.clickLogin();

        loginPage.requiredEmail();
        loginPage.requiredPassword();
        test.log(Status.PASS, "Se valida el mensaje de campos obligatorio");
    }

    @Test
    @Tag("LOGIN")
    public void login_CorreoInvalido() throws InterruptedException {
        ExtentTest test = extent.createTest("Intentar loguearse con correo invalido");
        test.log(Status.INFO, "Comienza nuestro test de login");
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.writeEmail("prueba365");
        loginPage.writePassword("123456");
        test.log(Status.PASS, "Se agregan los datos con un correo invalido");

        loginPage.clickLogin();
        //correo invalido
        loginPage.invalidCredentials();
        test.log(Status.PASS, "Se valida el mensaje de correo invalido");
    }

    @Test
    @Tag("LOGIN")
    public void login_ContraseñaCorta() throws InterruptedException {
        ExtentTest test = extent.createTest("Intentar loguearse con una contraseña corta");
        test.log(Status.INFO, "Comienza nuestro test de login");
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.writeEmail("prueba365@gmail.com");
        loginPage.writePassword("1");
        test.log(Status.PASS, "Se agregan los datos con una contraseña menor a 6 caracteres");

        loginPage.clickLogin();

        loginPage.shortPassword();
        test.log(Status.PASS, "Se valida el mensaje de contraseña menor a 6 caracteres");
    }


    @Test
    @Tag("LOGIN")
    public void login_CredencialesInvalidas() throws InterruptedException {
        ExtentTest test = extent.createTest("Intentar loguearse con credenciales invalidas");
        test.log(Status.INFO, "Comienza nuestro test de login");
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.writeEmail("prueba365@gmail.com");
        loginPage.writePassword("1jhtgrfeds");
        test.log(Status.PASS, "Se agregan los datos con una contraseña erronea");

        loginPage.clickLogin();

        loginPage.invalidCredentials();
        test.log(Status.PASS, "Se valida el mensaje de contraseña menor a 6 caracteres");
    }

    @AfterEach
    public void close() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.close();
    }

    @AfterAll
    public static void saveReport() {
        extent.flush();
    }

}
