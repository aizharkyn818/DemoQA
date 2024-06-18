package com.demoqa1.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.time.Duration;

public class TextBox {

WebDriver driver;

    @BeforeClass
    public void driverProvider(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe"); //shows which driver we are going to use
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().fullscreen();
        driver.get("https://demoqa.com/text-box");
    }


    @Test(priority = 1)
    void fullNameBoxTest() throws InterruptedException {

        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Alua Erlan");
        Thread.sleep(10000);
    }

    @Test(priority = 2)
    void emailBoxTest2() throws InterruptedException {
        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("aizharkyn23@gmail.com");
        Thread.sleep(10000);


    }

    @Test(priority = 3)
    void currentAddressBoxTest() throws InterruptedException {
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Bazarova 41");
        Thread.sleep(10000);


    }

    @Test(priority = 4)
    void permanentAddressBoxTest() throws InterruptedException {
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Gebze 140");
        Thread.sleep(10000);


    }

    @Test(priority = 5)
    void submitButtonTest() throws InterruptedException {

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        Thread.sleep(10000);
         // либо используем Actions для прокрутки до элемента submitButton вместо джаваскрипта
//            Actions actions = new Actions(driver);
//            actions.moveToElement(submitButton);
            // Выполняем действие
//            actions.perform();


    }

    @AfterClass
    public void closeDriver(){

        driver.close();
        driver.quit();
    }
}
