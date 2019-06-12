package safe_get_webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author Arthur Reynolds
 * created: 05/31/2019
 * updated: 05/31/2019
 * 
 * Contains methods that provide safe ways of searching and getting WebElements based upon an
 * ClassName string value.
 * 
 * All methods in this class are static.
 */

public final class SafeGetByClassName {

	/**
	 * Searches for the WebElement based upon the className passed in using the driver that is passed
	 * in. Once found that WebElement will be returned. If no WebElement is found and the 
	 * NoSuchElementException exception is thrown then null is returned instead. If the driver
	 * object is null or if the className string is null or blank then null is returned as well.
	 * @param driver -> WebDriver
	 * @param className -> String
	 * @return -> WebElement
	 */
	public static WebElement safeGetByClassName(WebDriver driver, String className) {
		try {
			if(driver == null || className.isEmpty())
				return null;
			return driver.findElement(By.className(className));
		}catch(NoSuchElementException ex) {
			return null;
		}
	}
	
	/**
	 * Searches for the WebElement that matches the className passed in and is a child of the 
	 * WebElement that is passed in. Once found that WebElement will be returned. If no WebElement
	 * is found and the NoSuchException exception is thrown then null is returned instead.
	 * If the driver object is null or if the className string is null or blank then null is returned
	 * as well.
	 * @param element -> WebElement
	 * @param className -> String
	 * @return -> WebElement
	 */
	public static WebElement safeGetChildByClassName(WebElement element, String className) {
		try {
			if(element==null || className.isEmpty())
				return null;
			return element.findElement(By.className(className));
		}catch(NoSuchElementException ex) {
			return null;
		}
	}
}