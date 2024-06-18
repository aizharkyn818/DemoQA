package com.demoqa1.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class KoverSamolet2 {

    WebDriver driver = new ChromeDriver();


    public void setDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15000));
        driver.manage().window().maximize();
        driver.get("https://dostavka312.kg/");
    }

    @Test
    void koverSamoletTest(){

        WebElement foodIcon = driver.findElement(By.xpath("//img[@alt='edaG']"));
        foodIcon.click();

        List<WebElement> listOfFacilities = driver.findElements(By.xpath("//p/parent::div[@class='panel-heading']"));
        WebElement barashek = listOfFacilities.stream().filter(f ->f.getText().equals("Барашек")).findFirst().orElse(null);


        if(barashek != null){
            WebElement menuBarashek = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/barashek']"));
            menuBarashek.click();
        }





    }
}
