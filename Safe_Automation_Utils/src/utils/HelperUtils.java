package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import constants.Locator_Type_Constants;
import safe_get_webelement.SafeGetByCSSSelector;
import safe_get_webelement.SafeGetByClassName;
import safe_get_webelement.SafeGetByID;
import safe_get_webelement.SafeGetByXPath;

/**
 * 
 * @author Arthur Reynolds
 * created: 06/10/2019
 * updated: 06/10/2019
 * 
 * Contains common helper methods used throughout the library.
 * 
 * All methods in this class are static.
 */

public final class HelperUtils {

	/**
	 * Attempts to locate the WebElement that matches the source String value based on using the locator
	 * that matches the sourceType String value. If the WebDriver object is null or if the source String
	 * object or the sourceType String object is null or blank then null is returned. If an exception occurs
	 * during the process the null is returned. If the WebElement is located successfully then it is returned.
	 * The different types of locators that can be passed in for use are located in the Locator_Type_Constants.java
	 * file.
	 * @param driver -> WebDriver
	 * @param source -> String
	 * @param sourceType -> String
	 * @return -> WebElement
	 */
	public static WebElement locateWebElement(WebDriver driver, String source, String sourceType) {
		if(driver==null || source.isEmpty() || sourceType.isEmpty())
			return null;
		WebElement sourceElement = null;
		switch(sourceType) {
			case Locator_Type_Constants.XPATH:
				sourceElement = SafeGetByXPath.safeGetByXPath(driver, source);
				break;
			case Locator_Type_Constants.CLASSNAME:
				sourceElement = SafeGetByClassName.safeGetByClassName(driver, source);
				break;
			case Locator_Type_Constants.ID:
				sourceElement = SafeGetByID.safeGetByID(driver, source);
				break;
			case Locator_Type_Constants.CSSSELECTOR:
				sourceElement = SafeGetByCSSSelector.safeGetByCssSelector(driver, source);
				break;
			default:
				sourceElement = null;
				break;
		}
		return sourceElement;
	}
	
	/**
	 * Attempts to convert the passed in WebElement into a Select object. If the WebElement is null
	 * then null is returned. If an exception occurs during the process then null is returned. If the
	 * process is successful then the converted Select object is returned.
	 * @param element -> WebElement
	 * @return -> Select
	 */
	public static Select convertWebElementToSelectObject(WebElement element) {
		if(element==null)
			return null;
		try {
			return new Select(element);
		}catch(Exception ex) {
			return null;
		}
	}
}
