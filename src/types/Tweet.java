package types;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import utils.Checkers;

public class Tweet implements Comparable<Tweet>{
	private Integer favs;
	private Integer rts;
	private LocalDateTime datetime;
	private String name;
	private Double rating;
	private Id id;
	private ArrayList<String> wordlist;
	
	// derived: hasName, fame, 
	
	public Tweet(Id id, Integer favs, Integer rts, LocalDateTime datetime, String name, Double rating, ArrayList<String> wordlist) {
		Checkers.check("id can't be null",id != null);
		this.id = id;
		this.favs = favs;
		this.rts = rts;
		this.datetime = datetime;
		this.name = name;
		Checkers.check("rating can't be negative", rating >= 0);
		this.rating = rating;
		this.wordlist = wordlist;
	}

	public Tweet(Id id, Integer favs, Integer rts, LocalDateTime datetime, Double rating) {
		Checkers.check("id can't be null",id != null);
		this.id = id;
		this.favs = favs;
		this.rts = rts;
		this.datetime = datetime;
		this.name = "";
		Checkers.check("rating can't be negative", rating >= 0);
		this.rating = rating;
		this.wordlist = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Id getId() {
		return id;
	}

	public Integer getFavs() {
		return favs;
	}

	public Integer getRts() {
		return rts;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}
	
	public ArrayList<String> getWordlist(){
		return wordlist;
	}
	
	public void addWord(String s) {
		wordlist.add(s);
	}


	public dogFame getFame() {
		if (rts >= 12500) { // ~=top 50
			return dogFame.VERY_HIGH;
		}
		else if (rts >= 4000) { // ~=top 300
			return dogFame.HIGH;
		}
		else if (rts >= 1139) { // ~=top 1000
			return dogFame.MEDIUM;
		}
		else if (rts >= 518) { // ~=top 1500
			return dogFame.LOW;
		}
		else {
			return dogFame.VERY_LOW;
		}
	}
	
	public Boolean getHasName() {
		if (name == "None" || name == "") {
			return false;
		}
		else {
			return true;
		}
	}

	
	public int hashCode() {
		return Objects.hash(datetime, id);
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tweet other = (Tweet) obj;
		return Objects.equals(datetime, other.datetime) && Objects.equals(id, other.id);
	}
	
	public int compareTo(Tweet t) {
		int res = this.getDatetime().compareTo(t.getDatetime());
		if (res == 0) {
			res = this.getId().compareTo(t.getId());
		}
		return res;
	}

	
	public String toString() {
		return "Tweet [id=" + id + ", favs=" + favs + ", rts=" + rts + ", datetime=" + datetime + ", name=" + name + ", rating=" + rating + ", wordlist:" + wordlist + "]";
	}

}
