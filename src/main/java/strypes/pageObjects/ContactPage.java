package strypes.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import strypes.TestContext;

public class ContactPage {
	private TestContext testContext;

	@FindBy(xpath = "//input[@name='firstname']")
	public WebElement firstName;

	@FindBy(xpath = "//input[@name='lastname']")
	public WebElement lastName;

	@FindBy(xpath = "//input[@name='email']")
	public WebElement email;

	@FindBy(xpath = "//input[@name='company']")
	public WebElement company;

	@FindBy(xpath = "//textarea[@name='message']")
	public WebElement msg;

	@FindBy(xpath = "(//input[contains(@name, 'LEGAL_CONSENT') and @type='checkbox'])[1]")
	public WebElement termsCheckbox;

	@FindBy(xpath = "(//*[@value=\"SEND\"])[1]")
	public WebElement sendBtn;

	public ContactPage(TestContext testContext) {
		this.testContext = testContext;
		PageFactory.initElements(this.testContext.getDriver(), this);
	}

	public ContactPage fillFirstName(String name) {
		testContext.getWait().elementToBeVisible(firstName);
		firstName.clear();
		firstName.sendKeys(name);
		return this;
	}

	public ContactPage fillLastName(String name) {
		testContext.getWait().elementToBeVisible(lastName);
		lastName.clear();
		lastName.sendKeys(name);
		return this;
	}

	public ContactPage fillEmail(String emailStr) {
		testContext.getWait().elementToBeVisible(email);
		email.clear();
		email.sendKeys(emailStr);
		return this;
	}

	public ContactPage fillCompanyName(String compName) {
		testContext.getWait().elementToBeVisible(company);
		company.clear();
		company.sendKeys(compName);
		return this;
	}

	public ContactPage fillMessage(String msg) {
		testContext.getWait().elementToBeVisible(this.msg);
		this.msg.clear();
		this.msg.sendKeys(msg);
		return this;
	}

	public ContactPage agreeWithTerms() {
		testContext.getWait().elementToBeVisible(termsCheckbox);
		testContext.getJavascriptActions().scrollIntoView(termsCheckbox);
		testContext.getJavascriptActions().clickWithJSExecutor(termsCheckbox);
		return this;
	}

	public ContactPage clickSend() {
		testContext.getWait().elementToBeVisible(sendBtn);
		sendBtn.click();
		return this;
	}
}
