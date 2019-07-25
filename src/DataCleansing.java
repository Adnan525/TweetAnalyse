
public class DataCleansing {
	static String[] stopWords = {"am", "is", "are", "was", "were", "it's", "a", "an", "the", "so", 
			"at", "with", "in", "english", "translation:", "of", "please"};
	static String[] punctuations = {".", ",", "!", ":", "'", "\"", ";"};
	
	
	//replace punctuations
	public static String repPunc(String str)
	{
		String[] test = str.split(" ");
		String temp = "";
		for(String item : test)
		{
			//change to lower case
			item = item.toLowerCase();
			
			for(String punc : punctuations)
			{
				if(item.contains(punc))
				{
//					int index = item.indexOf(punc);
					item = item.replace(punc, "");
//					String[] fixPunc = item.split(punc);
//					for(int i =0; i <= fixPunc.length - 1; i++)
//					{
//						item = fixPunc[i];
//					}
					
				}
			}
			temp+=item +" ";
		}
		return temp;
	}
	//remove stop words
	public static String clean(String str)
	{
		String temp = "";
		String test = repPunc(str);
		String[] noPunc = test.split(" ");
		for(String item : noPunc)
		{
			for(String stopItem : stopWords)
			{
				if(item.equals(" ") || item.contains("http"))
				{
					item = "";
				}
				else if(item.equals(stopItem))
				{
					item = "";
				}
			}
			temp+=item +" ";
		}
		return temp;
	}
	
	//test
//	public static void main(String[] args)
//	{
//		String str = "Adnaan.";
//		System.out.println(str);
//		str = str.toLowerCase();
//		String st = str.replace(".", " ");
//		System.out.println(st);
//		
//	}
}
