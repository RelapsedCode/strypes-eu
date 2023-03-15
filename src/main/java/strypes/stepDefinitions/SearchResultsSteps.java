package strypes.stepDefinitions;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import strypes.TestContext;
import strypes.pageObjects.SearchResultsPage;

@Slf4j
public class SearchResultsSteps {

	TestContext testContext;
	SearchResultsPage searchResultsPage;

	public SearchResultsSteps(TestContext testContext) {
		this.testContext = testContext;
		searchResultsPage = new SearchResultsPage(this.testContext);
	}

	@Then("The displayed results should contains {string} term")
	public void theDisplayedResultsShouldContainsTerm(String searchTerm) {
		testContext.getWait().elementToBeVisible(By.xpath("//*[contains(text(), 'Results for:')]"));
		int resultsCounter = 0;
		if (!(searchResultsPage.searchResultTitle.isEmpty())) {
			for (WebElement foundElTitle : searchResultsPage.searchResultTitle) {
				if (foundElTitle.getText().contains(searchTerm)) {
					resultsCounter++;
				}
			}
			log.info("Found results: " + resultsCounter);
			assertTrue("None of the found title matches the searched term",
					resultsCounter != 0);
		} else {
			fail("No results present.");
		}
	}

}
