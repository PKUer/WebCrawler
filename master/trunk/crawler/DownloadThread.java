import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.lang.Runnable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


class DownloadThread implements Runnable
{

    private String [] urls;
    private String diskDir = "";
    private String file_suffix = "";
    private boolean overRideOldFile = true; 
    private boolean isDebugging = true;
    private String codec = "UTF-8";
    private int readTimeOutSec;

    private final int BUFFER_SIZE = 8096;   
    private static List<String> failedUrls = 
    	Collections.synchronizedList(new ArrayList<String>());
    
	void setDebugging(boolean isDebugging) {
		this.isDebugging = isDebugging;
	}
	
	void setCodec(String codec){
		this.codec = codec;
	}
    
 
    void setOverRideOldFile(boolean overRide){
    	overRideOldFile = overRide;
    }
    
    void setSuffix(String suffix){
    	file_suffix = suffix;
    }
   
    void setDiskDir(String dir_str){
    	diskDir = dir_str;
    	File dir = new File(diskDir);
		if(!dir.exists()){
			dir.mkdirs();
		}
    }
    
    void setReadTimeOutSec(int readTimeOutSec) {
		this.readTimeOutSec = readTimeOutSec;
	}

    DownloadThread(String []urlList){
    	urls = urlList;
    }
    
    void writePageToDisk(byte[] page, File file) throws Exception{   
    
            FileOutputStream fops = new FileOutputStream(file);   
            fops.write(page);   
            fops.flush();   
            fops.close();   
       
    }   
    
    byte[] readInputStream(InputStream inStream) throws Exception{   
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();   
        byte[] buffer = new byte[BUFFER_SIZE];   
        int len = 0;   
        while( (len=inStream.read(buffer)) != -1 ){   
            outStream.write(buffer, 0, len);   
        }   
        inStream.close();   
        return outStream.toByteArray();   
    }   
    
    byte[] getFileFromNetByUrl(URL url) throws Exception{   
       
        HttpURLConnection conn = (HttpURLConnection)url.openConnection(); 
        conn.setConnectTimeout(readTimeOutSec / 3 * 1000); 
        conn.setReadTimeout(readTimeOutSec * 1000);
        InputStream inStream = conn.getInputStream();
        byte[] btPage = readInputStream(inStream);  
        return btPage;   
    }   
    
	public void run(){
		regist();
		if(this.isDebugging)
			System.out.println("Thread[" + Thread.currentThread().getName() + "] started!");

		for(int i = 0; i < urls.length; ++i){
	        URL url = null;
	        File file = null;
			try {
				url = new URL(urls[i]);
				String fileName = url.getFile();
				fileName = URLDecoder.decode(fileName, codec);	
				fileName = URLEncoder.encode(fileName, codec) + file_suffix;	
				String dirName = diskDir + File.separator+ url.getHost();
				File dir = new File(dirName);
				if(!dir.exists()){
					dir.mkdirs();
				}
				fileName = dirName + File.separator + fileName;
				file = new File(fileName);
				if( overRideOldFile || !file.exists() ){  
					
					if (this.isDebugging)
			            System.out.println("Thread["+ Thread.currentThread().getName()+"]: downloading.... " +
			            		"Url[" + urls[i] + "]");
					
					byte[] btFile = getFileFromNetByUrl(url);   

			        if(null != btFile && btFile.length > 0){   
			            writePageToDisk(btFile, file);   
			        }else{   
			        	throw new Exception("file empty");
			        }   
			       
			        if(this.isDebugging)
			        	System.out.println("Thread["+ Thread.currentThread().getName()+"]: download success. " +
			            		"Saved in file[" + file.getName() + "]");
				}else if(this.isDebugging){
					System.out.println("Thread["+ Thread.currentThread().getName()+"]: download skipped. " +
							"File[" + file.getName() + "] " + "exists in disk!");
				}
			} catch (Exception e) {
				if(this.isDebugging){
					System.out.print("Thread[" + Thread.currentThread().getName()+"]: dowload failed. " +
							"Reason: ");
					System.err.println(e.getMessage());
				}
				if(file!=null && file.exists()){
					if(file.delete() && this.isDebugging)
						System.out.println("Thread[" + Thread.currentThread().getName()+"]: file deleted. " +
								"File[" + file.getAbsolutePath()+"] has been deleted due to failed download!");
				}
				failedUrls.add(url.toString());
			}
	        
		}
		if(this.isDebugging){
			 System.out.println("Thread[" + Thread.currentThread().getName() + "] finished!");
			
		}
		
		unRegist();
	}
	
	private void writeFailUrl(File outFile){

		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		try {
			fos = new FileOutputStream(outFile);
			osw = new OutputStreamWriter(fos, codec);
		
			Iterator<String> it = failedUrls.iterator();
			while(it.hasNext()){
				String next = it.next();
				osw.write(next + "\n");
			}
			osw.close();
			fos.close();
		} catch (IOException e) {
			try {
				osw.close();
				fos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}
		System.out.println("The urls downloaded failed is saved in File[" + outFile.getAbsolutePath() + "].");
		failedUrls.clear();
	}
	

	private static int runningThreads = 0;
	private static long tStart, tEnd;
	
	private synchronized void regist(){  
	        ++runningThreads;  
	        if(runningThreads == 1){
	        	System.out.println("Task begins downloading...[readTimeOut:" + readTimeOutSec + "s]");
	        	tStart = System.currentTimeMillis();  
	        	failedUrls.clear();
	        	Crawler.setFailedUrls(null);
	        }
	}  
	private synchronized void unRegist(){  
	        --runningThreads;
	        if(runningThreads == 0){
	        	System.out.println("Task finished!");
	        	tEnd = System.currentTimeMillis();  
	        	System.out.println("Task time: "+ (tEnd - tStart)/1000.0 + " second!");  
	        	File failFile = new File("failedUrls.txt");
	        	if(!failedUrls.isEmpty()){
	        		Crawler.setFailedUrls(new ArrayList<String>(failedUrls));
	        		writeFailUrl(failFile);
	        	}else{
	        		if(failFile.exists())
	        			failFile.delete();
	        	}
	        		
	        }else if(this.isDebugging){
	        	 System.out.println("There are " + runningThreads + " threads running!");
	        }
	}  
}
