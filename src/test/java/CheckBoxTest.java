import com.demoqa.enums.Endpoints;
import com.demoqa.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTest extends  BaseTest{

    public void checkSuccessMessage(String expectedText) {
        WebElement textSuccess = driver.findElement(By.xpath("//div[@id='result']"));
        Assert.assertEquals(textSuccess.getText(), expectedText, "Did not match!");
    }



    @Test
    public void testHomeWithoutSelection() {
        browserHelper.open(ConfigReader.getValue("baseUrl") + Endpoints.CHECKBOX.getEndpoint());
        driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
        driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[1]")).click();
        driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[1]")).click();
        WebElement homeWithoutAnySelections = driver.findElement(By.xpath("//span[@class='rct-title']"));
        Assert.assertTrue(homeWithoutAnySelections.isDisplayed());
    }

    @Test
    void testCheckBox() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseUrl") + Endpoints.CHECKBOX.getEndpoint());



        WebElement mainToggle = driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/span/button"));
//        scrollToElement(driver, mainToggle);
        mainToggle.click();

        WebElement desktopToggle = driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/ol/li[1]/span/button"));
//        scrollToElement(driver, desktopToggle);
        desktopToggle.click();

        WebElement notesCheckBox = driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/ol/li[1]/ol/li[1]/span/label/span[1]"));
        webElementActions.click(notesCheckBox);
        WebElement textSuccess = driver.findElement(By.cssSelector("span.text-success"));
        Assert.assertEquals(textSuccess.getText(), "notes", " did not match the expected value 'notes'");

        WebElement commandsCheckbox = driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/ol/li[1]/ol/li[2]/span/label/span[1]"));
        webElementActions.click(commandsCheckbox);
        checkSuccessMessage("You have selected :\n" +
                "desktop\n" +
                "notes\n" +
                "commands");

        WebElement documentsToggle = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button"));
        webElementActions.click(documentsToggle);

        WebElement workSpaceToggle = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/span/button"));
        webElementActions.click(workSpaceToggle);

        WebElement reactCheckbox = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/ol/li[1]/span/label/span[1]"));
        webElementActions.click(reactCheckbox);

        checkSuccessMessage("You have selected :\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "react");


        WebElement angularCheckBox = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/ol/li[2]/span/label/span[1]"));
        webElementActions.click(angularCheckBox);

        checkSuccessMessage("You have selected :\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "react\n" +
                "angular");


        WebElement veuCheckBox = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/ol/li[3]/span/label/span[1]"));
        webElementActions.click(veuCheckBox);

        checkSuccessMessage("You have selected :\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu");

        WebElement officeToggle = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/span/button"));
        webElementActions.click(officeToggle);

        WebElement publicCheckBox = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/ol/li[1]/span/label/span[1]"));
        webElementActions.click(publicCheckBox);

        checkSuccessMessage("You have selected :\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "public");


        WebElement privateCheckBox = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/ol/li[2]/span/label/span[1]"));
        webElementActions.click(privateCheckBox);

        checkSuccessMessage("You have selected :\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "public\n" +
                "private");


        WebElement classifiedCheckBox = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/ol/li[3]/span/label/span[1]"));
        webElementActions.click(classifiedCheckBox);
        checkSuccessMessage("You have selected :\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "public\n" +
                "private\n" +
                "classified");

        WebElement generalCheckBox = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/ol/li[4]/span/label/span[1]"));
        webElementActions.click(generalCheckBox);
        checkSuccessMessage("You have selected :\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "documents\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general");

        WebElement downloadsToggle = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/button"));
        webElementActions.click(downloadsToggle);

        WebElement wordFileCheckBox = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/ol/li[1]/span/label/span[1]"));
        webElementActions.click(wordFileCheckBox);

        checkSuccessMessage("You have selected :\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "documents\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general\n" +
                "wordFile");

        WebElement excelFileCheckBox = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/ol/li[2]/span/label/span[1]"));
        webElementActions.click(excelFileCheckBox);
        checkSuccessMessage("You have selected :\n" +
                "home\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "documents\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general\n" +
                "downloads\n" +
                "wordFile\n" +
                "excelFile");

        Thread.sleep(10000);

    }
}
