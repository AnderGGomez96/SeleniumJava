package pages.amazon;

import java.util.List;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;

import pages.BasePage;

public class ResultadosPage extends BasePage{

    String pageLink = "//a[@aria-label='Ir a la página %s']";
    String productos = "//div[@data-cy='title-recipe']//child::a[@class='a-link-normal s-line-clamp-2 s-link-style a-text-normal']";

    public ResultadosPage() {
        super(driver);
    }

    public void navegarAPagina(String pageNumber){
        clickElement(String.format(pageLink, pageNumber));
    }

    public List<WebElement> obtenerProductos(){
        return driver.findElements(By.xpath(productos));
    }

    public void seleccionarProducto(int index){
        obtenerProductos().get(index-1).click();
    }



}
