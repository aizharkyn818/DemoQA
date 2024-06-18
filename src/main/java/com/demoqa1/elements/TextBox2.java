package com.demoqa1.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class TextBox2 {

    WebDriver driver;

    @BeforeTest
    void startDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
    }

    @DataProvider
    public Object [][] textProvider(){
        return new Object[][]{
                {"Alua Erlan", "alua@gmail.com", "Bokonbayevo" ,"Karakol"},
//                {"Aidyn Muratbek", "aidyn@gmail.com", "Choktal" ,"Bishkek"},
//                {"Erlan Talantbek", "erlan@gmail.com", "Bokonbayevo" ,"Bishkek"},
//                {"Nafisat Volgan", "nafisat@gmail.com", "Ankara" ,"Karakol"},
        };
    }

    @Test(dataProvider = "textProvider")
    void testTextBox(String name, String email, String cAddress, String pAddress) throws InterruptedException {
        WebElement fullName = driver.findElement(By.xpath("//input[@placeholder ='Full Name']"));
        fullName.sendKeys(name);
        WebElement emailAddress= driver.findElement(By.xpath("//input[@type ='email']"));
        emailAddress.sendKeys(email);
        WebElement currentAddress = driver.findElement(By.xpath(" //textarea[@placeholder='Current Address']"));
        currentAddress.sendKeys(cAddress);
        WebElement permanentAddress = driver.findElement(By.xpath(" (//textarea[@class='form-control'])[2]"));
        permanentAddress.sendKeys(pAddress);
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();
        Thread.sleep(5000);

        WebElement  fullNameCheck = driver.findElement(By.xpath("//p[@id ='name']"));
        WebElement emailCheck = driver.findElement(By.xpath("//p[@class='mb-1'][2]"));
        WebElement currentAddressCheck = driver.findElement(By.xpath("//p[@id ='currentAddress']"));
        WebElement permanentAddressCheck = driver.findElement(By.xpath("//p[@id ='permanentAddress']"));

        Assert.assertTrue(fullNameCheck.getText().contains(name));
        Assert.assertTrue(emailCheck.getText().contains(email));
        Assert.assertTrue(currentAddressCheck.getText().contains(cAddress));
        Assert.assertTrue(permanentAddressCheck.getText().contains(pAddress));
    }

    @AfterTest
    void closeDriver(){
        if(driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
