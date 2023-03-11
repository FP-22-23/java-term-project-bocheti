package test;

import java.time.LocalDateTime;

import types.Id;
import types.Tweet;

public class TestTweet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Id id1 = new Id("12345","https://");
		Tweet t1 = new Tweet(id1,5000,2750,LocalDateTime.now(),1.5);
		System.out.println(t1.getName());
		System.out.println(t1.getClass());
		System.out.println(t1.getFavs());
		System.out.println(t1.getHasName());
		System.out.println(t1.getRts());
		System.out.println(t1.getDatetime());
		System.out.println(t1.getFame());
		System.out.println(t1.getId());
		System.out.println(t1.getWordlist());
		t1.setName("Bocho");
		System.out.println(t1.getName());
		t1.addWord("Pup");
		System.out.println(t1.getWordlist());
		
	}

}
