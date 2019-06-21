package safe_automation_utils.safe_get_webelement_property;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import safe_automation_utils.safe_utils.HelperUtils;

/**
 * 
 * @author Arthur Reynolds
 * created: 05/31/2019
 * updated: 06/10/2019
 * 
 * Contains methods that provide a safe way to determine different properties of a WebElement
 * (isDisplayed, isEnabled, isSelected, etc).
 * 
 * All methods in this class are static.
 */

public final class SafeGetProperties {

	/**
	 * Attempts to check if the passed in WebElement object is currently displayed in the browser.
	 * If the element is null then false is returned. If an exception occurs during the isDisplay action
	 * then false is returned. If the WebElement is displayed in the browser then this method will
	 * return true.
	 * @param element -> WebElement
	 * @return -> boolean
	 */
	public static boolean safeElementIsDisplayed(WebElement element) {
		if(element==null)
			return false;
		try {
			return element.isDisplayed();
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to check if the WebElement that matches the passed in source String value is currently
	 * displayed in the browser window. If the WebDriver object is null or if the source String object or
	 * sourceType String object are null or blank, then false is returned. If an exception occurs during the
	 * process the false is returned. If the element is displayed in the browser window then true is returned.
	 * @param driver -> WebDriver
	 * @param source -> String
	 * @param sourceType -> String
	 * @return -> boolean
	 */
	public static boolean safeIsDisplayedByString(WebDriver driver, String source, String sourceType) {
		if(driver==null || source.isEmpty() || sourceType.isEmpty())
			return false;
		try {
			WebElement sourceElement = HelperUtils.locateWebElement(driver, source, sourceType);
			return safeElementIsDisplayed(sourceElement);
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to check if the passed in WebElement object is currently selected.
	 * If the element is null then false is returned. If an exception occurs during the isSelected action
	 * then false is returned. If the WebElement is selected then this method will
	 * return true.
	 * @param element -> WebElement
	 * @return -> boolean
	 */
	public static boolean safeElementIsSelected(WebElement element) {
		if(element==null)
			return false;
		try {
			return element.isSelected();
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to check if the WebElement that matches the passed in source String value is currently
	 * selected. If the WebDriver object is null or if the source String object or sourceType String object
	 * are null or blank, then false is returned. If an exception occurs during the process the false is 
	 * returned. If the element is selected then true is returned.
	 * @param driver -> WebDriver
	 * @param source -> String
	 * @param sourceType -> String
	 * @return -> boolean
	 */
	public static boolean safeIsSelectedByString(WebDriver driver, String source, String sourceType) {
		if(driver==null || source.isEmpty() || sourceType.isEmpty())
			return false;
		try {
			WebElement sourceElement = HelperUtils.locateWebElement(driver, source, sourceType);
			return safeElementIsSelected(sourceElement);
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to check if the passed in WebElement object is currently enabled.
	 * If the element is null then false is returned. If an exception occurs during the isEnabled action
	 * then false is returned. If the WebElement is enabled then this method will
	 * return true.
	 * @param element -> WebElement
	 * @return -> boolean
	 */
	public static boolean safeElementIsEnabled(WebElement element) {
		if(element==null)
			return false;
		try {
			return element.isEnabled();
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to check if the WebElement that matches the passed in source String value is currently
	 * enabled. If the WebDriver object is null or if the source String object or sourceType String object
	 * are null or blank, then false is returned. If an exception occurs during the process the false is 
	 * returned. If the element is enabled then true is returned.
	 * @param driver -> WebDriver
	 * @param source -> String
	 * @param sourceType -> String
	 * @return -> boolean
	 */
	public static boolean safeIsEnabledByString(WebDriver driver, String source, String sourceType) {
		if(driver==null || source.isEmpty() || sourceType.isEmpty())
			return false;
		try {
			WebElement sourceElement = HelperUtils.locateWebElement(driver, source, sourceType);
			return safeElementIsEnabled(sourceElement);
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to get the size Dimension variable of the passed in WebElement. If the WebElement is null then
	 * null is returned. If an exception occurs during the process then null is returned. If the size values are
	 * successfully found for the passed in WebElement, then the Dimension variable representing the size values is
	 * returned.
	 * @param element -> WebElement
	 * @return -> Dimension
	 */
	public static Dimension safeGetWebElementSize(WebElement element) {
		if(element==null)
			return null;
		try {
			return element.getSize();
		}catch(Exception ex) {
			return null;
		}
	}
	
	/**
	 * Attempts to get the size Dimension variable of the WebElement that matches the passed in source String value.
	 * If the WebDriver is null or if the source String object or sourceType String object are null or blank,
	 * then null is returned. If the WebElement is not located then null is returned. If an exception occurs during
	 * the process then null is returned. If the size values are successfully found for the passed in WebElement,
	 * then the Dimension variable representing the size values is returned.
	 * @param driver -> WebDriver
	 * @param source -> String
	 * @param sourceType -> String
	 * @return -> Dimension
	 */
	public static Dimension safeGetSizeByString(WebDriver driver, String source, String sourceType) {
		if(driver==null || source.isEmpty() || sourceType.isEmpty())
			return null;
		try {
			WebElement sourceElement = HelperUtils.locateWebElement(driver, source, sourceType);
			return safeGetWebElementSize(sourceElement);
		}catch(Exception ex) {
			return null;
		}
	}
	
	/**
	 * Attempts to get the Point location of the top left corner of the passed in WebElement object.
	 * If the WebElement is null then null is returned. If an exception occurs during the process then
	 * null is returned. If the Point location variable is found successfully then true is returned
	 * to indicate that it was successful.
	 * @param driver -> WebDriver
	 * @param element -> WebElement
	 * @return -> Point
	 */
	public static Point safeGetLocationOfWebElement(WebElement element) {
		if(element==null)
			return null;
		try {
			return element.getLocation();
		}catch(Exception ex) {
			return null;
		}
	}
}