package strypes.utilities;

import java.util.Objects;
import java.util.Optional;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static WebDriver driver;

	private WebDriver setDriver() {
		String browser = "firefox";

		switch (browser.toLowerCase()) {

			case "chrome":
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incognito");
				options.addArguments("--remote-allow-origins=*");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;

			case "firefox":
				FirefoxOptions firFOptions = new FirefoxOptions();
				firFOptions.addArguments("-private");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(firFOptions);
				break;
		}
		return driver;
	}

	public WebDriver getDriver() {
		return Optional.ofNullable(driver).orElse(setDriver());
	}

}
