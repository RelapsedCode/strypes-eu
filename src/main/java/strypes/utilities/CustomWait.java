package strypes.utilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWait {

    private WebDriverWait wait;

    public CustomWait(WebDriverWait wait) {
        this.wait = wait;
    }

    public void elementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void elementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void elementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void elementToDisappear(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public Boolean isElementPresent(By locator, int waitTimeInMilliseconds) {
        WebDriver driver = new DriverFactory().getDriver();
        long waitUntil = System.currentTimeMillis() + waitTimeInMilliseconds;
        while (System.currentTimeMillis() < waitUntil) {
            List<WebElement> el = driver.findElements(locator);
            if (!el.isEmpty()) {
                return true;
            }
            driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        }
        return false;
    }
}
