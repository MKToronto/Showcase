package qaworks;

/**
 * Created by Marc Kendal on 13/08/2015.
 */

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

/*
For reasons of time, a properties file hasn't been created
 */
public class QAWorks_Step_definitions extends QAWorksTestFixture {

    public static WebDriver driver = null;


    @Given("^I am on the QAWorks Site$")
    public void I_am_on_the_QAWorks_Site() throws Throwable {

        setChromeDriver();
        driver = getChromeDriver();
        driver.get("http://www.qaworks.com");
        // verify page title
        assertEquals("Home Page - QAWorks", driver.getTitle());
    }


    @Then("^I should be able to contact QAWorks with the following information$")
    public void I_should_be_able_to_contact_QAWorks_with_the_following_information(DataTable customerInfoTable) throws Throwable {

        // click on contact button
        driver.findElement(By.xpath("//*[@id=\"menu\"]/li[1]/a")).click();
        // verify page title
        assertEquals("Contact Us - QAWorks", driver.getTitle());
        //extract Customer Information
        extractCustomerInformation(customerInfoTable);
        // fill in information name.get etc
        fillInCustomerInformation(driver);
        // click send
        driver.findElement(By.id("ctl00_MainContent_SendButton")).click();


    }


    @And("^A confirmation message \"([^\"]*)\" is displayed$")
    public void A_confirmation_message_is_displayed(String expectedMessage) throws Throwable {
        String actualMessage = driver.findElement(By.id("confirmationMessage")).getText();
        assertEquals(actualMessage, expectedMessage);
    }
}
