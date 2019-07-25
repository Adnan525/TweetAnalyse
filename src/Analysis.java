import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.*;
public class Analysis {

	public static void main(String[] args) throws FileNotFoundException {
		File data = new File("tweets.csv");
		Scanner sc = new Scanner(data);
		
		//checking tweet
		int tweetNumber = 0;
		while(sc.hasNextLine())
		{
			String tweet = sc.nextLine();
			String[] twArr = tweet.split(",");
			System.out.println(tweetNumber +". Tweet : "+ twArr[twArr.length-1]);
			tweetNumber++;
		}

	}

}
