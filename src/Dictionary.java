import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Dictionary extends LinkedHashMap<Character,ArrayList<DictionaryElement>> {
	
	static int current = -1;

	//runs once to populate
	public Dictionary()
	{
		for(Character i = 97; i<=122;i++)
			this.put(i,new ArrayList<DictionaryElement>());
			
	}
	
	public static boolean checkExist(ArrayList<DictionaryElement> al, String str)
	{
		for(int i = 0; i <= al.size()-1; i++)
		{
			if(al.get(i).word.equals(str))
			{
				current = i;
				return true;
			}
		}
		return false;
	}
	
	public void addWords(Character c, String str) {
		ArrayList<DictionaryElement> temp = this.get(c);
		if(temp == null)
		{
			return;
		}
		if(Dictionary.checkExist(temp, str))
				{
					temp.get(current).intensity+=1;
					current = -1;
				}
		else
		{
			this.get(c).add(new DictionaryElement(str));
		}
//				temp.put(value,temp.get(value)+1);
//			}
//			else
//				temp.put(value, 1);
//		}
//		else {
//			Word w =null;
//			this.put(c, w);
//		}//Set indWords = temp.keySet();
	}
	

}
