package com.demoqa1.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class KoverSamolet {

    WebDriver driver = new ChromeDriver();

    @Test
    void koverSamoletTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15000));
        driver.manage().window().maximize();
        driver.get("https://dostavka312.kg/");

        WebElement edaIcon = driver.findElement(By.xpath("//img[@alt='edaG']"));
        edaIcon.click();

        WebElement koreanFood = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[1]/div/div[2]/div/p[4]/a"));
        koreanFood.click();

        WebElement menuIcon = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/koreana']"));
        menuIcon.click();

        WebElement addQuantityKimPab = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/article[2]/div/div/div[1]/div[5]/div/div[2]/form/span[2]/input[1]"));
        addQuantityKimPab.click();

        WebElement addButton = driver.findElement(By.xpath("//*[@id=\"WWMainPage\"]/div[1]/div[5]/div/div[2]/form/button"));
        addButton.click();

        WebElement addRulet = driver.findElement(By.xpath("//*[@id=\"WWMainPage\"]/div[1]/div[7]/div/div[2]/form/button"));
        addRulet.click();

        driver.get("https://dostavka312.kg/cart");

        WebElement name =  driver.findElement(By.xpath("//input[@name='name']"));
        name.sendKeys("Damla");

        WebElement address = driver.findElement(By.xpath("//input[@placeholder='Адрес']"));
        address.sendKeys("Кирпичная 68");

        WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='phone'][1]"));
        phoneNumber.sendKeys("451671");

        WebElement change = driver.findElement(By.xpath("//input[@placeholder='Сдача с']"));
        change.sendKeys("200000");


        WebElement comments = driver.findElement(By.xpath("//textarea[@name='comment']"));
        comments.sendKeys("hungry as a wolf");

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"form_cart\"]/button[1]"));
        submitButton.click();


        WebElement confirmMessage = driver.findElement(By.xpath(" //h2[text()='Благодарим Вас за заказ! Для подтверждения заказа в течение 5 минут с Вами свяжется оператор.']"));
        String message = "Благодарим Вас за заказ! Для подтверждения заказа в течение 5 минут с Вами свяжется оператор.";

        Assert.assertEquals(confirmMessage.getText(), message);
        Thread.sleep(10000);
        driver.close();
        driver.quit();









    }
}
