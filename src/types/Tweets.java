package types;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
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
		
		// a) exists
		public Boolean checkName(String name) { 
			Boolean ex = false;
			for (Tweet i:tweets) {
				if(i.getHasName()) {
					if(i.getName().equals(name)) {
						ex = true;
						break;
					}
				}	
			}
			return ex;
		}
		
		//b) average
		
		public Double averageLikesByName(String name) {
			Double sum = 0.0;
			Integer cont = 0;
			for (Tweet i:tweets) {
				if (i.getName().equals(name)) {
					sum += i.getFavs();
					cont ++;
				}
			}
			return sum/cont;
		}
		
		//c)
		
		
		
		//d) returns Map<String(name),List<Tweet>>
		
		public Map<String,List<Tweet>> tweetsPerName(){
			SortedMap<String,List<Tweet>> res = new TreeMap<String,List<Tweet>>();
			SortedSet<String> nameset = new TreeSet<String>();
			for (Tweet i:tweets) {
				nameset.add(i.getName());
			}
			for(String name:nameset) {
				List<Tweet> tweetlist = new ArrayList<Tweet>();
				for(Tweet i:tweets) {
					if(i.getName().equals(name)) {
						tweetlist.add(i);
					}
				}
			res.put(name, tweetlist);
			}
			return res;
		}
		
		//e) returns Map<>
		
		
		
		
		
		
		
		
}

