package strypes.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import strypes.TestContext;

public class SearchResultsPage {
	private TestContext testContext;

	@FindBy(xpath = "//h3[@class='elementor-post__title']")
	public List<WebElement> searchResultTitle;

	public SearchResultsPage(TestContext testContext) {
		this.testContext = testContext;
		PageFactory.initElements(this.testContext.getDriver(), this);
	}

}
