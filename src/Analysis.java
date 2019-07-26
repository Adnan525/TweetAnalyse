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

import org.jvnet.hk2.component.MultiMap;
public class Analysis {
	static wordIntensity tweets = new wordIntensity();
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		for(Character i = 97; i<122;i++) tweets.put(i,"");
		
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
				putTweetInList(tweet);
				//writeTweet.println(tweetNumber +". Tweet : "+ tweet +"\n");
				writeTweet.println(tweet +"\n");
				//tweetNumber++;
			}
			
		}

	}
	
	public static void putTweetInList(String T) {
		T=T.toLowerCase();
		if(T.isEmpty() || T.equals(" "))
			return;
		else {
			int i = T.indexOf(" ");
			Character c = T.charAt(0);
			tweets.put(c,T.substring(0,i));
			putTweetInList(T.substring(i));
		}
		
	}
}
