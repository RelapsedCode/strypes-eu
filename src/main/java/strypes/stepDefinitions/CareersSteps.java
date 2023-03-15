package strypes.stepDefinitions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import strypes.TestContext;
import strypes.pageObjects.CareersExtPage;
import strypes.pageObjects.CareersPage;

public class CareersSteps {

	private TestContext testContext;
	private CareersPage careersPage;
	private CareersExtPage careersExtPage;

	public CareersSteps(TestContext testContext) {
		this.testContext = testContext;
		careersPage = new CareersPage(this.testContext);
		careersExtPage = new CareersExtPage(this.testContext);
	}

	@Then("The following job titles should be present")
	public void theFollowingJobTitlesShouldBePresent(DataTable roles) {
		List<String> rolesList = roles.asList();
		testContext.getWait().elementToBeVisible(By.xpath("//*[@class='facetwp-dropdown']"));
		int maxPages = Integer.parseInt(testContext.getElement(By.xpath("//*[@class='page-numbers']")).getText());
		int currentPage = 1;
		By roleLoc;
		for (String role : rolesList) {
			roleLoc = By.xpath(testContext.getLocatorBuilder().build(careersPage.roleStrLoc, role));
			while (currentPage <= maxPages) {
				if (testContext.getWait().isElementPresent(roleLoc, 3000)) {
					assertTrue("Position is not found.", testContext.getElement(By.xpath(
									testContext.getLocatorBuilder().build(careersPage.roleStrLoc, role)))
							.isDisplayed());
					break;
				} else if (currentPage == maxPages) {
					fail("Last page reached. Position not found.");
					break;
				}
				currentPage++;
				careersPage.clickOnNextPage();
			}
		}

	}

	@When("I view {string} position")
	public void iViewPosition(String positionName) {
		careersPage.viewPosition(positionName)
				.iClickApplyNow();
	}

	@Then("I should be able to apply for the selected position")
	public void iShouldBeAbleToApplyForTheSelectedPosition() {
		ArrayList<String> driverTabs = new ArrayList<String>(testContext.getDriver().getWindowHandles());
		testContext.getDriver().switchTo().window(driverTabs.get(1));
		careersExtPage.fillName(testContext.getFaker().name().fullName())
				.fillEmail(testContext.getFaker().internet().emailAddress())
				.fillPhone(testContext.getFaker().phoneNumber().cellPhone())
				.chooseResume()
				.agreeWithTerms();
	}

}
