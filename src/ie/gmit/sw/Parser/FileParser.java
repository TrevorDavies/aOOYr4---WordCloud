package ie.gmit.sw.Parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
/**
* Parses a file from a location and returns text
* Implements Parseable interface
* 
* 
* @author Trevor Davies
* @version 1.0
*/

public class FileParser implements Parseable {
	
	/**
	* Method Overridden from Parseable Interface
	* Builds Strings from URLs or files
	* Uses buffer to read and StringBuilder to create String
	* Singleton Factory
	* @param file File location
	* @return Text as a String from file
	* @throws Exception Exception e
	*/

	@Override
	public String parser(String file) throws Exception {
		StringBuffer sb = new StringBuffer();
		
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

			String line = br.readLine().toLowerCase();

			while(line!=null)
			{
				
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
											
			}//end while
			
			br.close();
						
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		

		return sb.toString();
	}
}


