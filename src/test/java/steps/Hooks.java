package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    private static WebDriver driver;

    @Before
    public void iniciar() {
        // Configuração para rodar em modo headless
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Modo sem interface gráfica
        options.addArguments("--disable-gpu"); // Desativa a aceleração gráfica
        options.addArguments("--window-size=1920x1080"); // Define o tamanho da janela

        driver = new ChromeDriver(options); // Inicia o Chrome com as opções configuradas
        driver.manage().window().maximize();
    }

    @After
    public void finalizar() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
