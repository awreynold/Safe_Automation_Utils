package safe_automation_utils.safe_webelement_action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import safe_automation_utils.safe_utils.HelperUtils;

/**
 * 
 * @author Arthur Reynolds
 * created: 06/10/2019
 * updated: 06/10/2019
 * 
 * Contains methods that would allow a safe way to rotate a WebElement object in different directions.
 * This applies mostly to 3D rendered objects like globes, etc.
 * 
 * The methods in this class are static.
 */

public final class SafeRotate {

	/**
	 * Attempts to rotate the passed in WebElement to the left or right depending on if the xOffset
	 * int value is positive (rotate right) or negative (rotate left). If the WebDriver or WebElement objects
	 * are null then 0 is returned. If the moveTo action is unsuccessful at moving to the passed in WebElement
	 * then -1 is returned. If an exception occurs during the process then 0 is returned.
	 * If the WebElement is successfully rotated then 1 is returned to indicate it was successful.
	 * @param driver -> WebDriver
	 * @param element -> WebElement
	 * @param xOffset -> int
	 * @return -> int
	 */
	public static int rotateLeftOrRight(WebDriver driver, WebElement element, int xOffset) {
		if(driver==null || element==null)
			return 0;
		try {
			Actions action = new Actions(driver);
			if(!SafeMoveTo.safeMoveToWebElement(driver, element))
				return -1;
			action.clickAndHold(element);
			action.moveByOffset(xOffset, 0);
			action.release();
			return 1;
		}catch(Exception ex) {
			return 0;
		}
	}
	
	/**
	 * Attempts to rotate the WebElement that matches the passed in source String object to the left or right 
	 * depending on if the xOffset int value is positive (rotate right) or negative (rotate left). 
	 * If the WebDriver or source String object or sourceType String object are null or blank then 0 is returned.
	 * If the matching WebElement can't be found then -2 will be returned. If the moveTo action is
	 * unsuccessful at moving to the passed in WebElement then -1 is returned. If an exception occurs
	 * during the process then 0 is returned. If the WebElement is successfully rotated then 1 is
	 * returned to indicate it was successful.
	 * @param driver -> WebDriver
	 * @param source -> String
	 * @param sourceType -> String
	 * @param xOffset -> int
	 * @return -> int
	 */
	public static int rotateLeftOrRightByString(WebDriver driver, String source, String sourceType, int xOffset) {
		if(driver==null || source.isEmpty() || sourceType.isEmpty())
			return 0;
		try {
			WebElement sourceElement = HelperUtils.locateWebElement(driver, source, sourceType);
			if(sourceElement==null)
				return -2;
			if(!SafeMoveTo.safeMoveToWebElement(driver, sourceElement))
				return -1;
			Actions action = new Actions(driver);
			action.clickAndHold(sourceElement);
			action.moveByOffset(xOffset, 0);
			action.release();
			return 1;
		}catch(Exception ex) {
			return 0;
		}
	}
	
	/**
	 * Attempts to rotate the passed in WebElement to the up or down depending on if the xOffset
	 * int value is positive (rotate up) or negative (rotate down). If the WebDriver or WebElement objects
	 * are null then 0 is returned. If the moveTo action is unsuccessful at moving to the passed in WebElement
	 * then -1 is returned. If an exception occurs during the process then 0 is returned.
	 * If the WebElement is successfully rotated then 1 is returned to indicate it was successful.
	 * @param driver -> WebDriver
	 * @param element -> WebElement
	 * @param yOffset -> int
	 * @return -> int
	 */
	public static int rotateUpOrDown(WebDriver driver, WebElement element, int yOffset) {
		if(driver==null || element==null)
			return 0;
		try {
			Actions action = new Actions(driver);
			if(!SafeMoveTo.safeMoveToWebElement(driver, element))
				return -1;
			action.clickAndHold(element);
			action.moveByOffset(0, yOffset);
			action.release();
			return 1;
		}catch(Exception ex) {
			return 0;
		}
	}
	
	/**
	 * Attempts to rotate the WebElement that matches the passed in source String object to the left or right 
	 * depending on if the yOffset int value is positive (rotate up) or negative (rotate down). 
	 * If the WebDriver or source String object or sourceType String object are null or blank then 0 is returned.
	 * If the matching WebElement can't be found then -2 will be returned. If the moveTo action is
	 * unsuccessful at moving to the passed in WebElement then -1 is returned. If an exception occurs
	 * during the process then 0 is returned. If the WebElement is successfully rotated then 1 is
	 * returned to indicate it was successful.
	 * @param driver
	 * @param source
	 * @param sourceType
	 * @param yOffset
	 * @return
	 */
	public static int rotateUpOrDownByString(WebDriver driver, String source, String sourceType, int yOffset) {
		if(driver==null || source.isEmpty() || sourceType.isEmpty())
			return 0;
		try {
			WebElement sourceElement = HelperUtils.locateWebElement(driver, source, sourceType);
			if(sourceElement==null)
				return -2;
			if(!SafeMoveTo.safeMoveToWebElement(driver, sourceElement))
				return -1;
			Actions action = new Actions(driver);
			action.clickAndHold(sourceElement);
			action.moveByOffset(0, yOffset);
			action.release();
			return 1;
		}catch(Exception ex) {
			return 0;
		}
	}
}