package ie.gmit.sw.Data;

import java.util.HashSet;
import java.util.Set;


import ie.gmit.sw.Parser.ParserFactory;
/**
* Creates a list of common words to be excluded from parsed Maps.
* Uses ParserFactory to parse the file using the FileParser
*
* @author Trevor Davies
* @version 1.0
*/

public class CommonWords {
	
	ParserFactory pf = ParserFactory.getInstance();
	
	private HashSet<String> stopWords = new HashSet<String>();

	
	public CommonWords(String f) throws Exception {

		spliterator(pf.getParseable(f, ParserFactory.Type.FILE));
		
	}
	/**
	 * Method used to add parsed file to stopwords
	 * 
	 * @param s String set toLowerCase 
	 * @return stopWords HashSet
	 */
	private Set<String> spliterator(String s){
		//s.trim();s.toLowerCase();
		String [] words = s.toLowerCase().split("\\W+\\s+");
		for (String string : words) {
			stopWords.add(string);
		}
		return stopWords;
		
	}
	/**
	* Method used to check if a String is in the list of stopwords
	* 
	*
	* @param word String of a single word character
	* @return <code>true</code> if <code>Set</code> contains String<code>false</code> if not
	*/
	public boolean containsWords(String word)
	{
		if(stopWords.contains(word))
		{
			return stopWords.contains(word);
		}
		else 
		{
			return false;
		}
	}
	/**
	* A method to return the stopwords set
	* 
	* @return  <code>Set</code> of Strings
	* 
	*/
	
	public HashSet<String> getHashSet()
	{
		return this.stopWords;
	}
	

}
