package types;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Tweets {
		
		private List<Tweet> tweets;
		
		public Tweets(Stream<Tweet> st) {
			tweets = st.collect(Collectors.toList());
		}
		
		public Tweets() {
			tweets = new ArrayList<Tweet>();
		}
		
		public Integer getNumberTweets() {
			return tweets.size();
		}
		
		public void addTweet(Tweet t) {
			tweets.add(t);
		}
	
		public void addAllTweets(List<Tweet> tweetlist) {
			tweets.addAll(tweetlist);
		}
		
		public void deleteTweet(Tweet t) {
			tweets.remove(t);
		}
		
		public void deleteTweet(int i) {
			tweets.remove(i);
		}
		
		
		
		
		
		
}

