package com.demoqa.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


import java.time.Duration;

public class EdgeWebDriver {
    public static WebDriver loadEdgeWebDriver() {
//        System.setProperty("webdriver.edge.driver", "src/main/resources/drivers/msedgedriver.exe"); //shows which driver we are going to use
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
}
