package qaworks;

import cucumber.api.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Map;

/**
 * Created by Marc Kendal on 13/08/2015.
 */
public class QAWorksTestFixture {

    private String name = null;
    private String email = null;
    private String message = null;

    /**
     * Method to extract customer information strings from DataTable customerInfoTable
     *
     * @param customerInfoTable
     */

    public void extractCustomerInformation(DataTable customerInfoTable) {

        Map<String, String> customerInfoMap = customerInfoTable.asMap(String.class, String.class);
        this.name = customerInfoMap.get("name");
        this.email = customerInfoMap.get("email");
        this.message = customerInfoMap.get("message");

    }

    /**
     * Fills in Customer Information, name, email and message string in the correct fields on the Contact us web page
     * using selenium webdriver
     *
     * @param driver
     */

    public void fillInCustomerInformation(WebDriver driver) {

        WebElement nameBox = driver.findElement(By.id("ctl00_MainContent_NameBox"));
        nameBox.sendKeys(this.name);
        WebElement emailBox = driver.findElement(By.id("ctl00_MainContent_EmailBox"));
        emailBox.sendKeys(this.email);
        WebElement messageBox = driver.findElement(By.id("ctl00_MainContent_MessageBox"));
        messageBox.sendKeys(this.message);
    }

    /**
     * Sets the default webdriver Environment variable as a chrome driver, given by the file path
     */
    public void setChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
    }

    /**
     * Creates a new instance of Chrome Driver to run the test on
     */
    public WebDriver getChromeDriver() {

        WebDriver driver = new ChromeDriver();
        return driver;
    }


}

