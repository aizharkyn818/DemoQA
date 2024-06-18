package com.demoqa1.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TextBoxButton {

    WebDriver driver;

    @BeforeMethod
    public void OpenWeb() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

//    @AfterMethod
//    public void CloseWeb() {
//        driver.quit();
//    }


    @Test
    void TextBoxAuto() throws InterruptedException {

        driver.get("https://demoqa.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement TextBoxElements = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='card mt-4 top-card'][1]")));
        actions.moveToElement(TextBoxElements).click().perform();
        Thread.sleep(5000);

        WebElement ClickCheckBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Check Box']")));
        actions.moveToElement(ClickCheckBox).click().perform();
        Thread.sleep(5000);

        WebElement ClickArrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='rct-collapse rct-collapse-btn']")));
        actions.moveToElement(ClickArrow).click().perform();
        Thread.sleep(5000);

        WebElement ClickSquare = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='rct-checkbox']")));
        actions.moveToElement(ClickSquare).click().perform();
        Thread.sleep(10000);

    }
}









