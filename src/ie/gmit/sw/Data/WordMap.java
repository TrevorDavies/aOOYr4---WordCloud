package ie.gmit.sw.Data;

import java.util.HashMap;
import java.util.Map;
/**
* Creates a Map of String and Integer
* The integer value is the number of occurances of each String in the text
* 
* 
* @author Trevor Davies
* @version 1.0
*/

public class WordMap {
	
	private CommonWords cw;
	private Map<String,Integer> unSortedMap = new HashMap<>();
	
	
	
	public WordMap(CommonWords cw, String s) {
		super();
		this.cw = cw;
		mapCreator(s);
	}
	/**
	* Creates a new Map of Strings and Integers 
	* Only adds words that do not occur in stopwords and are more then 3 characters long
	* @param s String of text
	*/
	private void mapCreator(String s) {
		
		String[] words = s.toLowerCase().trim().split("\\W+|\\s+");
		for (String string : words) 
		{
			if(!cw.equals(words))
			{
				if(unSortedMap.containsKey(string) && string.length()>3)
				{
					unSortedMap.put(string, unSortedMap.get(string)+1);
				} else {
					unSortedMap.put(string, 1);
				}
			}
		}//end for (String string : words) 
		
	}
	/**
	 * Method used to return the map
	 * 
	 * @return unSortedMap
	 */
	public Map<String,Integer> getUnSortedMap()
	{
		return this.unSortedMap;
	}

	
}
