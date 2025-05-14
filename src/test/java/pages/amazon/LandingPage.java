package pages.amazon;

import pages.BasePage;

public class LandingPage extends BasePage {

    String searchBox = "//input[@id='twotabsearchtextbox']";
    String searchButton = "//input[@id='nav-search-submit-button']";

    public LandingPage() {
        super(driver);
    }

    public void navegarA(String url) {
        driver.get("https://"+url);
        driver.navigate().refresh();
    }

    public void escribirProducto(String producto){
        write(searchBox, producto);
    }

    public void clickBuscar(){
        clickElement(searchButton);
    }

}
