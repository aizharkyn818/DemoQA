import com.demoqa.enums.Endpoints;
import com.demoqa.utils.ConfigReader;
import org.testng.annotations.Test;

public class MenuTest extends BaseTest{

    @Test(description = "Verify move to element method is working")
    public  void moveToElementTest() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseDevUrl") + Endpoints.MENU.getEndpoint());
        webElementActions.moveToElement(demoQAPages.getMenuPage().mainItem2);
        Thread.sleep(5000);

    }
}
