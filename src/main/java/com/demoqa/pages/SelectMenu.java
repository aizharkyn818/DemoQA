package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class SelectMenu extends BasePage {


    @FindBy(id = "oldSelectMenu")
    public WebElement selectMenu;


    @FindBy(xpath = "//div[@class =  ' css-yk16xz-control'][1]")
    public WebElement selectValueDropdown;
    @FindBy(xpath = "//div[contains(@class, 'option')]")
    public List<WebElement> selectValueOptions;

    @FindBy(xpath = "(//div[@class =  ' css-yk16xz-control'])[3]")
    public WebElement multiSelectDropdown;

    @FindBy(xpath = " //*[@class=' css-26l3qy-menu']")
    public List<WebElement> multiSelectOptions;

    @FindBy(id = "selectOne")
    public WebElement selectOneDropdown;



    public SelectMenu menuListSelect() {
        actions.menuSelection("//div[@id='withOptGroup']", "//div[contains(@class, 'option')]");
        return this;
    }

    public SelectMenu selectOne() {
        actions.menuSelection("//div[@id='selectOne']", "//div[contains(@class, 'option')]");
        return this;
    }
}
