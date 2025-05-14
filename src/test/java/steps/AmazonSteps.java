package steps;


import org.testng.Assert;

import io.cucumber.java.en.And;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.amazon.LandingPage;
import pages.amazon.ProductPage;
import pages.amazon.ResultadosPage;

public class AmazonSteps {
    LandingPage landingPage = new LandingPage();
    ResultadosPage resultadosPage = new ResultadosPage();
    ProductPage productPage = new ProductPage();

    @Given("El usuario navega a {string}")
    public void navega_a(String url) {
        landingPage.navegarA(url);
    }

    @When("El usuario busca {}")
    public void busca(String producto) {
        landingPage.escribirProducto(producto);
        landingPage.clickBuscar();
    }

    @And("Navega a la pagina {string}")
    public void navega_a_la_pagina(String pageNumber) throws InterruptedException {
        resultadosPage.navegarAPagina(pageNumber);
        Thread.sleep(6000);
    }

    @And("Selecciona producto numero {int}")
    public void navega_a_la_pagina(int index) {
        resultadosPage.seleccionarProducto(index);
    }

    @Then("El producto está disponible para agregar al carrito")
    public void producto_disponible() {
        Assert.assertTrue(productPage.isAddToCartButtonVisible());
    }

}
