package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.BuscaPage;
import static org.junit.Assert.*;

public class BuscaSteps {
    WebDriver driver = Hooks.getDriver();
    BuscaPage buscaPage = new BuscaPage(driver);

    @Given("que o usuário está na página inicial")
    public void realizar_busca() {
        buscaPage.abrirPagina();
    }

    @When("ele clica no botão da busca")
    public void clicar_busca() {
        buscaPage.clicarBusca();           
    }

    @When("ele clica na busca e a realiza {string}")
    public void realizar_busca(String valorBuscado) {
        buscaPage.realizarBusca(valorBuscado);               
    }

    @Then("ele deve ver a mensagem {string}")
    public void verificar_mensagem(String mensagemEsperada) {
        assertEquals(mensagemEsperada, buscaPage.obterMensagemResultadoBusca());
        driver.quit();
    }

    @Then("ele deve ver a mensagem de falha na busca {string}")
    public void verificarMensagemSemResultado(String mensagemEsperada) {
        assertEquals(mensagemEsperada, buscaPage.obterMensagemSemResultado());
        driver.quit();
    }
}
