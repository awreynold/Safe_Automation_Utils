package safe_automation_utils.safe_webelement_action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import safe_automation_utils.safe_utils.HelperUtils;

/**
 * 
 * @author Arthur Reynolds
 * created: 06/01/2019
 * updated: 06/10/2019
 *
 * Contains methods that provide a safe way to handle double clicking a WebElement.
 * 
 * All methods in this class are static.
 */
public final class SafeDoubleClick {

	/**
	 * Attempts to double click the passed in WebElement. If the WebDriver object or if the WebElement object
	 * is null then false is returned. If an exception occurs during the process then false is returned. If
	 * the double click action is successful then true is returned indicating that the right click was successful.
	 * @param driver -> WebDriver
	 * @param element -> WebElement
	 * @return -> boolean
	 */
	public static boolean safeDoubleClickWebElement(WebDriver driver, WebElement element) {
		try {
			if(driver==null || element==null)
				return false;
			Actions action = new Actions(driver);
			action.doubleClick(element);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to double click the WebElement that matches the passed in source String value. If the WebDriver object
	 * is null or if the source String object or sourceType String object is null or blank, then false is returned. If
	 * an exception occurs during the process then false is returned. If the double click action is successful then
	 * true is returned indicating that the right click was successful.
	 * @param driver -> WebDriver
	 * @param source -> String
	 * @param sourceType -> String
	 * @return -> boolean
	 */
	public static boolean safeDoubleClickString(WebDriver driver, String source, String sourceType) {
		if(driver==null || source.isEmpty() || sourceType.isEmpty())
			return false;
		try {
			WebElement sourceElement = HelperUtils.locateWebElement(driver, source, sourceType);
			return safeDoubleClickWebElement(driver, sourceElement);
		}catch(Exception ex) {
			return false;
		}
	}
}