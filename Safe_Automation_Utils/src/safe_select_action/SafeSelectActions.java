package safe_automation_utils.safe_select_action;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import safe_automation_utils.safe_webelement_text.SafeTextWebElement;

/**
 * 
 * @author Arthur Reynolds
 * created: 06/10/2019
 * updated: 06/10/2019
 * 
 * Contains methods that provide safe ways to interact with Select objects.
 *
 * All methods in this class are static.
 */
public class SafeSelectActions {

	/**
	 * Attempts to get all the options related to the passed in Select object. If the selectElement
	 * Select object is null then null is returned. If an exception occurs during the process then
	 * null is returned. If the process is successful then a List of WebElements will be returned.
	 * @param selectElement -> Select
	 * @return -> List<WebElement>
	 */
	public static List<WebElement> safeGetAllOptions(Select select){
		if(select==null)
			return null;
		try {
			return select.getOptions();
		}catch(Exception ex) {
			return null;
		}
	}
	
	/**
	 * Attempts to get the first selected option of the passed in Select object. If the select Select
	 * object is null then null is returned. If an exception occurs during the process then null is
	 * returned. If the process is successful then a WebElement is returned representing the first
	 * selected option (select option for a normal select)
	 * @param select -> Select
	 * @return -> WebElement
	 */
	public static WebElement safeGetFirstSelectedOption(Select select) {
		if(select==null)
			return null;
		try {
			return select.getFirstSelectedOption();
		}catch(Exception ex) {
			return null;
		}
	}
	
	/**
	 * Attempts to get all the select options associated with the passed in Select object.
	 * If the Select object is null then null is returned. If an exception occurs during the process
	 * then null is returned. If the process is successful then a List of WebElements will be returned
	 * representing the list of selected options.
	 * @param select -> Select
	 * @return -> List<WebElement>
	 */
	public static List<WebElement> safeGetAllSelectedOptions(Select select){
		if(select==null)
			return null;
		try {
			return select.getAllSelectedOptions();
		}catch(Exception ex) {
			return null;
		}
	}
	
	/**
	 * Attempts to deselect all options from the passed in Select object. If the Select object is null
	 * then null is returned. If an exception occurs during the process then 0 is returned.
	 * If the process is successful then 1 is returned.
	 * @param select -> Select
	 * @return -> int
	 */
	public static int safeDeselectAllOptions(Select select) {
		if(select==null)
			return 0;
		try {
			select.deselectAll();
			return 1;
		}catch(Exception ex) {
			return 0;
		}
	}
	
	/**
	 * Attempts to get the first select option related to the Select object and convert that to a
	 * String to show the text value of the option. If the select is null then null is returned. If
	 * the first selected option is null then null is returned. If an exception occurs during the process
	 * then null is returned. If the process is successful then the String representation of the first 
	 * selected option is returned.
	 * @param select -> Select
	 * @return -> String
	 */
	public static String safeGetFirstSelectedOptionText(Select select) {
		if(select==null)
			return null;
		try {
			WebElement selectedOption = safeGetFirstSelectedOption(select);
			if(selectedOption==null)
				return null;
			return SafeTextWebElement.safeGetTextFromTextWebElement(selectedOption);
		}catch(Exception ex) {
			return null;
		}
	}
	
	/**
	 * Attempts to get the index of the selected option associated with the Select object.
	 * If select is null then -2 is returned. If an exception occurs during the process then -2
	 * is returned. If the option isn't found in the list of options then -1 is returned. If
	 * the option is found and the index is found successfully then the index of that option 
	 * is returned. 
	 * @param select -> Select
	 * @return -> int
	 */
	public static int safeGetIndexOfSelectedOption(Select select) {
		if(select==null)
			return -2;
		try {
			String selectedText = safeGetFirstSelectedOptionText(select);
			List<WebElement> options = safeGetAllOptions(select);
			for(int x=0; x<options.size(); x++) {
				if(selectedText.equals(SafeTextWebElement.safeGetTextFromTextWebElement(options.get(x))))
					return x;
			}
			return -1;
		}catch(Exception ex) {
			return -2;
		}
	}
	
	/**
	 * Attempts to set the passed in Select object to the specified option based on the options index.
	 * If the Select object is null then 0 is returned. If an exception occurs during the process then
	 * 0 is returned. If the process is successful then 1 is returned.
	 * @param select -> Select
	 * @param index -> int
	 * @return -> int
	 */
	public static int safeSetSelectOptionByIndex(Select select, int index) {
		if(select==null)
			return 0;
		try {
			select.selectByIndex(index);
			return 1;
		}catch(Exception ex) {
			return 0;
		}
	}
	
