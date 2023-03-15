package strypes.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import strypes.TestContext;
import strypes.utilities.JavascriptActions;

public class CareersPage {

	@FindBy(xpath = "//*[@class='page-numbers next']")
	public WebElement nextPage;

	@FindBy(xpath = "//*[text()='Apply now']/ancestor::*[@role='button']")
	public WebElement applyNowBtn;

	public String roleStrLoc = "//*[text()='%s']";
	public String roleStrLocViewBtn = "(//*[text()='%s']//ancestor::article)[2]//*[@role='button']";

	private TestContext testContext;

	public CareersPage(TestContext testContext) {
		this.testContext = testContext;
		PageFactory.initElements(this.testContext.getDriver(), this);
	}

	public CareersPage clickOnNextPage() {
		testContext.getWait().elementToBeClickable(nextPage);
		testContext.getJavascriptActions().scrollIntoView(nextPage);
		testContext.getJavascriptActions().clickWithJSExecutor(nextPage);
		return this;
	}

	public CareersPage viewPosition(String positionName) {
		WebElement positionViewBtnEl = testContext.getDriver().findElement(
				By.xpath(testContext.getLocatorBuilder().build(roleStrLocViewBtn, positionName)));
		testContext.getWait().elementToBeVisible(positionViewBtnEl);
		testContext.getJavascriptActions().scrollIntoView(positionViewBtnEl);
		testContext.getJavascriptActions().clickWithJSExecutor(positionViewBtnEl);
		return this;
	}

	public CareersPage iClickApplyNow() {
		testContext.getWait().elementToBeVisible(applyNowBtn);
		testContext.getJavascriptActions().scrollIntoView(applyNowBtn);
		testContext.getJavascriptActions().clickWithJSExecutor(applyNowBtn);
		return this;
	}

}
