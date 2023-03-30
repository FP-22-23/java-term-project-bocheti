package types;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.stream.Stream;

import utils.Checkers;


public class TweetFactory {
	
	public static Tweets readRoutes(String fileName) {
		Tweets tweets = null;
		
		try {
			Stream<Tweet> tws = Files.lines(Paths.get(fileName)).skip(1).map(TweetFactory::parseLine);
			tweets = new Tweets(tws);
		}catch(IOException e){
			System.out.println("Error with the file" + fileName);
			e.printStackTrace();
		}
		return tweets;
		
	}
	
	public static Tweet parseLine(String line) {
		//separate the line using ,
		String[] values = line.split(",");
		//check size of the array
		Checkers.check("Error in line", values.length == 8);
		//obtain attributes of the tweet
		Id id = new Id(values[0],values[5]);
		Integer favs = Integer.valueOf(values[1]);
		Integer rts = Integer.valueOf(values[2]);
		LocalDateTime timestamp = LocalDateTime.parse(values[3].substring(0, 19), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String name = values[6];
		Double rating = Double.valueOf(values[7]);
		ArrayList<String> wordlist = new ArrayList<String>();
		//create tweet object
		Tweet tw = new Tweet(id,favs,rts,timestamp,name,rating,wordlist);
		return tw;
	}

}
