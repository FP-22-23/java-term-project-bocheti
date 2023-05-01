package types;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import utils.Checkers;


public class TweetFactory {
	
	public static List<Tweet> readTweets_toList(String fileName) {
		List<Tweet> tweets = null;
		
		try {
			List<Tweet> tws = Files.lines(Paths.get(fileName)).skip(1).map(TweetFactory::parseLine).toList();
			tweets = new ArrayList<>(tws);
		}catch(IOException e){
			System.out.println("Error with the file" + fileName);
			e.printStackTrace();
		}
		return tweets;
		
	}
	
	public static Tweets readTweets(String fileName) {
		Tweets tws = new Tweets(TweetFactory.readTweets_toList(fileName));
		return tws;
	}
	
	public static Tweet parseLine(String line) {
		//separate the line using ,
		String[] values = line.split(",");
		//check size of the array
		Checkers.check("Invalid number of values, has " + values.length, values.length == 8);
		//obtain attributes of the tweet
		Id id = new Id(values[0],values[5]);
		
		Integer favs = Integer.valueOf(values[1]);
		
		Integer rts = Integer.valueOf(values[2]);
		
		LocalDateTime timestamp = LocalDateTime.parse(values[3].substring(0, 19), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		
		String name = values[6].trim();
		
		Double rating = Double.valueOf(values[7]);
		
		ArrayList<String> wordlist = new ArrayList<String>();
		String[] splitted = values[4].split(" ");
		for (String i:splitted) {
			wordlist.add(i.replace(".", "").trim());
		}
		wordlist.remove(wordlist.size()-1); //removed URL from wordlist
		//create tweet object
		Tweet tw = new Tweet(id,favs,rts,timestamp,name,rating,wordlist);
		return tw;
	}

}
