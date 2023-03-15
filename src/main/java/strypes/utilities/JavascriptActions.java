package strypes.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptActions {

	private WebDriver driver;

    public JavascriptActions(WebDriver driver) {
        this.driver = driver;
    }

	public void scrollIntoView(WebElement el) {
		((JavascriptExecutor) driver).executeScript("arguments[0].focus();", el);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", el);
	}

	public void clickWithJSExecutor(WebElement el) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
	}


}
