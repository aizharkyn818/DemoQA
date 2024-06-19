package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.entities.PracticeFormEntity;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Year;
import java.util.*;

public class PracticeFormPage extends BasePage {

    @FindBy(id = "firstName")
    public WebElement nameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "userEmail")
    public WebElement userEmailInput;

    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")
    public WebElement male;

    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[2]/label")
    public WebElement female;

    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[3]/label")
    public WebElement other;

    @FindBy(id = "userNumber")
    public WebElement userNumberInput;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirthInput;

    @FindBy(className = "react-datepicker__input-container")
    public WebElement datePickerBtn;

    @FindBy(id = "subjectsInput")
    public WebElement subjectsInput;

    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label")
    public WebElement sports;

    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]/label")
    public WebElement reading;

    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]/label")
    public WebElement music;

    @FindBy(id = "uploadPicture")
    public WebElement uploadPicture;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressInput;

    @FindBy(id = "react-select-3-input")
    public WebElement stateSelect;

    @FindBy(id = "react-select-4-input")
    public WebElement citySelect;

    @FindBy(id = "submit")
    public WebElement submitBtn;
    public Random random;



    public PracticeFormPage fillUpPracticeForm(PracticeFormEntity practiceFormEntity) throws InterruptedException {
        actions.sendKeys(nameInput, practiceFormEntity.getFirstNameInput()).
                sendKeys(lastNameInput, practiceFormEntity.getLastNameInput()).
                sendKeys(userEmailInput, practiceFormEntity.getEmailInput()).click(genderSelection()).
                sendKeys(userNumberInput, practiceFormEntity.getMobileNumberInput());
        selectDateMonthYear("23 November 1994");
        Thread.sleep(5000);
        actions.sendKeysWithEnter(subjectsInput, practiceFormEntity.getSubjectInput());
                randomlyCheckCheckboxes(sports, reading, music);
        actions.sendKeys(uploadPicture, "C:\\Users\\User\\IdeaProjects\\DemoQAWinter2024\\src\\main\\java\\com\\demoqa\\pics\\13680721_1760866110856798_2223196443428561251_n.jpg")
                .sendKeys(currentAddressInput, practiceFormEntity.getCurrentAddressInput())
                .sendKeysWithEnter(stateSelect, actions.randomElementSelection("(//div[@class=' css-1hwfws3'])[1]", "//div[contains(@class,'menu')]//div[contains(@class,'option')]"))
                .sendKeysWithEnter(citySelect, actions.randomElementSelection("(//div[@class=' css-1hwfws3'])[2]", "//div[contains(@class,'menu')]//div[contains(@class,'option')]"));
        Thread.sleep(10000);
        actions.click(submitBtn);
        Thread.sleep(5000);
        return this;
    }


    @Step("Select date, month and year {0}")
    public PracticeFormPage selectDateMonthYear(String dateMonthYear) {
        String[] dateMonthYearParts = dateMonthYear.split(" ");
        String date = dateMonthYearParts[0];
        String month = dateMonthYearParts[1];
        String year = dateMonthYearParts[2];

        actions.click(datePickerBtn);

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(10));

        WebElement monthDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__month-select")));

        WebElement yearDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__year-select")));

        dropdownHelper.selectByVisibleText(monthDropdown, month)
                .selectByVisibleText(yearDropdown, year);

        ////div[contains(@class,'react-datepicker__day') and not(contains(@class,'react-datepicker__day--outside-month')) and text()=1]
        WebElement dayElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'react-datepicker__day') and not(contains(@class,'react-datepicker__day--outside-month')) and text()='"+date +"']")));
        actions.click(dayElement);
        return this;
    }

    public WebElement genderSelection() {
        List<WebElement> genderOptions = List.of(male, female, other);
        random = new Random();
        return genderOptions.get(random.nextInt(genderOptions.size()));
    }
    public PracticeFormPage randomlyCheckCheckboxes(WebElement sports, WebElement reading, WebElement music) {
        Random random = new Random();
        List<WebElement> hobbyOptions = List.of(sports, reading, music);

        int numberOfCheckboxesToSelect = random.nextInt(3) + 1;

        Set<Integer> selectedIndexes = new HashSet<>();
        while (selectedIndexes.size() <= numberOfCheckboxesToSelect) {
            selectedIndexes.add(random.nextInt(hobbyOptions.size()));
        }

        for (int index : selectedIndexes) {
            hobbyOptions.get(index).click();
        }
        return  this;
    }

}




