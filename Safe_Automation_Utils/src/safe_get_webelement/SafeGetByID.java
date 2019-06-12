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
 * id string value.
 * 
 * All methods in this class are static.
 */

public final class SafeGetByID {

	/**
	 * Searches for the WebElement based upon the id passed in using the driver that is passed
	 * in. Once found that WebElement will be returned. If no WebElement is found and the 
	 * NoSuchElementException exception is thrown then null is returned instead. If the driver
	 * object is null or if the id string is null or blank then null is returned as well.
	 * @param driver -> WebDriver
	 * @param id -> String
	 * @return -> WebElement
	 */
	public static WebElement safeGetByID(WebDriver driver, String id) {
		try {
			if(driver == null || id.isEmpty())
				return null;
			return driver.findElement(By.id(id));
		}catch(NoSuchElementException ex) {
			return null;
		}
	}
	
	/**
	 * Searches for the WebElement that matches the id passed in and is a child of the 
	 * WebElement that is passed in. Once found that WebElement will be returned. If no WebElement
	 * is found and the NoSuchException exception is thrown then null is returned instead.
	 * If the driver object is null or if the id string is null or blank then null is returned
	 * as well.
	 * @param element -> WebElement
	 * @param id -> String
	 * @return -> WebElement
	 */
	public static WebElement safeGetChildByID(WebElement element, String id) {
		try {
			if(element==null || id.isEmpty())
				return null;
			return element.findElement(By.id(id));
		}catch(NoSuchElementException ex) {
			return null;
		}
	}
}
