package screenshots;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import safe_get_webelement_property.SafeGetProperties;
import utils.HelperUtils;

/**
 * 
 * @author Arthur Reynolds
 * created: 06/10/2019
 * updated: 06/12/2019
 * 
 * Contains methods that involve the screenshot functionality in relation to the WebElement objects.
 * 
 * All methods in this class are static.
 */
public final class SafeWebElementScreenshot {

	/**
	 * Attempts to take a screenshot of the current screen and save that file to the passed in savePath location
	 * under the passed in fileName value. If the WebDriver object is null or if the savePath String object or 
	 * fileName String object is null or blank then 0 is returned. If an exception occurs during the process
	 * then 0 is returned. If a file already exists in the passed in savePath location under the passed in fileName
	 * value then -1 is returned. If the screenshot is created successfully then 1 is returned.
	 * @param driver -> WebDriver
	 * @param savePath -> String
	 * @param fileName -> String
	 * @return -> int
	 */
	public static int safeTakeScreenshot(WebDriver driver, String savePath, String fileName) {
		if(driver==null || savePath.isEmpty() || fileName.isEmpty())
			return 0;
		try {
			//checks to see if the file alreadly exists
			File imageFile = new File(savePath + "\\" + fileName);
			if(imageFile.exists())
				return -1;
			//get entire page screenshot
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, imageFile);
			return 1;
		}catch(Exception ex) {
			return 0;
		}
	}
	
	/**
	 * Attempts to take a screenshot of the passed in WebElement and save it off to the specified path String value
	 * and naming it the fileName String value that is passed in. If the WebDriver or WebElement is null or the
	 * savePath String object or fileName String object is null or blank, then 0 is returned. If an exception
	 * occurs during the process then 0 is returned as well. If the file that was passed in already exists in the
	 * path that was passed in then -1 is returned. If the screenshot is created successfully then 1 is returned
	 * to indicate that it was successful.
	 * @param driver -> WebDriver
	 * @param element -> WebElement
	 * @param savePath -> String
	 * @param fileName -> String
	 * @return -> int
	 */
	public static int safeTakeScreenshotOfWebElement(WebDriver driver, WebElement element, String savePath, String fileName) {
		if(driver==null || element==null || savePath.isEmpty() || fileName.isEmpty())
			return 0;
		try {
			//checks to see if the file alreadly exists
			File imageFile = new File(savePath + "\\" + fileName);
			if(imageFile.exists())
				return -1;
			//get entire page screenshot
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			BufferedImage fullImage = ImageIO.read(screenshot);
			//get the location of the WebElement on the page
			Point point = SafeGetProperties.safeGetLocationOfWebElement(element);
			Dimension dimension = SafeGetProperties.safeGetWebElementSize(element);
			//copy the entire page screenshot to get only the webelement screenshot
			BufferedImage elementScreenshot=fullImage.getSubimage(point.getX(), point.getY(), dimension.getWidth(),
					dimension.getHeight());
			ImageIO.write(elementScreenshot, "png", screenshot);
			//copy the webelement screenshot to disk
			FileUtils.copyFile(screenshot, imageFile);
			return 1;
		}catch(Exception ex) {
			return 0;
		}
	}
	
	/**
	 * Attempts to take a screenshot of the WebElement that matches the passed in source String value and
	 * save it off to the specified path String value and naming it the fileName String value that is 
	 * passed in. If the WebDriver or WebElement is null or the savePath String object or 
	 * fileName String object is null or blank, then 0 is returned. If an exception
	 * occurs during the process then 0 is returned as well. If the file that was passed in already exists in the
	 * path that was passed in then -1 is returned. If the screenshot is created successfully then 1 is returned
	 * to indicate that it was successful.
	 * @param driver -> WebDriver
	 * @param source -> String
	 * @param sourceType -> String
	 * @param savePath -> String
	 * @param fileName -> String
	 * @return -> int
	 */
	public static int safeTakeScreenshotOfWebElementByString(WebDriver driver, String source, String sourceType, String savePath,
			String fileName) {
		if(driver==null || source.isEmpty() || sourceType.isEmpty() || savePath.isEmpty() || fileName.isEmpty())
			return 0;
		try {
			WebElement sourceElement = HelperUtils.locateWebElement(driver, source, sourceType);
			return safeTakeScreenshotOfWebElement(driver, sourceElement, savePath, fileName);
		}catch(Exception ex) {
			return 0;
		}
	}
}