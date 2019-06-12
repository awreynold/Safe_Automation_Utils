package safe_webelement_action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.HelperUtils;

/**
 * 
 * @author Arthur Reynolds
 * created: 06/03/2019
 * updated: 06/10/2019
 * 
 * Contains methods that provide a safe way to perform the Drag and Drop action using WebElements.
 * 
 * All methods in this class are static.
 */

public final class SafeDragAndDrop {

	/**
	 * Attempts to move a WebElement from its current location to the location of the other passed
	 * in WebElement. If the WebDriver or either WebElement object is null then false is returned.
	 * If an exception occurs during the process then false is returned. If the action is completed
	 * successfully then true is returned to indicate that it was successful.
	 * @param driver -> WebDriver
	 * @param sourceElement -> WebElement
	 * @param destinationElement -> WebElement
	 * @return -> boolean
	 */
	public static boolean safeDragAndDropWebElement(WebDriver driver, WebElement sourceElement, 
			WebElement destinationElement) {
		if(driver==null || sourceElement==null || destinationElement==null)
			return false;
		try {
			Actions action = new Actions(driver);
			action.dragAndDrop(sourceElement, destinationElement);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to move the WebElement that matches the source String value passed in, to the destinationElement WebElement that is
	 * passed in. If any of the parameters are null or blank then false is returned. If an exception occurs
	 * during the process then false is returned. If the action is completed successfully then true is returned to
	 * indicate that it was successful. The different values that are accepted for the sourceType parameter are stored in
	 * the Getter_Type_Constants.java file.
	 * @param driver -> WebDriver
	 * @param source -> String
	 * @param sourceType -> String
	 * @param destinationElement -> WebElement
	 * @return -> boolean
	 */
	public static boolean safeDragAndDropStringToWebElement(WebDriver driver, String source, String sourceType,
			WebElement destinationElement) {
		if(driver==null || source.isEmpty() || sourceType.isEmpty() || destinationElement==null)
			return false;
		try {
			WebElement sourceElement = HelperUtils.locateWebElement(driver, source, sourceType);
			return safeDragAndDropWebElement(driver, sourceElement, destinationElement);
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to move the sourceElement WebElement passed in, to the WebElement that matches the passed in 
	 * destination String value. If any of the parameters are null or blank then false is returned. If an exception occurs
	 * during the process then false is returned. If the action is completed successfully then true is returned to
	 * indicate that it was successful. The different values that are accepted for the destinationType parameter are stored in
	 * the Getter_Type_Constants.java file.
	 * @param driver
	 * @param sourceElement
	 * @param destination
	 * @param destinationType
	 * @return
	 */
	public static boolean safeDragAndDropWebElementToString(WebDriver driver, WebElement sourceElement, 
			String destination, String destinationType) {
		if(driver==null || sourceElement==null || destination.isEmpty() || destinationType.isEmpty())
			return false;
		try {
			WebElement destinationElement = HelperUtils.locateWebElement(driver, destination, destinationType);
			return safeDragAndDropWebElement(driver, sourceElement, destinationElement);
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to move the WebElement that matches the source String value passed in, to the WebElement that
	 * matches the destination String value that is passed in. If any of the parameters are null or blank then
	 * false is returned. If an exception occurs during the process then false is returned. If the action
	 * is completed successfully then true is returned to indicate that it was successful. The different
	 * values that are accepted for the sourceType and destinationType parameters are stored in the Getter_Type_Constants.java file.
	 * @param driver -> WebDriver
	 * @param source -> String
	 * @param sourceType -> String
	 * @param destination -> String
	 * @param destinationType -> String
	 * @return -> boolean
	 */
	public static boolean safeDragAndDropStringToString(WebDriver driver, String source, String sourceType,
			String destination, String destinationType) {
		if(driver==null || source.isEmpty() || sourceType.isEmpty() || destination.isEmpty() || destinationType.isEmpty())
			return false;
		try {
			WebElement sourceElement = HelperUtils.locateWebElement(driver, source, sourceType);
			WebElement destinationElement = HelperUtils.locateWebElement(driver, destination, destinationType);
			return safeDragAndDropWebElement(driver, sourceElement, destinationElement);
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to move the sourceElement WebElement that is passed in, to the location specified by the 
	 * int destinationX and int destinationY values that are passed in. If the WebDriver or WebElement parameters
	 * are null then false is returned. If an exception occurs during the process then false is returned. If the action
	 * is completed successfully then true is returned to indicate that the action was successful.
	 * @param driver -> WebDriver
	 * @param sourceElement -> WebElement
	 * @param destinationX -> int
	 * @param destinationY -> int
	 * @return -> boolean
	 */
	public static boolean safeDragAndDropWebElementToLocation(WebDriver driver, WebElement sourceElement, int destinationX,
			int destinationY) {
		if(driver==null || sourceElement==null)
			return false;
		try {
			Actions action = new Actions(driver);
			action.dragAndDropBy(sourceElement, destinationX, destinationY);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Attempts to move the WebElement that matches that passed in source String value to the passed in destinationX and 
	 * destinationY location. If the WebDriver object or the source String object or the sourceType String object are null or blank,
	 * then false is returned. If an exception occurs during the process then false is returned. If the action is completed
	 * successfully then true is returned to indicated it was successful. The valid values for the sourceType variable are 
	 * stored in the Getter_Type_Constants.java file.
	 * @param driver -> WebDriver
	 * @param source -> String
	 * @param sourceType -> String
	 * @param destinationX -> int
	 * @param destinationY -> int
	 * @return -> boolean
	 */
	public static boolean safeDragAndDropStringToLocation(WebDriver driver, String source, String sourceType, int destinationX,
			int destinationY) {
		if(driver==null || source.isEmpty() || sourceType.isEmpty())
			return false;
		try {
			WebElement sourceElement = HelperUtils.locateWebElement(driver, source, sourceType);
			return safeDragAndDropWebElementToLocation(driver, sourceElement, destinationX, destinationY);
		}catch(Exception ex) {
			return false;
		}
	}
}