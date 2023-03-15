package strypes.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import strypes.TestContext;
import strypes.pageObjects.HomePage;

public class HomeSteps {

	private TestContext testContext;
	private HomePage homePage;

	public HomeSteps(TestContext testContext) {
		this.testContext = testContext;
		homePage = new HomePage(this.testContext);
	}

	@Given("I load {string} page")
	public void iNavigateToPage(String page) {
		switch (page) {
			case "Home":
				testContext.getDriver().get("https://strypes.eu/");
				break;
			case "Careers":
				testContext.getDriver().get("https://strypes.eu/careers");
				break;
			case "Contact":
				testContext.getDriver().get("https://strypes.eu/contact/");
				break;
			case "Media":
				testContext.getDriver().get("https://strypes.eu/media/");
				break;
			default:
				throw new RuntimeException("No page specified.");
		}
	}

	@When("I search for {string} term")
	public void iSearchForTerm(String term) {
		homePage.searchForTerm(term);
	}

}
