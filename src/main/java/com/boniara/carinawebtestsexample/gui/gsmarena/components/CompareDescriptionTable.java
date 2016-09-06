package com.boniara.carinawebtestsexample.gui.gsmarena.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CompareDescriptionTable extends AbstractUIObject {

    @FindBy(xpath = ".//th")
    private ExtendedWebElement tableName;

    @FindBy(xpath = ".//tr")
    private List<CompareRow> columnNameList;

    public CompareDescriptionTable(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTableName() {
        return tableName.getText();
    }

    public CompareRow getCompareRow(String rowName) {
        for(CompareRow compareRow: columnNameList) {
            if(compareRow.getRowName().toLowerCase().contains(rowName.toLowerCase())) {
                return compareRow;
            }
        }
        throw new RuntimeException("Row not found");
    }
}
