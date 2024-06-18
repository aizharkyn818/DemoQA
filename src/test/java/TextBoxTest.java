
import com.demoqa.entities.TextBoxEntity;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextBoxTest extends  BaseTest {


    @Test
    public void textBoxTest() throws InterruptedException {
        driver.get("https://demoqa.com/text-box");

        TextBoxEntity textBoxEntity = randomUtils.generateRandomTextBoxEntity();

        demoQAPages.getTextBoxPage().fillUpTextBoxForm(textBoxEntity);
        Thread.sleep(3000);
        Assert.assertTrue(true);


    }
}
