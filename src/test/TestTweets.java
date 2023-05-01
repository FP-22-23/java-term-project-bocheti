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
		testCheckName_stream("Phineas");
		testAverageLikesByName("Phineas");
		testAverageLikesByName("None");
		testAverageLikesByName_stream("None");
		testTweetsPerFame();
		testTweetsPerFame_stream();
		testTweetsInADay(LocalDate.of(2016, 06, 25));
		testTweetsInADay_stream(LocalDate.of(2016, 06, 25));
		testMaxNumberOfWords();
		testNameList();
		
		
		//testTweetsPerYearByLikes(2016);
		//testTweetsPerName();
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
	
	private static void testCheckName_stream(String name) {
		System.out.println("Does the csv contain the name " + name +  "? " + tweets.checkName_stream(name));
	}
	
	private static void testAverageLikesByName_stream(String name) {
		System.out.println("Average likes of tweets with a dog named " + name + " : " + tweets.averageLikesByName_stream(name));
	}
	
	private static void testTweetsInADay_stream(LocalDate d) {
		System.out.println(tweets.tweetsInADay_stream(d));
	}
	
	private static void testMaxNumberOfWords() {
		System.out.println("The tweet with the biggest amount of words has a total of " + tweets.maxNumberOfWords().getWordlist().size() + ", and it is: " + tweets.maxNumberOfWords());
	}
	
	private static void testTweetsPerYearByLikes(Integer year) {
		System.out.println("The most liked tweets in the year " + year + " were: " + tweets.tweetsPerYearByLikes(year));
	}
	
	private static void testTweetsPerFame_stream() {
		System.out.println(tweets.tweetsPerFame_stream());
	}
	
	private static void testNameList() {
		System.out.println("These are all of the names in the dataset: " + tweets.nameList());
	} 
	
	
	

}
