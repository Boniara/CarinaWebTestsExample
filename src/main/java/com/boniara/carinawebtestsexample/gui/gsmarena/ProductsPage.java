package com.boniara.carinawebtestsexample.gui.gsmarena;

import com.boniara.carinawebtestsexample.gui.gsmarena.components.ProductsReviewBody;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends AbstractPage {

    @FindBy(id = "review-body")
    private ProductsReviewBody productsReviewBody;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage clickProductByName(String productName) {
        productsReviewBody.clickProductItemByName(productName);
        return new ProductPage(driver);
    }
}
