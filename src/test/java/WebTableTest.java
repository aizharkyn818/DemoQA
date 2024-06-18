import com.demoqa.entities.Employee;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebTableTest extends  BaseTest{

    @Test(description = "WebTable form test")
    public void test123(){
        driver.get("https://demoqa.com/webtables");
        Employee employee = randomUtils.createMockEmployee();
        demoQAPages.getWebTable().addNewEmployee(employee);

        List<Employee> employees = demoQAPages.getWebTable().getEmployeesFromTable();
        for(Employee employee1 : employees){
            System.out.println(employee1);
        }
    }
    @Test
    public  void  test1234() throws InterruptedException {
        driver.get("https://demoqa.com/webtables");
        Thread.sleep(5);
        demoQAPages.getWebTable().deleteByEmail("cierra@example.com");
        Thread.sleep(10);
    }

    @Test(description = "verify updates")
    public void editValuesTest() {
        driver.get("https://demoqa.com/webtables");
        demoQAPages.getWebTable().editEmployeeData("cierra@example.com", "age", "34");
        List<Employee> employees = demoQAPages.getWebTable().getEmployeesFromTable();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }




}
