package ie.gmit.sw.Parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class UrlParser implements Parseable {

	@Override
	public String parser(String file) throws Exception {
		
		Document doc = Jsoup.connect(file).get();
		String text = doc.body().text();
		return text;
	}

}
