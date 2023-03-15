package strypes.utilities;

public class LocatorBuilder {

	public String build(String locator, String... params) {
		return String.format(locator, params);
	}
}
