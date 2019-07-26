//not using now
public class DictionaryElement {

	String word = "";
	int intensity = 0;
	
	public DictionaryElement(String str)
	{
		this.word = str;
		this.intensity = 1;
	}
	
	public void increaseIntensity()
	{
		this.intensity++;
	}
}
