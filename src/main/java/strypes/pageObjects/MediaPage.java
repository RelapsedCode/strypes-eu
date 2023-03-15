package strypes.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import strypes.TestContext;

public class MediaPage {

	@FindBy(xpath = "(//*[@class='facetwp-dropdown'])[1]")
	public WebElement selectTypeOfPost;

	@FindBy(xpath = "//*[@data-name='filter_by_post']")
	public WebElement filterByPost;


	private TestContext testContext;

	public MediaPage(TestContext testContext) {
		this.testContext = testContext;
		PageFactory.initElements(this.testContext.getDriver(), this);
	}

	public MediaPage selectPostType (String type) {
		testContext.getWait().elementToBeVisible(selectTypeOfPost);
		new Select(selectTypeOfPost).selectByValue(type.toLowerCase());

		while (true) {
			if (!(filterByPost.getAttribute("class").equals("facetwp-facet facetwp-facet-filter_by_post facetwp-type-dropdown is-loading"))) {
				break;
			}
		}

		return this;
	}

}
