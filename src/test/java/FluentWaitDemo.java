import com.demoqa.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;


public class FluentWaitDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://exmplae.com");
            Wait<WebDriver> wait = new FluentWait<>(DriverManager.getDriver())
                    .withTimeout(Duration.ofSeconds(20))  // максимальное время ожидания
                    .pollingEvery(Duration.ofSeconds(2))  // частота проверки условия
                    .ignoring(NoSuchElementException.class);  // игнорируемое исключение

            WebElement element = wait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(By.id("someId"));
                }
            });
            element.click();
        } finally {
            driver.quit();
        }
    }
}
