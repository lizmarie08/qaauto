import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class Prueba2Test {

    private WebDriver chromeDriver;

    @Before
    public void abrirDriver(){
        //Encontrar archivo exe de chromedriver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");

        //Creamos opciones sobre nuestro driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setCapability("marionette",false);

        //Crear nueva instancia de ChromeDriver
        chromeDriver = new ChromeDriver(options);

        //Definimos tiempo de espera que aceptamos como timeouts
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void hacer_una_busqueda(){

        //Abrimos URL
        chromeDriver.get("https://www.google.com/");

        //Encontrar e interactuar con elementos

        //Ingresar elemento en ele navegador
        chromeDriver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Cantidad de paises en america");

        //Presionamos la Tecla Enter
        chromeDriver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(Keys.ENTER);

        //Hacer Click sobre el enlace deseado
        chromeDriver.findElement(By.xpath("//h3[contains(text(),'Mapa Político de América: Países y Capitales - Web')]")).click();

        //Creamos un elemento web para poder hacer acciones mas avanzadas
        WebElement subtitulo = chromeDriver.findElement(By.xpath("//div[@id='parent-fieldname-text-9e0c6eb328e44d43b18fed80e395ae9f']"));

        //Verificamos que la cantidad de paises en america sigan siendo 35
        Assert.assertTrue(subtitulo.getText().contains("sudifshk"));

    }

    @After
    public void cerrarDriver(){
        //Cerrar navegador
        //chromeDriver.quit();
    }

}
