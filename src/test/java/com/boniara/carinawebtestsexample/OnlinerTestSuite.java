package com.boniara.carinawebtestsexample;

import com.boniara.carinawebtestsexample.onliner.pages.*;
import com.boniara.carinawebtestsexample.onliner.components.SearchIFrame;
import com.qaprosoft.carina.core.foundation.UITest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OnlinerTestSuite extends UITest {

    @Test(description = "Test check equals of phone descriptions from " +
            "phone page and reviews page")
    public void checkPhoneDescriptions() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(20), "Home page is not opened");
        CatalogPage catalogPage = homePage.catalogClick();
        MobileCatalogPage mobileCatalogPage = catalogPage.mobileCatalogClick();
        mobileCatalogPage.checksBlock.getCheckboxblock("Производитель").check("Xiaomi");
        mobileCatalogPage.checksBlock.getCheckboxblock("рынок").check(2016);
        pause(4);
        PhonePage phonePage = mobileCatalogPage.maxReviewsPageClick();
        String description = phonePage.getPhoneDescription();
        ReviewsPage reviewsPage = phonePage.reviewsPageClick();
        String descriptionFromReviewsPage = reviewsPage.getPhoneDescription();
        Assert.assertEquals(description, descriptionFromReviewsPage, "Phone description are not identical.");
    }

    @Test(dataProvider = "DataProvider", description = "Test check search logic from search iframe")
    @XlsDataSourceParameters(path = "onlinerTest.xls", sheet = "OT-0001", dsUid = "TUID", executeColumn = "Execute"
            , executeValue = "Y", dsArgs = "phoneName, phoneNameCheckerRow")
    public void checkSearchLogic(String phoneName, String phoneNameCheckerRow) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(20), "Home page is not opened");
        SearchIFrame frame = homePage.sendToInputField(phoneName);
        frame.checkResultContains(phoneNameCheckerRow).assertAll();
    }

    @Test(description = "Test check enables of loginWithFacebook page and visibled of onliner logotype")
    public void checkLoginWithFacebook(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(20), "Home page is not opened");
        String homePId = getDriver().getWindowHandle();
        LoginWithFacebookPage loginWithFacebookPage = homePage.clickAndGetLoginFacebookWindow();
        loginWithFacebookPage.clickCancelButton();
        getDriver().switchTo().window(homePId);
        Assert.assertTrue(homePage.isLogotypeDisplayed(), "Onliner logotype is not displayed");
    }
}
