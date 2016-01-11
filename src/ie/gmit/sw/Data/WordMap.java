package ie.gmit.sw.Data;

import java.util.HashMap;
import java.util.Map;

public class WordMap {
	
	private CommonWords cw;
	private Map<String,Integer> unSortedMap = new HashMap<>();
	
	public WordMap(CommonWords cw, String s) {
		super();
		this.cw = cw;
		mapCreator(s);
	}

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
	public Map<String,Integer> getUnSortedMap()
	{
		return this.unSortedMap;
	}

	
}
