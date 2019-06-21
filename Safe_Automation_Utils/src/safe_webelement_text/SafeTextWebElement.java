package safe_automation_utils.safe_webelement_text;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import safe_automation_utils.constants.Attribute_Constants;
import safe_automation_utils.safe_get_webelement_property.SafeGetAttributes;
import safe_automation_utils.safe_utils.HelperUtils;

/**
 * 
 * @author Arthur Reynolds
 * created: 06/04/2019
 * updated: 06/10/2019
 * 
 * Contains methods that provide safe ways of interacting with a text WebElement.
 * 
 * All methods in this class are static.
 */

public final class SafeTextWebElement {

	/**
	 * Attempts to set the passed in text String value to the passed in textWebElement WebElement. If the WebDriver object
	 * or the textWebElement WebElement are null or if the text String object is null or blank then 0 is returned. If
	 * an exception occurs during the process then 0 is returned. If a TimeoutException occurs while waiting for the text
	 * value to be set to the textWebElement WebElement then -1 is returned to indicate that the text was not set correctly.
	 * If the process is successful then 1 will be returned to indicate that the text String value was successfully set to
	 * the textWebElement WebElement. The int timeOutSeconds parameter will determine how long the method should wait for the
	 * text to be set before throwing the TimeoutException. This value should be set higher than 0.
	 * @param driver -> WebDriver
	 * @param textWebElement -> WebElement
	 * @param text -> String
	 * @param wait -> WebDriverWait
	 * @return -> int
	 */
	public static int safeSetTextToTextWebElement(WebDriver driver, WebElement textWebElement, String text, WebDriverWait wait) {
		if(driver==null || textWebElement==null || text.isEmpty())
			return 0;
		try {
			textWebElement.clear();
			textWebElement.sendKeys(text);
			try {
				wait.until(ExpectedConditions.textToBePresentInElement(textWebElement, text));
				return 1;
			}catch(TimeoutException ex) {
				return -1;
			}
		}catch(Exception ex) {
			return 0;
		}
	}
	
	/**
	 * Attempts to set the text String value to the WebElement that matches the passed in textWebElement String value. This
	 * WebElement is located based on the value passed in for the textWebElementType String value. If the driver WebDriver object
	 * is null or if the textWebElement String object, textWebElementType String object, or the text String object are null or blank
	 * then 0 is returned. If a TimeoutException occurs while attempting to set the text String value to the textWebElement
	 * then -1 is returned to indicate that the text value was not set correctly. If an exception occurs during the 
	 * process then 0 is returned. If the text value is set correctly to the textWebElement WebElement then 1 is returned
	 * to indicate that the text was set successfully.
	 * @param driver -> WebDriver
	 * @param textWebElement -> String
	 * @param textWebElementType -> String
	 * @param text -> String
	 * @param wait -> WebDriverWait
	 * @return -> int
	 */
	public static int safeSetTextToStringTextWebElement(WebDriver driver, String textWebElement, String textWebElementType, String text, 
			WebDriverWait wait) {
		if(driver==null || textWebElement.isEmpty() || text.isEmpty())
			return 0;
		try {
			WebElement textWebElementElement = HelperUtils.locateWebElement(driver, textWebElement, textWebElementType);
			return safeSetTextToTextWebElement(driver, textWebElementElement, text, wait);
		}catch(Exception ex) {
			return 0;
		}
	}
	
	/**
	 * Attempts to get the text from the passed in textWebElement WebElement. If the textWebElement WebElement object is null then
	 * null is returned. If an exception occurs during the process then null is returned. If the process is successful then
	 * the text in the textWebElement WebElement will be ran through the trim() method and the result returned.
	 * @param textWebElement -> WebElement
	 * @return -> String
	 */
	public static String safeGetTextFromTextWebElement(WebElement textWebElement) {
		if(textWebElement==null)
			return null;
		try {
			return textWebElement.getText().trim();
		}catch(Exception ex) {
			return null;
		}
	}
	
	/**
	 * Attempts to get the text from the WebElement that matches the passed in textWebElement String value. If the WebDriver object
	 * is null or if the textWebElement String object or the textWebElementType String object is null or blank then null is returned.
	 * If the process is successful then the text in the textWebElement WebElement will be returned as the result.
	 * @param driver -> WebDriver
	 * @param textWebElement -> String
	 * @param textWebElementType -> String
	 * @return -> String
	 */
	public static String safeGetTextFromStringTextWebElement(WebDriver driver, String textWebElement, String textWebElementType) {
		if(driver==null || textWebElement.isEmpty())
			return null;
		try {
			WebElement textWebElementElement = HelperUtils.locateWebElement(driver, textWebElement, textWebElementType);
			return safeGetTextFromTextWebElement(textWebElementElement);
		}catch(Exception ex) {
			return null;
		}
	}
	
	/**
	 * Attempts to get the value from the passed in textWebElement WebElement. If the textWebElement WebElement object is null then
	 * null is returned. If an exception occurs during the process then null is returned. If the process is successful then
	 * the value in the textWebElement WebElement will be returned as a String.
	 * @param textWebElement -> WebElement
	 * @return -> String
	 */
	public static String safeGetValueFromTextWebElement(WebElement textWebElement) {
		if(textWebElement==null)
			return null;
		try {
			return SafeGetAttributes.safeGetAttribute(textWebElement, Attribute_Constants.VALUE_ATTR);
		}catch(Exception ex) {
			return null;
		}
	}
	
	/**
	 * Attempts to get the value from the WebElement that matches the passed in textWebElement String value. If the WebDriver object
	 * is null or if the textWebElement String object or the textWebElementType String object is null or blank then null is returned.
	 * If the process is successful then the value in the textWebElement WebElement will be returned as the result.
	 * @param driver -> WebDriver
	 * @param textWebElement -> String
	 * @param textWebElementType -> String
	 * @return -> String
	 */
	public static String safeGetValueFromStringTextWebElement(WebDriver driver, String textWebElement, String textWebElementType) {
		if(driver==null || textWebElement.isEmpty())
			return null;
		try {
			WebElement textWebElementElement = HelperUtils.locateWebElement(driver, textWebElement, textWebElementType);
			return safeGetValueFromTextWebElement(textWebElementElement);
		}catch(Exception ex) {
			return null;
		}
	}
}
