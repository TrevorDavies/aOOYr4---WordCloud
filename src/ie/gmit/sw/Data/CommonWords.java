package ie.gmit.sw.Data;

import java.util.HashSet;
import java.util.Set;


import ie.gmit.sw.Parser.ParserFactory;

public class CommonWords {
	
	ParserFactory pf = ParserFactory.getInstance();
	
	private HashSet<String> stopWords = new HashSet<String>();

	public CommonWords(String f) throws Exception {

		spliterator(pf.getParseable(f, ParserFactory.Type.FILE));
		
	}
	
	private Set<String> spliterator(String s){
		//s.trim();s.toLowerCase();
		String [] words = s.toLowerCase().split("\\W+\\s+");
		for (String string : words) {
			stopWords.add(string);
		}
		return stopWords;
		
	}
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
//	public boolean hasWord(String word)
//	{
//		boolean isThere = false;
//		if(stopWords.contains(word))
//		{
//			isThere = true;
//		}
//		return isThere;
//	}
	
	public HashSet<String> getHashSet()
	{
		return this.stopWords;
	}
	
	/*
	private HashSet<String> stopWords = new HashSet<String>();
	
	private String stopWordsSource = "stopwords.txt";
	
	
	public CommonWords(String fileName) throws Exception
	{	
		fileName = stopWordsSource;

	}

	
	public String parser() throws Exception 
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(stopWordsSource)));
			
			String next;
			
			while((next = br.readLine())!=null)
			{
				next.trim();next.toLowerCase();
				next.split("\\W+|\\s+");
				if(!stopWords.contains(next))
				{
					stopWords.add(next);
				}
				
			}//end while
			br.close();
		}catch(Exception e)
		{
			
		System.out.println(e.getMessage());
		
		}
		return stopWordsSource;
		
	}//end parser
	
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
	public HashSet<String> getHashSet()
	{
		return this.stopWords;
	}


*/
}
