import com.demoqa.enums.Endpoints;
import com.demoqa.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonsTest extends  BaseTest{

    @Test(description = "Verify double click  button is working properly")
    public void doubleClickTest(){
        driver.get("https://demoqa.com/buttons");
        webElementActions.doubleClick(demoQAPages.getButtonsPage().doubleClickBtn);
        Assert.assertEquals(demoQAPages.getButtonsPage().doubleClickMessage.getText(), "You have done a double click");
    }

    @Test(description = "Verify right click  button is working properly")
    public void rightClickTest(){
        driver.get("https://demoqa.com/buttons");
        webElementActions.rightClick(demoQAPages.getButtonsPage().rightClickBtn);
        Assert.assertEquals(demoQAPages.getButtonsPage().rightClickMessage.getText(), "You have done a right click");
    }


}
