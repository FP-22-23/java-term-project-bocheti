package test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import types.Tweet;
import types.TweetFactory;
import types.Tweets;

public class TestTweets {
	
	private static Tweets tweets = TweetFactory.readTweets("data/twitter_dogs.csv");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		testGetNumberTweets();
		testCheckName("Bocho");
		testCheckName("Phineas");
		testAverageLikesByName("Phineas");
		testAverageLikesByName("None");
		//testTweetsPerName();
		testTweetsPerFame();
		testTweetsInADay(LocalDate.of(2016, 06, 25));
		
	}
	
	private static void testGetNumberTweets() {
		System.out.println("Read " + tweets.getNumberTweets() + " tweets");
	}
	
	private static void testCheckName(String name) {
		System.out.println("Does the csv contain the name " + name +  "? " + tweets.checkName(name));
	}
	
	private static void testAverageLikesByName(String name) {
		System.out.println("Average likes of tweets with a dog named " + name + " : " + tweets.averageLikesByName(name));
	}
	
	private static void testTweetsPerName(){
		System.out.println(tweets.tweetsPerName());
	}
	
	private static void testTweetsPerFame() {
		System.out.println(tweets.tweetsPerFame());
	}
	
	private static void testTweetsInADay(LocalDate d) {
		System.out.println(tweets.tweetsInADay(d));
	}
	

}
