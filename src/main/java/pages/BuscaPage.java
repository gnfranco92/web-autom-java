package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class BuscaPage {
    private WebDriver driver;

    private By campoBusca = By.id("search-field");
    private By botaoBusca = By.cssSelector("div[data-section='section-header-search']");
    private By mensagemResultadoBusca = By.cssSelector("h1.page-title.ast-archive-title");
    private By mensagemSemResultado = By.cssSelector("section.no-results.not-found > div.page-content > p");

    public BuscaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void abrirPagina() {
        driver.get("https://blog.agibank.com.br");
        if (driver.getCurrentUrl().contains("#")) {
        driver.navigate().to("https://blog.agibank.com.br");
        }
    }   

    public void realizarBusca(String valorBuscado) {
        // Try/catch necessário devido a interação com o botaoBusca ser intermitente
    try {
       
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement botao = wait.until(ExpectedConditions.elementToBeClickable(botaoBusca));
        botao.click();
       
        WebElement inputBusca = wait.until(ExpectedConditions.elementToBeClickable(campoBusca));
        inputBusca.clear();
        inputBusca.sendKeys(valorBuscado + Keys.ENTER);

    } catch (Exception e) {
        System.out.println("Erro ao tentar realizar a busca: " + e.getMessage());
        
        try {
            String searchUrl = "https://blogdoagi.com.br/?s=" + valorBuscado.replace(" ", "+");
            driver.get(searchUrl);
            System.out.println("Navegação direta para URL de busca: " + searchUrl);

        } catch (Exception e2) {
            System.out.println("Falha na segunda tentativa de busca por URL direta: " + e2.getMessage());
            throw e2;
            }
        }
    }
         
    public void preencherBusca(String valorBuscado) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inputBusca = wait.until(ExpectedConditions.elementToBeClickable(campoBusca));        
        inputBusca.clear(); 
        inputBusca.sendKeys(valorBuscado + Keys.ENTER);
    }

    public void clicarBusca() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement botao = wait.until(ExpectedConditions.elementToBeClickable(botaoBusca));
        botao.click();
     }

    public String obterMensagemResultadoBusca() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemResultadoBusca));
        return elemento.getText();
    }

    public String obterMensagemSemResultado() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemSemResultado));
        return msg.getText();
    }           
}
