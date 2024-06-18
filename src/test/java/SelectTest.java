import com.demoqa.helper.DropdownHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SelectTest extends  BaseTest {

    @Test
    void test123() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");
        WebElement selectMenu = driver.findElement(By.id("oldSelectMenu"));

        DropdownHelper dropdownHelper = new DropdownHelper(driver);
        dropdownHelper.selectByVisibleText(selectMenu, "Green");
        Thread.sleep(4000);
    }

    @Test
    void testOldStyleSelectMenu() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");
        Thread.sleep(3000);
        dropdownHelper.selectByVisibleText(demoQAPages.getSelectMenu().selectMenu, "Indigo");
        //        demoQAPages.getSelectMenu().menuListSelect();
//        Thread.sleep(10000);
//        demoQAPages.getSelectMenu().selectOne();
//       Thread.sleep(3000);
    }

    @Test
    void test1(){
        driver.get("https://demoqa.com/select-menu");
        dropdownHelper.printOptions(demoQAPages.getSelectMenu().selectValueDropdown, demoQAPages.getSelectMenu().selectValueOptions);
    }

    @Test
    void test2(){
        driver.get("https://demoqa.com/select-menu");
        List<String> multiSelectDropDownOptions = dropdownHelper.getAllOptions(demoQAPages.getSelectMenu().multiSelectDropdown, " //*[@class=' css-26l3qy-menu']");
        System.out.println(multiSelectDropDownOptions);
    }

    @Test
    void test3(){
        driver.get("https://demoqa.com/select-menu");
        List<String> selectOneValueOptions = dropdownHelper.getAllOptions(demoQAPages.getSelectMenu().selectOneDropdown, "//div[contains(@class, 'option')]");
        System.out.println(selectOneValueOptions);
    }


}
