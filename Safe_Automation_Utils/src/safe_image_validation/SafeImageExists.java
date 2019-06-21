package safe_automation_utils.safe_image_validation;

import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

/**
 * 
 * @author Arthur Reynolds
 * created: 06/20/2019
 * updated: 06/20/2019
 * 
 * Contains methods that provide a safe way to validate that an image exists on the screen based
 * on an image file located on the computer.
 * 
 * All methods in this class are static.
 */
public class SafeImageExists {

	/**
	 * Checks if an image exists based on the similarity percentage of 95%. If the image
	 * is not found on any monitor then 0 is returned. If an exception occurs during the process
	 * then -1 is returned. If the image is found on one of the monitors then 1 is returned.
	 * @param imagePattern -> Pattern
	 * @return -> int
	 */
	public static int safeImageExists(Pattern imagePattern) {
		Screen s = null;
		int numMonitors = Screen.getNumberScreens();
		int currentMonitor = 0;
		boolean found = false;
		
		while(found==false && currentMonitor<numMonitors) {
			s=new Screen(currentMonitor);
			try {
				if(null != s.exists(imagePattern.similar(0.95f))) {
					found=true;
					return 1;
				}else {
					found=false;
					currentMonitor++;
				}
			}catch(Exception ex) {
				return -1;
			}
		}
		return 0;
	}
	
	/**
	 * Performs the same action as safeImageExists(Pattern) but takes in a String instead.
	 * @param imagePath -> String
	 * @return -> int
	 */
	public static int safeImageExists(String imagePath) {
		Pattern imagePattern = new Pattern(imagePath);
		return safeImageExists(imagePattern);
	}
}