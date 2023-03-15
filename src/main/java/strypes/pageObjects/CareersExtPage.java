package strypes.pageObjects;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import strypes.TestContext;

public class CareersExtPage {

	@FindBy(xpath = "//input[@name='387809']")
	public WebElement nameInput;

	@FindBy(xpath = "//input[@name='387810']")
	public WebElement emailInput;

	@FindBy(xpath = "//input[@name='387811']")
	public WebElement phoneInput;

	@FindBy(xpath = "//input[@name='387813']")
	public WebElement resumeInput;

	@FindBy(xpath = "//input[@name='441965']")
	public WebElement termsCheckbox;

	@FindBy(xpath = "//button[contains(text(), 'Submit your application')]")
	public WebElement applyButton;


	private TestContext testContext;

	public CareersExtPage(TestContext testContext) {
		this.testContext = testContext;
		PageFactory.initElements(this.testContext.getDriver(), this);
	}

	public CareersExtPage fillName(String name) {
		testContext.getWait().elementToBeVisible(nameInput);
		nameInput.clear();
		nameInput.sendKeys(name);
		return this;
	}

	public CareersExtPage fillEmail(String mail) {
		testContext.getWait().elementToBeVisible(emailInput);
		emailInput.clear();
		emailInput.sendKeys(mail);
		return this;
	}

	public CareersExtPage fillPhone(String phone) {
		testContext.getWait().elementToBeVisible(phoneInput);
		phoneInput.clear();
		phoneInput.sendKeys(phone);
		return this;
	}

	public CareersExtPage chooseResume() {
		testContext.getWait().elementToBeVisible(resumeInput);
		resumeInput.clear();
		resumeInput.sendKeys(new File(
				"src/main/resources/example-resume.txt").getAbsolutePath());
		return this;
	}

	public CareersExtPage agreeWithTerms() {
		testContext.getWait().elementToBeVisible(termsCheckbox);
		termsCheckbox.click();
		return this;
	}

/*	public CareersExtPage iClickSubmit() {
		testContext.getWait().elementToBeVisible(applyButton);
		applyButton.click();
		return this;
	}*/

}
