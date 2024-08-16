import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    private By email = By.id("email");

    private By password = By.id("password");

    private By submitButtom = By.xpath("//*[@id=\"root\"]/main/div/form/button");

    private By hello = By.className("txt-hola");

    private By name = By.className("txt-nombre");

    private By mailReq = By.xpath("//*[@id=\"root\"]/main/div/form/div[1]/small");

    private By passwordReq = By.xpath("//*[@id=\"root\"]/main/div/form/div[2]/small");

    private By emailInv = By.xpath("//*[@id=\"root\"]/main/div/form/div[1]/small");

    private By passwordLenght = By.xpath("//*[@id=\"root\"]/main/div/form/div[2]/small");

    private By credentialsOk = By.className("form-feedback");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, null);
    }

    public void writeEmail(String correo) throws InterruptedException {
        this.sendText(correo, email);
    }

    public void writePassword(String pin) throws InterruptedException {
        this.sendText(pin, password);
    }

    public void clickLogin() throws InterruptedException  {
        this.click(submitButtom);
    }

    public String hello() throws InterruptedException {
        System.out.println("MENSAJE DE SALUDO: " + this.getText(hello));
        return this.getText(hello);
    }

    public String nameLogin() throws InterruptedException {
        System.out.println("MENSAJE DE NOMBRE DE USUARIO: " + this.getText(name));
        return this.getText(name);
    }

    public String requiredEmail() throws InterruptedException {
        System.out.println("MENSAJE DE ERROR: " + this.getText(mailReq));
        return this.getText(mailReq);
    }

    public String requiredPassword() throws InterruptedException {
        System.out.println("MENSAJE DE ERROR: " + this.getText(passwordReq));
        return this.getText(passwordReq);
    }

    public String shortPassword() throws InterruptedException {
        System.out.println("MENSAJE DE ERROR: " + this.getText(passwordLenght));
        return this.getText(passwordLenght);
    }

    public String invalidCredentials() throws InterruptedException {
        System.out.println("MENSAJE DE ERROR: " + this.getText(credentialsOk));
        return this.getText(credentialsOk);
    }
}
