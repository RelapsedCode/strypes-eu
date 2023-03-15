package strypes.stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import strypes.TestContext;
import strypes.pageObjects.MediaPage;

public class MediaSteps {

	private TestContext testContext;
	private MediaPage mediaPage;

	public MediaSteps(TestContext testContext) {
		this.testContext = testContext;
		mediaPage = new MediaPage(this.testContext);
	}

	@When("I select the {string} post type")
	public void iSelectThePostType(String postType) {
		mediaPage.selectPostType(postType);
	}

	@Then("All displayed publication should be from type {string}")
	public void allDisplayedPublicationShouldBeFromType(String postType) {
		By postTypeLoc = By.xpath("//*[@class=\"elementor-post-info__terms-list-item\"]");
		testContext.getWait().elementToBeVisible(postTypeLoc);
		int postsPerPage = 8;
		int numOfValidPosts = 0;
		List<WebElement> posts = testContext.getDriver().findElements(postTypeLoc);
		for (WebElement postEl : posts) {
			if (postEl.getText().equals(postType)) {
				numOfValidPosts++;
			}
		}
		assertEquals("Not all posts are from type: " + postType, numOfValidPosts, postsPerPage);
	}

}
