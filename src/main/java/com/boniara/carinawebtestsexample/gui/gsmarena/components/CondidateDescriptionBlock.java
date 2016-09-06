package com.boniara.carinawebtestsexample.gui.gsmarena.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CondidateDescriptionBlock extends AbstractUIObject {

    @FindBy(xpath = ".//table")
    private List<CompareDescriptionTable> compareDescriptionTableList;

    public CondidateDescriptionBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CompareDescriptionTable getCompareDescriptionTable(String name) {
        for(CompareDescriptionTable compareDescriptionTable: compareDescriptionTableList) {
            if(compareDescriptionTable.getTableName().toLowerCase().contains(name.toLowerCase())) {
                return compareDescriptionTable;
            }
        }
        throw new RuntimeException("Table is not found");
    }
}
