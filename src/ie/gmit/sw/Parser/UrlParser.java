package ie.gmit.sw.Parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
/**
* URL Parser
* JSoup library to parse text from a URL
* 
* @author Trevor Davies
* @version 1.0
*/

public class UrlParser implements Parseable {
	/**
	* Overridden from Parseable Interface
	* @param file URL address  
	* @return Text from URL as String
	*/

	@Override
	public String parser(String file) throws Exception {
		
		Document doc = Jsoup.connect(file).get();
		String text = doc.body().text();
		return text;
	}

}
