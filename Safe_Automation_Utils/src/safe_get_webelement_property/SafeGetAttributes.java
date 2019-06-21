package safe_automation_utils.safe_get_webelement_property;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import safe_automation_utils.safe_utils.HelperUtils;

/**
 * 
 * @author Arthur Reynolds
 * created: 05/31/2019
 * updated: 06/10/2019
 * 
 * Contains methods that provide a safe way to get WebElement's Attribute's values.
 * A list of usual attribute value names are stored in the constants folder of this library.
 * 
 * All methods in this class are static.
 */

public final class SafeGetAttributes {

	/**
	 * Attempts to retrieve the String value of the passed in attribute name for the passed in WebElement
	 * object. If the WebElement object is null or if the attr String object is null or blank then
	 * null is returned. If an exception occurs during the process then null will be returned. If
	 * the attribute is found successfully the String value of that attribute will be returned.
	 * @param element -> WebElement
	 * @param attr -> String
	 * @return -> String
	 */
	public static String safeGetAttribute(WebElement element, String attr) {
		if(element==null || attr.isEmpty())
			return null;
		try {
			return element.getAttribute(attr);
		}catch(Exception ex) {
			return null;
		}
	}
	
	/**
	 * Attempts to retrieve the String value of the passed in attribute name for the WebElement that
	 * matches the passed in source String value. If the WebDriver is null or if the source String object
	 * or sourceType String object are null or blank then null is returned. If an exception occurs 
	 * during the process then null is returned. If the attribute is retrieved successfully then the
	 * String value for the attribute will be returned.
	 * @param driver -> WebDriver
	 * @param source -> String
	 * @param sourceType -> String
	 * @param attr -> String
	 * @return -> String
	 */
	public static String safeGetAttributeByString(WebDriver driver, String source, String sourceType,
			String attr) {
		if(driver==null || source.isEmpty() || sourceType.isEmpty())
			return null;
		try {
			WebElement sourceElement = HelperUtils.locateWebElement(driver, source, sourceType);
			return safeGetAttribute(sourceElement, attr);
		}catch(Exception ex) {
			return null;
		}
	}
}