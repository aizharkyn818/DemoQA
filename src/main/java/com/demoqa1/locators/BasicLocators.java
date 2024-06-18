package com.demoqa1.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class BasicLocators {
    WebDriver driver;

    @Test(description = "Find by ID")
    void findByIdTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe"); //shows which driver we are going to use
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().fullscreen();
        driver.get("https://demoqa.com/text-box");


        WebElement fullNameInput = driver.findElement(By.id("userName"));
        fullNameInput.sendKeys("John Doe");
//
//        WebElement emailInput =driver.findElement(By.className("userEmail"));
//        emailInput.sendKeys("qerty@qaz.com");
//
//        WebElement emailInput2 =driver.findElement(By.tagName("input"));
//        emailInput2.sendKeys("qerty@qaz.com");
//
//        String textBoxText= driver.findElement(By.tagName("h1")).getText();
//        System.out.println(textBoxText);
    }

    @Test
    void findByLinkText() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe"); //shows which driver we are going to use
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().fullscreen();
        driver.get("https://demoqa.com/links");

//        WebElement homelink = driver.findElement(By.linkText("Home"));
//        homelink.click();

        WebElement notFound = driver.findElement(By.partialLinkText("Not"));
        notFound.click();
    }

      @Test(description = "absolute path") // not used in real projects
    void findByXPath(){
          System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe"); //shows which driver we are going to use
          driver = new ChromeDriver();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
          driver.manage().window().fullscreen();
          driver.get("https://demoqa.com/text-box");

          WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[2]/div[2]/input"));
          element.sendKeys("erlan");
      }

    @Test(description = "relative path")
    void findByXPathRelative(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe"); //shows which driver we are going to use
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().fullscreen();
        driver.get("https://demoqa.com/text-box");

        WebElement element = driver.findElement(By.xpath("//textarea[@placeholder='Current Address']"));
        element.sendKeys("erlan");
    }


}
