class UrlPageStringImpl extends AbstractGenUrl 
{
	@Override
	public String[] getUrlList() 
	{
		int startP = Integer.parseInt(prop.getProperty("startPageNum"));
		int endP = Integer.parseInt(prop.getProperty("endPageNum"));
		String headUrl  = prop.getProperty("headUrl");
		String tailUrl = prop.getProperty("tailUrl");
		String[] urlList = new String[endP - startP];
   	 	int urlCounter = 0;
   	 	for(int i = startP; i < endP; ++i)
   	 	{
   	 		urlList[urlCounter++] = headUrl + i + tailUrl;
   	 	}
   	 	return urlList;
	}
}
