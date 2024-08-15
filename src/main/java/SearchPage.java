import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage{

    private By searchBox = By.id("ciudad");

    private By searchButtom = By.id("btn-buscador");

    private By searchOk = By.className("categoria");



    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void writeSearch(String ciudad) throws InterruptedException {
        this.sendText(ciudad, searchBox);
        this.sendKey(Keys.ENTER, searchBox);
    }

    public void clickSearch() throws InterruptedException  {
        this.click(searchButtom);
    }

    public String searchResult() throws InterruptedException {
        String res = this.getText(searchOk);
        System.out.println("RESULTADO DE LA BUSQUEDA: " + res);
        return this.getText(searchOk);
    }


}
