package safe_automation_utils.safe_webelement_action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import safe_automation_utils.safe_utils.HelperUtils;

/**
 * 
 * @author Arthur Reynolds
 * created: 05/31/2019
 * updated: 06/10/2019
 * 
 * Contains methods that provide a safe way to perform a move to action on a WebElement.
 * 
 * All methods in this class are static.
 */

public final class SafeMoveTo {

	/**
	 * Attempts to perform a safe move to action, moving the mouse pointer to the passed in WebElement
	 * object. If the WebDriver or WebElement object is null then false is returned. If an exception
	 * occurs during the move to process then false is returned. If the mouse pointer is moved to 
	 * the WebElement successfully then true is returned to indicate that the action was successful.
	 * @param driver -> WebDriver
	 * @param element -> WebElement
	 * @return -> boolean
	 */
	public static boolean safeMoveToWebElement(WebDriver driver, WebElement element) {
		try {
			if(driver==null || element==null)
				return false;
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to perform a safe move to action, moving the mouse pointer to the WebElement that matches the
	 * passed in source String value. If the WebDriver is null or if the source String or sourceType String is null
	 * or blank, then false is returned. If an exception occurs during the process then false is returned. If
	 * the mouse point is moved to the WebElement successfully then true is returned to indicate that the action
	 * was successful.
	 * @param driver -> WebDriver
	 * @param source -> String
	 * @param sourceType -> String
	 * @return -> boolean
	 */
	public static boolean safeMoveToString(WebDriver driver, String source, String sourceType) {
		if(driver==null || source.isEmpty() || sourceType.isEmpty())
			return false;
		try {
			WebElement sourceElement = HelperUtils.locateWebElement(driver, source, sourceType);
			return safeMoveToWebElement(driver, sourceElement);
		}catch(Exception ex) {
			return false;
		}
	}
}
