import com.demoqa.enums.Endpoints;
import com.demoqa.utils.ConfigReader;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;

import static com.demoqa.enums.Endpoints.ALERT;

public class AlertTest extends BaseTest {
    //Allure annotations
    @Test(groups = {"Smoke", "UI", "1721"}, description = "AlertTest")
    @Description("Verify that alert is present")
    @Owner("Aizharkyn")
    @Tag("Smoke")
    @Severity(SeverityLevel.CRITICAL)
    @Story("GCPINT -8877")
    @Epic("Registration")
    void alertTest() {
        browserHelper.open(ConfigReader.getValue("baseDevUrl") + ALERT.getEndpoint());
        webElementActions.click(demoQAPages.getAlertPage().confirmAlertBtn);
        alertHelper.acceptAlert();
        webElementActions.pause(5000);
    }

    @Test(groups = {"Regression", "API", "1722"}, description = "AlertTest1")
    void alertTest1(){
        driver.get(("https://demoqa.com/alerts"));
        webElementActions.click(demoQAPages.getAlertPage().confirmAlertBtn);
        alertHelper.acceptAlert();

    }
}
