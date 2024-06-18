package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.entities.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class WebTable extends BasePage {


    private static final Logger LOGGER = Logger.getLogger(WebTable.class.getName());
    ;
    @FindBy(id = "addNewRecordButton")
    public WebElement addNewBtn;

    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "userEmail")
    public WebElement emailInput;

    @FindBy(id = "age")
    public WebElement ageInput;

    @FindBy(id = "salary")
    public WebElement salaryInput;

    @FindBy(id = "department")
    public WebElement departmentInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;

    @FindBy(id = "delete-record-2")
    public WebElement deleteBtn;

    public List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable .rt-tr-group"));
    private WebDriverWait wait;


    public WebTable addNewEmployee(Employee employee) {
        boolean emailExists = getEmployeesFromTable().stream().anyMatch(e -> e.getEmail().equals(employee.getEmail()));

        if (emailExists) {
            throw new IllegalArgumentException("This email already exists: " + employee.getEmail());
        }
        actions.click(addNewBtn)
                .sendKeys(firstNameInput, employee.getFirstName())
                .sendKeys(lastNameInput, employee.getLastName())
                .sendKeys(emailInput, employee.getEmail())
                .sendKeys(ageInput, String.valueOf(employee.getAge()))
                .sendKeys(salaryInput, String.valueOf(employee.getSalary()))
                .sendKeys(departmentInput, employee.getDepartment())
                .click(submitBtn);
        return this;
    }


    public ArrayList<Employee> getEmployeesFromTable() {

        ArrayList<Employee> employees = new ArrayList<>();

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
            String firstName = cells.get(0).getText();
            String lastName = cells.get(1).getText();
            String ageText = cells.get(2).getText().replaceAll("[^0-9]", "");
            String email = cells.get(3).getText();
            String salaryText = cells.get(4).getText().replaceAll("[^0-9]", "");
            String department = cells.get(5).getText();

            if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() || email.isEmpty() || salaryText.isEmpty()
                    || department.isEmpty()) {
                continue;
            }

            int age = Integer.parseInt(ageText.trim());
            long salary = Long.parseLong(salaryText.trim());

            employees.add(new Employee(firstName, lastName, age, email, salary, department));

        }
        return employees;
    }

    public void deleteByEmail(String targetEmail) throws InterruptedException {

        try {
            boolean emailFound = false;
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));

                // Если строка содержит ячейки и адрес электронной почты найден в одной из ячеек
                if (!cells.isEmpty() && cells.get(3).getText().equals(targetEmail)) { //email находится в третьей ячейке (индекс 2)
                    emailFound = true;
                    actions.click(deleteBtn);
                    break;
                }
            }

            if (emailFound) {
                System.out.println("Строка с адресом " + targetEmail + " была найдена и удалена.");
            } else {
                System.out.println("Строка с адресом " + targetEmail + " не найдена.");
            }

        } finally {
            Thread.sleep(10);
            DriverManager.getDriver().quit();
        }


    }

    public WebTable editEmployeeData(String email, String oldValue, String newValue) {

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
            if (cells.size() > 3 && cells.get(3).getText().equals(email)) {
                WebElement editBtn = row.findElement(By.cssSelector("#edit-record-1"));
                actions.click(editBtn);
                // uslovie dlya zameny starogo value na new value
                switch (oldValue) {
                    case "firstName":
                        WebElement firstNameInput = DriverManager.getDriver().findElement(By.id("firstName"));
                        actions.clear(firstNameInput)
                                .sendKeys(firstNameInput, newValue);
                        break;
                    case "lastName":
                        WebElement lastNameInput = DriverManager.getDriver().findElement(By.id("lastName"));
                        actions.clear(lastNameInput)
                                .sendKeys(lastNameInput, newValue);
                        break;
                    case "age":
                        WebElement ageInput = DriverManager.getDriver().findElement(By.id("age"));
                        actions.clear(ageInput)
                                .sendKeys(ageInput, newValue);
                        break;
                    case "email":
                        WebElement emailInput = DriverManager.getDriver().findElement(By.id("userEmail"));
                        actions.clear(emailInput)
                                .sendKeys(emailInput, newValue);
                        break;
                    case "salary":
                        WebElement salaryInput = DriverManager.getDriver().findElement(By.id("salary"));
                        actions.clear(salaryInput)
                                .sendKeys(salaryInput, newValue);
                        break;
                    case "department":
                        WebElement departmentInput = DriverManager.getDriver().findElement(By.id("department"));
                        actions.clear(departmentInput)
                                .sendKeys(departmentInput, newValue);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid field : " + oldValue);
                }
                // Save updated information
                WebElement submitBtn = DriverManager.getDriver().findElement(By.cssSelector("#submit"));
                actions.click(submitBtn);
                break;
            }
        }
        return this;
    }


}

