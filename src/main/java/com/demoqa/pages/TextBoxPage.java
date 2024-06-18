package com.demoqa.pages;


import com.demoqa.entities.TextBoxEntity;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TextBoxPage extends BasePage {


    @FindBy(id = "userName")
    public WebElement fullNameInput;

    @FindBy(id = "userEmail")
    public WebElement emailInput;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressInput;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddressInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;

    public TextBoxPage fillUpTextBoxForm(String fullName, String email, String currentAddress, String permanentAddress) {
        actions.sendKeys(fullNameInput, fullName)
                .sendKeys(emailInput, email)
                .sendKeys(currentAddressInput, currentAddress)
                .sendKeys(permanentAddressInput, permanentAddress)
                .click(submitBtn);

        return this;
    }

    @Step("Fill up TextBox form")
    public TextBoxPage fillUpTextBoxForm(TextBoxEntity textBoxEntity) {
        actions.sendKeys(fullNameInput, textBoxEntity.getFullName())
                .jsSendKeys(emailInput, textBoxEntity.getEmail())
                .jsSendKeys(currentAddressInput, textBoxEntity.getCurrentAddress())
                .jsSendKeys(permanentAddressInput, textBoxEntity.getPermanentAddress())
                .click(submitBtn);

        return this;
    }

}
