package ie.gmit.sw.Parser;



public class ParserFactory {
	public enum Type
	{
		URL,FILE;
	}

	
	 private static ParserFactory instance = null;
	 
	   protected ParserFactory() { }
	   
	   

	   public static ParserFactory getInstance() 
	   {
	      if(instance == null) 
	      {
	         instance = new ParserFactory();
	      }
	      return instance;
	   }
	   
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
