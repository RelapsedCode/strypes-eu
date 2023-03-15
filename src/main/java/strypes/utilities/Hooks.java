package strypes.utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import strypes.TestContext;

public class Hooks {

	private TestContext testContext;

	public Hooks(TestContext testContext) {
		this.testContext = testContext;
	}

	@Before
	public void setUp() {
		testContext.getDriver().manage().window().maximize();
	}

	@After
	public void tearDown() {
		testContext.getDriver().close();
	}

}
