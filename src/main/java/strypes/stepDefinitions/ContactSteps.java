package strypes.stepDefinitions;

import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import strypes.TestContext;
import strypes.pageObjects.ContactPage;

public class ContactSteps {

	private TestContext testContext;
	private ContactPage contactPage;

	public ContactSteps(TestContext testContext) {
		this.testContext = testContext;
		contactPage = new ContactPage(this.testContext);
	}

	@When("I input the following information")
	public void iInputTheFollowingInformation(DataTable table) {
		Map<String, String> tableInfo = table.asMaps(String.class, String.class).get(0);

		contactPage.fillFirstName(tableInfo.get("First name"))
				.fillLastName(tableInfo.get("Last name"))
				.fillEmail(tableInfo.get("Email"))
				.fillCompanyName(tableInfo.get("Company name"))
				.fillMessage(tableInfo.get("Message"))
				.agreeWithTerms()
				.clickSend();
	}

	@Then("The message should be send successfully")
	public void theMessageShouldBeSendSuccessfully() {
		By emailSendSuccessfully = By.xpath("//*[text()='Thank you for submitting the form.']");
		testContext.getWait().elementToBeVisible(emailSendSuccessfully);
		WebElement emailSendSuccessfullyEl = testContext.getDriver().findElement(emailSendSuccessfully);
		assertTrue("Notification for message sent is not present", emailSendSuccessfullyEl.isDisplayed());
	}

}
