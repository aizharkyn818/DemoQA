package com.demoqa1.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Namba {
    static WebDriver driver = new ChromeDriver();
  @BeforeTest
    void startDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15000));
        driver.manage().window().maximize();
        driver.get("https://nambafood.kg/");
    }


    @Test
    void nambaFoodTest(){
     WebElement foodIcon = driver.findElement(By.xpath("//a[@class='home--cat-item food']"));
     foodIcon.click();
     WebElement allCafes = driver.findElement(By.xpath("//a[text()='ВСЕ ЗАВЕДЕНИЯ']"));
     allCafes.click();
//      WebElement facilities = driver.findElement(By.id());
        selectFacility();
        showListOfFood();


    }
    public WebElement scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }
     void selectFacility(){
        List<WebElement> listOfFacilities = driver.findElements(By.xpath("//div[@class='cafe--name']"));
        boolean anyMatch = listOfFacilities.stream().anyMatch(f -> f.getText().equals("Zira"));
        if(anyMatch){
            WebElement selectedCafe = driver.findElement(By.xpath("//div[normalize-space(text())='Zira']/parent::div/parent::div"));
            selectedCafe.click();
        }
    }
    void showListOfFood(){
      List<WebElement> coldSnacks = driver.findElements(By.xpath("//*[@id='5009']/div//div[@class='card--item']//div[@class='card--item--title ']"));
        System.out.println("Холодные закуски");
        System.out.println("__________");
        coldSnacks.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);

        System.out.println("__________");


        List<WebElement>  salads = driver.findElements(By.xpath("//*[@id='14']/div//div[@class='card--item']//div[@class='card--item--title ']"));
        System.out.println("Салаты");
        System.out.println("__________");
        salads.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println("__________");


        List<WebElement> firstCourse = driver.findElements(By.xpath("//*[@id='19']/div//div[@class='card--item']//div[@class='card--item--title ']"));
        System.out.println("Первые блюда");
        System.out.println("__________");
        firstCourse.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println("__________");


        List<WebElement> hotDishes = driver.findElements(By.xpath("//*[@id='1002']/div//div[@class='card--item']//div[@class='card--item--title ']"));
        System.out.println("Горячие блюда");
        System.out.println("__________");
        hotDishes.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println("__________");


        List<WebElement> steaks = driver.findElements(By.xpath("//*[@id='2312']/div//div[@class='card--item']//div[@class='card--item--title ']"));
        System.out.println("Стейки");
        System.out.println("__________");
        steaks.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println("__________");


        List<WebElement> kebabs = driver.findElements(By.xpath("//*[@id='99']/div//div[@class='card--item']//div[@class='card--item--title ']"));
        System.out.println("Кебабы");
        System.out.println("__________");
        kebabs.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println("__________");


        List<WebElement> forACompany = driver.findElements(By.xpath("//*[@id='810']/div//div[@class='card--item']//div[@class='card--item--title ']"));
        System.out.println("Для компании");
        System.out.println("__________");
        forACompany.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println("__________");

        List<WebElement> pastries = driver.findElements(By.xpath("//*[@id='64']/div//div[@class='card--item']//div[@class='card--item--title ']"));
        System.out.println("Выпечка");
        System.out.println("__________");
        pastries.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println("__________");


        List<WebElement> garnishes = driver.findElements(By.xpath("//*[@id='42']/div//div[@class='card--item']//div[@class='card--item--title ']"));
        System.out.println("Гарниры");
        System.out.println("__________");
        garnishes.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
        System.out.println("__________");


        List<WebElement> desserts = driver.findElements(By.xpath("//*[@id='810']/div//div[@class='card--item']//div[@class='card--item--title ']"));
        System.out.println("Десерты");
        System.out.println("__________");
        desserts.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);



    }

    @AfterTest
    void finalizeBrowser(){
      if (driver != null){
          driver.close();
          driver.quit();
      }
    }




}
