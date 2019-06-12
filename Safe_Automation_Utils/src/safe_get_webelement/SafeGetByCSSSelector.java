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
 * cssSelector string value.
 * 
 * All methods in this class are static.
 */

public final class SafeGetByCSSSelector {

	/**
	 * Searches for the WebElement based upon the cssSelector passed in using the driver that is passed
	 * in. Once found that WebElement will be returned. If no WebElement is found and the 
	 * NoSuchElementException exception is thrown then null is returned instead. If the driver
	 * object is null or if the cssSelector string is null or blank then null is returned as well.
	 * @param driver -> WebDriver
	 * @param cssSelector -> String
	 * @return -> WebElement
	 */
	public static WebElement safeGetByCssSelector(WebDriver driver, String cssSelector) {
		try {
			if(driver == null || cssSelector.isEmpty())
				return null;
			return driver.findElement(By.cssSelector(cssSelector));
		}catch(NoSuchElementException ex) {
			return null;
		}
	}
	
	/**
	 * Searches for the WebElement that matches the cssSelector passed in and is a child of the 
	 * WebElement that is passed in. Once found that WebElement will be returned. If no WebElement
	 * is found and the NoSuchException exception is thrown then null is returned instead.
	 * If the driver object is null or if the cssSelector string is null or blank then null is returned
	 * as well.
	 * @param element -> WebElement
	 * @param cssSelector -> String
	 * @return -> WebElement
	 */
	public static WebElement safeGetChildByCssSelector(WebElement element, String cssSelector) {
		try {
			if(element==null || cssSelector.isEmpty())
				return null;
			return element.findElement(By.cssSelector(cssSelector));
		}catch(NoSuchElementException ex) {
			return null;
		}
	}
}