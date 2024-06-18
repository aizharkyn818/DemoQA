package com.demoqa.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DropdownHelper {

    public WebDriver driver;
    WebElementActions webElementActions = new WebElementActions();

    public DropdownHelper(WebDriver driver) {
        this.driver = driver;
    }

    public DropdownHelper selectByVisibleText(WebElement element, String value){
        Select select = new Select(element);
        List<WebElement> selectValueList = select.getOptions();
        List<String> selectValueText = new ArrayList<>();
        for (WebElement option : selectValueList){
            selectValueText.add(option.getText());
        }
        for (String text : selectValueText){
            System.out.println(text);
        }
        select.selectByVisibleText(value);

        return this;
    }
    public void printOptions(WebElement element, List<WebElement> dropdownItems){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        webElementActions.waitElementToBeClickable(element).click(element);
        List<String> itemTextList = new ArrayList<>();
        for (WebElement item : dropdownItems){
            itemTextList.add(item.getText());
        }
        for (String text: itemTextList ){
            System.out.println(text);
        }
    }

    public List<String> getAllOptions(WebElement divElement, String optionsXPath) {
        webElementActions.scrollToElement(divElement);
        divElement.click();
        List<WebElement> options =driver.findElements(By.xpath(optionsXPath));
        return options.stream().map(WebElement::getText).collect(Collectors.toList());
    }

}