	/**
	 * Attempts to select all the options associated with the Select object based on the index value
	 * passed in from the indexes array. If Select object is null then 0 is returned. If an exception
	 * occurs during the process then 0 is returned. If the process is successful then 1 is returned.
	 * @param select -> Select
	 * @param indexes -> int[]
	 * @return -> int
	 */
	public static int safeSetSelectMultiOptionsByIndex(Select select, int[] indexes) {
		if(select==null)
			return 0;
		try {
			for(int x:indexes) {
				select.selectByIndex(x);
			}
			return 1;
		}catch(Exception ex) {
			return 0;
		}
	}
	
	/**
	 * Attempts to deselect the options from the passed in Select object based on what index is passed in.
	 * If the Select object is null then 0 is returned. If an exception occurs during the process then 0 is
	 * returned. If the process is successful then 1 is returned.
	 * @param select -> Select
	 * @param index -> int
	 * @return -> int
	 */
	public static int safeDeselectOptionByIndex(Select select, int index) {
		if(select==null)
			return 0;
		try {
			select.deselectByIndex(index);
			return 1;
		}catch(Exception ex) {
			return 0;
		}
	}
	
	/**
	 * Attempts to set the passed in Select object to the specified option based on the options
	 * visible text. If the Select object is null then 0 is returned. If an exception occurs during
	 * the process then 0 is returned. If the process is successful then 1 is returned.
	 * @param select -> Select
	 * @param text -> String
	 * @return -> int
	 */
	public static int safeSetSelectOptionByVisibleText(Select select, String text) {
		if(select==null)
			return 0;
		try {
			select.selectByVisibleText(text);
			return 1;
		}catch(Exception ex) {
			return 0;
		}
	}
	
	/**
	 * Attempts to select all the options associated with the Select object based on the visible text
	 * passed in from the texts array. If Select object is null then 0 is returned. If an exception
	 * occurs during the process then 0 is returned. If the process is successful then 1 is returned.
	 * @param select -> Select
	 * @param texts -> String[]
	 * @return -> int
	 */
	public static int safeSetSelectMultiOptionsByVisibleText(Select select, String[] texts) {
		if(select==null)
			return 0;
		try {
			for(String x:texts) {
				select.selectByVisibleText(x);
			}
			return 1;
		}catch(Exception ex) {
			return 0;
		}
	}
	
	/**
	 * Attempts to deselect the option associated with the Select object based on the visible text
	 * that is passed in. If the Select object is null then 0 is returned. If an exception occurs during
	 * the process then 0 is returned. If the process is successful then 1 is returned.
	 * @param select -> Select
	 * @param text -> String
	 * @return -> int
	 */
	public static int safeDeselectOptionByVisibleText(Select select, String text) {
		if(select==null)
			return 0;
		try {
			select.deselectByVisibleText(text);
			return 1;
		}catch(Exception ex) {
			return 0;
		}
	}
	
	/**
	 * Attempts to set the passed in Select object to the specified option based on the options
	 * value. If the Select object is null then 0 is returned. If an exception occurs during
	 * the process then 0 is returned. If the process is successful then 1 is returned.
	 * @param select -> Select
	 * @param value -> String
	 * @return -> int
	 */
	public static int safeSetSelectOptionByValue(Select select, String value) {
		if(select==null)
			return 0;
		try {
			select.selectByValue(value);
			return 1;
		}catch(Exception ex) {
			return 0;
		}
	}
	
	/**
	 * Attempts to select all the options associated with the Select object based on value
	 * passed in from the values array. If Select object is null then 0 is returned. If an exception
	 * occurs during the process then 0 is returned. If the process is successful then 1 is returned.
	 * @param select -> Select
	 * @param values -> String[]
	 * @return -> int
	 */
	public static int safeSetSelectMultiOptionsByValue(Select select, String[] values) {
		if(select==null)
			return 0;
		try {
			for(String x:values) {
				select.selectByValue(x);
			}
			return 1;
		}catch(Exception ex) {
			return 0;
		}
	}
	
	/**
	 * Attempts to deselect the option related to the passed in Select object based on
	 * the value of the option. If the Select is null then 0 is returned. If an exception occurs
	 * during the process then 0 is returned. If the process is successful then 1 is returned.
	 * @param select -> Select
	 * @param value -> String
	 * @return -> int
	 */
	public static int safeDeselectSelectOptionByValue(Select select, String value) {
		if(select==null)
			return 0;
		try {
			select.deselectByValue(value);
			return 1;
		}catch(Exception ex) {
			return 0;
		}
	}
}