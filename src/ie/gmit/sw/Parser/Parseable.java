package ie.gmit.sw.Parser;
/**
* Parsable Interface
* Takes in a location of file or url to parse
* returns a string
* 
* @author Trevor Davies
* @version 1.0
*/
public interface Parseable {
	public String parser(String file) throws Exception;
}
