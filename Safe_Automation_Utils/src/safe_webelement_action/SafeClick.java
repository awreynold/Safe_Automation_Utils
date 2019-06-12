package safe_webelement_action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.HelperUtils;

/**
 * 
 * @author Arthur Reynolds
 * created: 05/31/2019
 * updated: 06/10/2019
 * 
 * Contains methods that provide a safe way to handle clicking a WebElement.
 * 
 * All methods in this class are static.
 */

public final class SafeClick {

	/**
	 * Attempts to perform a click action upon the WebElement that is passed into the method. If an
	 * exception is thrown during this action then false is returned to indicate that the click didn't
	 * occur. If the WebElement passed in is null then false is also returned. If the click action
	 * completes successfully then true is returned indicating the click was successful.
	 * @param element -> WebElement
	 * @return -> boolean
	 */
	public static boolean safeClickWebElement(WebElement element) {
		try {
			if(element==null)
				return false;
			element.click();
			return true;
		}catch(Exception ex){
			return false;
		}
	}
	
	/**
	 * Attempts to perform a click action upon the WebElement object that matches the passed in source String value.
	 * If the WebDriver is null or if the source String object or sourceType String object is null or blank,
	 * then false is returned. If an exception occurs during the process then false is returned. If the click action
	 * completes successfully then true is returned indicating the click was successful.
	 * @param driver -> WebDriver
	 * @param source -> String
	 * @param sourceType -> String
	 * @return -> boolean
	 */
	public static boolean safeClickByString(WebDriver driver, String source, String sourceType) {
		if(driver==null || source.isEmpty() || sourceType.isEmpty())
			return false;
		try {
			WebElement sourceElement = HelperUtils.locateWebElement(driver, source, sourceType);
			return safeClickWebElement(sourceElement);
		}catch(Exception ex) {
			return false;
		}
	}
}