package pages.amazon;

import pages.BasePage;

public class ProductPage extends BasePage{

    String addToCartButton = "//input[@id='add-to-cart-button']";
    public ProductPage() {
        super(driver);
    }


    public boolean isAddToCartButtonVisible(){
        return isElementVisible(addToCartButton);
    }



}
