package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.helper.DropdownHelper;
import com.demoqa.helper.WebElementActions;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public WebElementActions actions = new WebElementActions();
    public DropdownHelper dropdownHelper = new DropdownHelper(DriverManager.getDriver());

}
