
public class DataCleansing {
	static String[] stopWords = {"am", "is", "are", "was", "were", "it's", "a", "an", "the", "so", "at", "with"};
	static String punctuations = ".,!:;";
	
	//replace punctuations
	public static String repPunc(String str)
	{
		String[] test = str.split(" ");
		String temp = "";
		for(String item : test)
		{
			if(item.contains(punctuations))
			{
				item = "";
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
				if(item.equals(" "))
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
}
