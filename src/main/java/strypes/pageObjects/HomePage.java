package strypes.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import strypes.TestContext;

public class HomePage {

	private TestContext testContext;

	@FindBy(xpath = "(//*[@href='/careers'])[1]")
	public WebElement careersNav;

	@FindBy(xpath = "(//*[text()='Search']/..)[1]")
	public WebElement searchBtn;

	@FindBy(xpath = "(//*[@placeholder='Search...'])[1]")
	public WebElement searchInput;

	public HomePage(TestContext testContext) {
		this.testContext = testContext;
		PageFactory.initElements(this.testContext.getDriver(), this);
	}

	public HomePage searchForTerm(String term) {
		testContext.getWait().elementToBeVisible(searchBtn);
		searchBtn.click();
		testContext.getWait().elementToBeVisible(searchInput);
		searchInput.clear();
		searchInput.sendKeys(term);
		searchInput.sendKeys(Keys.ENTER);
		return this;
	}

}
