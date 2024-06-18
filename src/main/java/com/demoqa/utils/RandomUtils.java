package com.demoqa.utils;

import com.demoqa.entities.Employee;
import com.demoqa.entities.PracticeFormEntity;
import com.demoqa.entities.TextBoxEntity;
import com.demoqa.pages.WebTable;
import com.github.javafaker.Faker;

public class RandomUtils {

    Faker faker = new Faker();

    public TextBoxEntity generateRandomTextBoxEntity(){
        TextBoxEntity textBoxEntity = new TextBoxEntity();
        textBoxEntity.setFullName(faker.name().fullName());
        textBoxEntity.setEmail(faker.internet().emailAddress());
        textBoxEntity.setCurrentAddress(faker.address().fullAddress());
        textBoxEntity.setPermanentAddress(faker.address().secondaryAddress());

        return textBoxEntity;
    }

    public PracticeFormEntity generatePracticeFormEntity(){
            PracticeFormEntity practiceFormEntity = new PracticeFormEntity();
            practiceFormEntity.setFirstNameInput(faker.name().firstName());
            practiceFormEntity.setLastNameInput(faker.name().lastName());
            practiceFormEntity.setEmailInput(faker.internet().emailAddress());
            practiceFormEntity.setMobileNumberInput(faker.phoneNumber().subscriberNumber(10));
            practiceFormEntity.setSubjectInput("Arts");
            practiceFormEntity.setCurrentAddressInput(faker.address().fullAddress());
            practiceFormEntity.setStateSelectInput("Uttar Pradesh");
            practiceFormEntity.setCitySelectInput("Agra");

            return practiceFormEntity;
    }

    public Employee createMockEmployee(){
        Employee employee = new Employee();

        employee.setFirstName(faker.name().firstName());
        employee.setLastName(faker.name().lastName());
        employee.setAge(faker.number().numberBetween(18,100));
        employee.setEmail(faker.internet().emailAddress()); // or existing mail address
        employee.setSalary(faker.number().numberBetween(1000000L,20000000000L ));
        employee.setDepartment(faker.job().position());

        return employee;

    }
}
