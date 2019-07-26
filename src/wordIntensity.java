import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class wordIntensity extends LinkedHashMap<Character,Word> {

	
	public String put(Character c, String value) {
		HashMap<String,Integer> temp = this.get(c);
		//Set indWords = temp.keySet();
		if(temp.containsKey(value))
		{
			temp.put(value,temp.get(value)+1);
		}
		else
			temp.put(value, 1);
		return value;
	}
	

}
