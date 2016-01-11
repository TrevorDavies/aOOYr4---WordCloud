package ie.gmit.sw;

import ie.gmit.sw.Data.CommonWords;
import ie.gmit.sw.Data.WordMap;
import ie.gmit.sw.Parser.ParserFactory;

public class Runner {

	public static void main(String[] args) throws Exception {

		ParserFactory pf = ParserFactory.getInstance();
		String testFile = "";
		String testURL = "";
		
		CommonWords cm = new CommonWords("stopwords.txt");
		System.out.println(cm.getHashSet());
		
		testFile = pf.getParseable("WarAndPeace-Tolstoy.txt",ParserFactory.Type.FILE );
		
		WordMap wm = new WordMap(cm, testFile);
		
		System.out.println(wm.getUnSortedMap());
		
		testURL = pf.getParseable("http://www.gmit.ie",ParserFactory.Type.URL );
		WordMap wmUrl = new WordMap(cm, testURL);
		
		System.out.println(wmUrl.getUnSortedMap());
		
		WordCloudGen wcg = new WordCloudGen(wm.getUnSortedMap());
		wcg.Paint(wm.getUnSortedMap());

	}

}
