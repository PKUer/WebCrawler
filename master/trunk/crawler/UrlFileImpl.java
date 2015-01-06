import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class UrlFileImpl extends AbstractGenUrl
{
	@Override
	public String[] getUrlList() 
	{
		String urlFileName = prop.getProperty("urlFileName");
		File file = new File(urlFileName); 
 		BufferedReader reader = null; 
 		ArrayList<String> urlAL = new ArrayList<String>();
 		try { 
 			reader = new BufferedReader(new FileReader(file)); 
 			String aLine;
 			while ((aLine = reader.readLine()) != null){ 
 				urlAL.add(aLine);
 			} 
 			reader.close(); 
 		} catch (IOException e) 
 		{ 
 			e.printStackTrace(); 
 		} finally 
 		{ 
	 		if (reader != null)
	 		{ 
	 			try { 
	 			   reader.close(); 
	 			} catch (IOException e1) {} 
	 		} 
 		} 
 		int urlSize = urlAL.size();
 		return (String [])urlAL.toArray(new String[urlSize]);
	}
}
