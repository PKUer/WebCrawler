import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;


public class Crawler
{
	private static List<String> failedUrls = null;
	
	public static void setFailedUrls(List<String> failUrls) 
	{
		failedUrls = failUrls;
	}
    
    private Thread startAThread(String []subList, String fileSuffix, String diskDir,boolean overRideOldFile,boolean isDebugging, String codec, int readTimeOutSec)
    {
    	DownloadThread dt = new DownloadThread(subList);
		dt.setSuffix(fileSuffix);
   	 	dt.setDiskDir(diskDir);
   	 	dt.setOverRideOldFile(overRideOldFile);
   	 	dt.setDebugging(isDebugging);
   	 	dt.setCodec(codec);
   	 	dt.setReadTimeOutSec(readTimeOutSec);
   	 	Thread thrd = new Thread(dt);
   	 	thrd.start();
   	 	return thrd;
    }
    
    private List<String> beginDownLoad(String []urlList, int thrdNum, String diskDir, 
    		String fileSuffix, boolean overRideOldFile, boolean isDebugging, String codec, int readTimeOutSec) 
    		throws InterruptedException
    {
    	
   	    int thrdSize = (urlList.length - 1) / thrdNum + 1;
		String [] subList = null;
		int i;
		List<Thread> list = new ArrayList<Thread>();  

		for( i = 0; i + thrdSize <= urlList.length; i = i + thrdSize)
		{
			subList = new String[thrdSize];
			subList = Arrays.copyOfRange(urlList, i, i+thrdSize);
			Thread thrd = startAThread(subList, fileSuffix, diskDir, overRideOldFile, isDebugging, codec, readTimeOutSec);
			list.add(thrd);
		}

		if(i != urlList.length)
		{
			subList = new String[urlList.length - i];
			subList = Arrays.copyOfRange(urlList, i, urlList.length);
			Thread thrd = startAThread(subList, fileSuffix, diskDir, overRideOldFile, isDebugging, codec, readTimeOutSec);
			list.add(thrd);
		}
		
        for(Thread thread : list)  
        {  
            thread.join();  
        }  
        
	    return failedUrls;
			
   }
    
    public boolean downloadAll(String []urlList, int thrdNum, String diskDir, 
    		String fileSuffix, boolean overRideOldFile, boolean isDebugging, String codec , int readTimeOutSec) 
    		throws InterruptedException
    {
	
		int numOffailed = urlList.length;
		long tStart = System.currentTimeMillis();  
		List<String> failUrl = beginDownLoad(urlList, thrdNum, diskDir, fileSuffix, overRideOldFile, isDebugging, codec, readTimeOutSec);
		
    	while(failUrl != null)
    	{
    		
    		if(failUrl.size() == numOffailed) 
    		{  
    			if(readTimeOutSec == 0) return false;  
    			readTimeOutSec = readTimeOutSec * 2;
    			if(readTimeOutSec >= 3600) readTimeOutSec = 0;
    		}
    		numOffailed = failUrl.size();
    		
    		String []urlArr = (String [])failUrl.toArray(new String[failUrl.size()]);
    		failUrl = beginDownLoad(urlArr, thrdNum, diskDir, fileSuffix, overRideOldFile, isDebugging, codec, readTimeOutSec);
    	}
    	long tEnd = System.currentTimeMillis(); 
    	System.out.println("Total time: "+ (tEnd - tStart)/1000.0 + " second!");  
		
		return true;
    }

	public void readConfigThenDownload(String configFileName)
	{
		  Properties prop = new Properties();
	      InputStream in;
	      try 
	      {
	           in = getClass().getResourceAsStream(configFileName); 
	           prop.load(in);
	           String className = prop.getProperty("class");

	           Class<?> demo = Class.forName(className);
	           AbstractGenUrl agu = (AbstractGenUrl) demo.newInstance();

	           agu.setProp(prop);
	           String[] urlList = agu.getUrlList();

	           downloadAll(urlList, 
	 	    		   Integer.parseInt(prop.getProperty("threadNum")), 
	 	    		   prop.getProperty("diskDir"), 
	 	    		   prop.getProperty("fileSuffix"), 
	 	    		   Boolean.parseBoolean(prop.getProperty("overRideOldFile")), 
	 	    		   Boolean.parseBoolean(prop.getProperty("isDebugging")),
	 	    		   prop.getProperty("codec"),
	 	    		   Integer.parseInt(prop.getProperty("readTimeOut"))
	 	       );
	       }
	       catch (Exception e) 
	       {
	           e.printStackTrace();
	       } 
	}

	public static void main(String[] args) 
	{
		    
	       String configFile = "crawler.properties";
	       if(args.length > 0)
	       {
	    	   configFile = args[0];
	       }

	       Crawler cl = new Crawler();
	       cl.readConfigThenDownload(configFile);
	}
}
