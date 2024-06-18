import com.demoqa.drivers.DriverManager;
import com.demoqa.helper.*;
import com.demoqa.pages.*;
import com.demoqa.utils.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.sql.Driver;

public class BaseTest {

    protected WebDriver driver;

    protected RandomUtils randomUtils;
    protected WebElementActions webElementActions;
    protected AlertHelper alertHelper;
    protected BrowserHelper browserHelper;
    protected  DemoQAPages demoQAPages;
    protected DropdownHelper dropdownHelper;
    protected IframeHelper iframeHelper;




    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = DriverManager.getDriver();
        webElementActions = new WebElementActions();
        alertHelper = new AlertHelper(driver);
        browserHelper = new BrowserHelper(driver);
        randomUtils = new RandomUtils();
        dropdownHelper = new DropdownHelper(driver);
        demoQAPages = new DemoQAPages();
        iframeHelper = new IframeHelper(driver);
        demoQAPages.setUp();

    ;
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        DriverManager.closeDriver();
    }
}
