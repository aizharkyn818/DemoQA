package com.demoqa1.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitsDemo {



    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        System.setProperty("wedriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15000)); // implicit wait
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/dynamic-properties");



        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter"))).click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.attributeToBe(By.id("colorChange"), "class" ,"mt-4 text-danger btn btn-primary"));
        String classValue = driver.findElement( By.id("colorChange")).getAttribute("class");
        System.out.println(classValue);


        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        driver.findElement((By.id("visibleAfter")));


    }

}
