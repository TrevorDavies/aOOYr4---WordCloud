package ie.gmit.sw.Parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileParser implements Parseable {

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


