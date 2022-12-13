//Autores: Roger Macedo Drumond e  Reinaldo Correia Santos
//Versão: 1.0
//Data: 01/12/2022
//Objetivo:Buscar o resultado no site CNES de HOSPITAL e Salva-lo em Excell, filtrado por Estado e Gestão
package tests;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.WebDriverFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class portalrh {
    final static Logger logger = LoggerFactory.getLogger(portalrh.class);
    static private WebDriver browser;

    static private Wait<WebDriver> wait;

    @BeforeAll
    static public void configuration() {
        browser = WebDriverFactory.createChromeBrowser();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new FluentWait<WebDriver>(browser).withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
    }

    @Test
    public void myTest() throws InterruptedException {
        browser.get("https://cliente.apdata.com.br/everis/index.html");
        browser.findElement(By.xpath("//span[@id='button-1020-btnInnerEl']")).click(); //Pref dos Cookies//
        browser.findElement(By.name("userName_relogio_8001")).sendKeys(""); //<----Inserir CPF dentro das aspas//
        browser.findElement(By.name("password_relogio_8001")).sendKeys(""); //<--Inserir SENHA dentro das aspas//
        browser.findElement(By.id("ext-139")).click();
    }
    @Test
    public void testemarcacao(){
        String resultadoEsperado = "MARCACAO EFETUADA SEU NOME COMPLETO AQUI";
        String resultadoObitido = "MARCACAO EFETUADA SEU NOME COMPLETO AQUI";

        assertEquals(resultadoEsperado, resultadoObitido);
            System.out.println("PONTO REGISTRADO COM SUCESSO");

        browser.quit();
        }

}