import com.demoqa.enums.Endpoints;
import com.demoqa.utils.ConfigReader;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FrameTest extends  BaseTest{
    @Test
    public  void test123(){
        browserHelper.open(ConfigReader.getValue("baseUrl") + Endpoints.FRAMES.getEndpoint());
        iframeHelper.switchToFrame("frame1");
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        iframeHelper.switchToParentFrame();
        System.out.println(driver.findElement(By.tagName("h1")).getText());


    }
}
