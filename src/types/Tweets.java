package types;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
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
		
		public Tweets(List<Tweet> l) {
			tweets = new ArrayList<Tweet>(l);
		}
		
		public Tweets() {
			tweets = new ArrayList<Tweet>();
		}
		
		public Tweets(Stream<Tweet> ts) {
			tweets = ts.collect(Collectors.toList());
		}
		
		public String toString() {
			return "Tweets [tweets=" + tweets + "]";
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
		
		//c) returns Tweets filtered by Date
		
		public Tweets tweetsInADay(LocalDate day) {
			List<Tweet> res = new ArrayList<Tweet>();
			for(Tweet i:tweets) {
				if(i.getDatetime().toLocalDate().equals(day)) {
					res.add(i);
				}
			}
			return new Tweets(res);
		}
		
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
		
		//e) returns Map<dogFame,Integer>
		
		public Map<dogFame,Integer> tweetsPerFame(){
			SortedMap<dogFame,Integer> res = new TreeMap<dogFame,Integer>();
			SortedSet<dogFame> fameset = new TreeSet<dogFame>();
			for (Tweet i:tweets) {
				fameset.add(i.getFame());
			}
			for(dogFame fame:fameset) {
				List<Tweet> tweetlist = new ArrayList<Tweet>();
				for(Tweet i:tweets) {
					if(i.getFame().equals(fame)) {
						tweetlist.add(i);
					}
				}
			res.put(fame, tweetlist.size());
			}
			return res;
		}
	
		
		
		
		
		//Delivery 3
		//Part 1
		
		//1 exists (with streams)
		
		public Boolean checkName_stream(String name) {
			return tweets.stream().anyMatch(x -> x.getName().equals(name));
		}
		
		//2 average (with streams)
		
		public Double averageLikesByName_stream(String name) {
			return Double.valueOf(tweets.stream().filter(x -> x.getName().equals(name)).mapToInt(x -> x.getFavs()).sum()/tweets.stream().filter(x -> x.getName().equals(name)).count()); 
		}
		
		//3 filter (with streams)
		
		public Tweets tweetsInADay_stream(LocalDate day) {
			return new Tweets(tweets.stream().filter(x -> x.getDatetime().toLocalDate().equals(day)).toList());
		}
		
		//4 max
		
		public Tweet maxNumberOfWords() {
			return tweets.stream().max(Comparator.comparing(x -> x.getWordlist().size())).orElse(null);
		}
		
		//5 filtering + sorted
		
		public Tweets tweetsPerYearByLikes(Integer year) {
			return new Tweets(tweets.stream().filter(x -> Integer.valueOf(x.getDatetime().getYear()).equals(year)).sorted(Comparator.comparing(x -> x.getFavs())).sorted(Comparator.reverseOrder()));
		}
		
		
		//Part 2
		
		//6 method 5 delivery 2 (with streams)
		
		public Map<dogFame,Long> tweetsPerFame_stream() {
			return new TreeMap<>(tweets.stream().collect(Collectors.groupingBy(x->x.getFame(),Collectors.counting())));
		}
		
		//7 mapping
		
		public SortedSet<String> nameList(){
			return new TreeSet<>(tweets.stream().filter(x -> x.getHasName()).collect(Collectors.mapping(x -> x.getName(), Collectors.toSet())));
		}
		
		//8 map using max
		
		public Map<String,Tweet> mostRTdTweetPerName() {
			Map<String,List<Tweet>> map = tweets.stream().filter(x -> x.getHasName()).collect(Collectors.groupingBy(x->x.getName()));
			Map<String,Tweet> res = new TreeMap<>();
			for (String name:map.keySet()) {
				res.put(name,map.get(name).stream().max(Comparator.comparing(x -> x.getRts())).orElse(null));
			}
			return res;
		} 
		
		//9 sortedMap 
		
		public SortedMap<Integer,List<Tweet>> nBestRatingPerYear(Integer n) {
			Map<Integer,List<Tweet>> map = tweets.stream().collect(Collectors.groupingBy(x->Integer.valueOf(x.getDatetime().getYear())));
			SortedMap<Integer,List<Tweet>> res = new TreeMap<>();
			for (Integer y:map.keySet()) {
				res.put(y,map.get(y).stream().sorted(Comparator.comparing(x -> x.getRating())).toList().subList(0, n));
			}
			return res;
		} 
		
		//10 lowest from map
		
		public Id lowestRatedTweetId() {
			Map<Id,List<Tweet>> map = tweets.stream().filter(x -> x.getHasName()).collect(Collectors.groupingBy(x->x.getId()));
			Map<Id,Tweet> map2 = new TreeMap<>();
			for (Id id:map.keySet()) {
				map2.put(id,map.get(id).stream().min(Comparator.comparing(x -> x.getRating())).orElse(null));
			}
			//Tweet tw = map2.values().stream().min(Comparator.comparing(x -> x.getRating())).get();
			return map2.keySet().stream().filter(x -> x.equals( map2.values().stream().min(Comparator.comparing(y -> y.getRating())).get().getId())).findFirst().get();
		}
		
		
		
		
		
		
		
		
		
}

