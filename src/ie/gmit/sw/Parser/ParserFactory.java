package ie.gmit.sw.Parser;
/**
* Parser Factory
* Singleton Factory
* Used to build Strings from URLs or files
* 
* @author Trevor Davies
* @version 1.0
*/

public class ParserFactory {
	
	/**
	* Inner Enum of Types used to tell what type of file to parse
	* At the moment it's only a URL or file
	*/	
	public enum Type
	{
		URL,FILE;
	}

	
	 private static ParserFactory instance = null;
	/**
	* Empty Singleton constructor 
	*/
	   private ParserFactory() { }
	   
	   

	   public static ParserFactory getInstance() 
	   {
	      if(instance == null) 
	      {
	         instance = new ParserFactory();
	      }
	      return instance;
	   }
		/**
		* Returns instance of <code>ParserFactory</code>
		* Singleton
		* 

		* @param s Location of File or URL as String
		* @param t Type of file to be parsed from Inner Enum
		* @return String of parsed text
		* @throws Exception throws an exception
		*/
	   
	   public String getParseable(String s,Type t ) throws Exception
	   {
		   
		   String st = "";
		   switch (t) {
		case URL:
			Parseable p = new UrlParser();
			st = p.parser(s);
			break;
		case FILE:
			Parseable p2 = new FileParser();
			st = p2.parser(s);
			break;
		default:
			break;
		}
		   return st;
		    
	   }
	   
}
