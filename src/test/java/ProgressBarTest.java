import com.demoqa.drivers.DriverManager;
import com.demoqa.pages.DemoQAPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

// Aijan Kydybaeva version
public class ProgressBarTest extends BaseTest{
    @Test(description = "ariaValueNow")
    public void progressBarTest() throws InterruptedException {
        browserHelper.open("https://demoqa.com/progress-bar");
        webElementActions.click(demoQAPages.getProgressBarPage().startStopButton);

        String valueNow; // Создаем переменную для хранения текущего значения aria-valuenow
        while (true) { // Начало бесконечного цикла, пока не прервется с помощью break
            valueNow = demoQAPages.getProgressBarPage().ariaValueNow.getAttribute("aria-valuenow"); // Извлечение текущего значения aria-valuenow
            if (valueNow.equals("52")) { // Проверка
                webElementActions.click(demoQAPages.getProgressBarPage().startStopButton); // Остановка процесса в связи с выполнением условия выше
                break;
            }
        }

        Assert.assertEquals(valueNow, "52"); // Сравнение полученного значения с ожидаемым

    }

}


