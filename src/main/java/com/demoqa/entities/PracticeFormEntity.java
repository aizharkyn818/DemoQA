package com.demoqa.entities;


import lombok.*;
import org.openqa.selenium.WebElement;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

public class PracticeFormEntity {

    private String firstNameInput;
    private String lastNameInput;
    private String emailInput;
    private WebElement gender;
    private String mobileNumberInput;
    private String subjectInput;
    private WebElement hobby;
    private String currentAddressInput;
    private String stateSelectInput;
    private String citySelectInput;



}
