package com.demoqa.pages;


import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@NonNull
public class DemoQAPages {


    protected TextBoxPage textBoxPage;
    protected AlertPage alertPage;
    protected PracticeFormPage practiceFormPage;
    protected ButtonsPage buttonsPage;
    protected ProgressBarPage progressBarPage;
    protected  MenuPage menuPage;
    protected  SelectMenu selectMenu;
    protected WebTable webTable;


//    @BeforeClass(alwaysRun = true)
    public void setUp() {
        textBoxPage = new TextBoxPage();
        alertPage = new AlertPage();
        practiceFormPage = new PracticeFormPage();
        buttonsPage = new ButtonsPage();
        progressBarPage = new ProgressBarPage();
        menuPage = new MenuPage();
        selectMenu = new SelectMenu();
        webTable = new WebTable();

    }
//


}
