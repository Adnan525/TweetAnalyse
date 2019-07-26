import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.*;

public class Analysis {
	static Dictionary dataset = new Dictionary();
	
	public static void makeDictionary(Dictionary hash, String str)
	{
		String[] temp = str.split(" ");
		for(String s : temp)
		{
			if(!s.isEmpty())
			hash.addWords(s.charAt(0), s);
		}
	}
	
	public static int check(Dictionary dataset, String str)
	{
		int answer = 0;
		String[] words = str.split(" ");
		for(String st : words)
		{
			for(DictionaryElement w : dataset.get(st.charAt(0)))
			{
				if(w.word.equals(st))
				{
					answer+=w.intensity;
				}
			}
		}
		return answer/words.length-1;
	}
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
	//	index
		//dictionary has a to z
		
		File data = new File("tweets.csv");
		Scanner sc = new Scanner(data);
		
		//write to the file
		PrintWriter writeTweet = new PrintWriter("tweetOnly.txt", "UTF-8");
		
		
		//checking tweet
		int tweetNumber = 0;
		while(sc.hasNextLine())
		{
			String wholeTweet = sc.nextLine();
			String[] twArr = wholeTweet.split(",");
			String tweet = DataCleansing.clean(twArr[twArr.length-1]);
			
			
			if(tweet.isEmpty() || tweet.equals(" "))
			{
				//do nothing
				//System.out.println("empty tweet");
			}
			else
			{
				makeDictionary(dataset, tweet);
				//writeTweet.println(tweetNumber +". Tweet : "+ tweet +"\n");
				writeTweet.println(tweet +"\n");
				//tweetNumber++;
			}
			
		}
		
		//main test
		while(true)
		{
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Type your sentence in, no signs/punctuations allowed and all the letter have to be lowercase.");
			String line = keyboard.nextLine();
			
			if(line.equals("exit"))
			{
				System.out.println("Good Bye!");
				break;
			}
			
			System.out.println(check(dataset, line));
			
		}
		

		


	}
	
	
//	public static void putTweetInList(String T) {
//		T=T.toLowerCase();
//		if(T.isEmpty() || T.equals(" "))
//			return;
//		else {
//			int i = T.indexOf(" ");
//			if(i==0) i = T.length()-1;
//			Character c = T.charAt(0);
//			dataset.put(c,T.substring(0,i));
//			putTweetInList(T.substring(i));
//		}
//		
//	}
}
