package types;

import java.time.LocalDateTime;
import java.util.Objects;
import utils.Checkers;

public class Tweet implements Comparable<Tweet>{
	private Integer id;
	private Integer favs;
	private Integer rts;
	private LocalDateTime datetime;
	private String text;
	private String url;
	private String name;
	private Double rating;
	private Boolean hasName;
	private dogFame fame;
	private List<> ;
	
	public Tweet(Integer id, Integer favs, Integer rts, LocalDateTime datetime, String text, String url, String name, Double rating) {
		Checkers.check("Incompatible ID",id == 0);
		this.id = id;
		this.favs = favs;
		this.rts = rts;
		this.datetime = datetime;
		Checkers.check("Text can't be blank",text != "");
		this.text = text;
		this.url = url;
		this.name = name;
		this.rating = rating;
	}

	public Tweet(Integer id, Integer favs, Integer rts, LocalDateTime datetime, Double rating) {
		Checkers.check("Incompatible ID",id == 0);
		this.id = id;
		this.favs = favs;
		this.text = "New dog, rating = " + String.valueOf(rating);
		this.rts = rts;
		this.datetime = datetime;
		this.rating = rating;
	}
	
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
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

	public String getUrl() {
		return url;
	}

	public dogFame getFame() {
		if (rts >= 5377) { //top 200
			return dogFame.VERY_HIGH;
		}
		else if (rts >= 2722) { //top 500
			return dogFame.HIGH;
		}
		else if (rts >= 1139) { //top 1000
			return dogFame.MEDIUM;
		}
		else if (rts >= 518) { // top 1500
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
		return Objects.hash(datetime, id, url);
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tweet other = (Tweet) obj;
		return Objects.equals(datetime, other.datetime) && Objects.equals(id, other.id)
				&& Objects.equals(url, other.url);
	}
	
	public int compareTo(Tweet t) {
		int res = this.getDatetime().compareTo(t.getDatetime());
		if (res == 0) {
			res = this.getId().compareTo(t.getId());
		}
		if (res == 0) {
			res = this.getUrl().compareTo(t.getUrl());
		}
		return res;
	}

	
	public String toString() {
		return "Tweet [id=" + id + ", favs=" + favs + ", rts=" + rts + ", datetime=" + datetime + ", text=" + text + ", url=" + url + ", name=" + name + ", rating=" + rating + "]";
	}

}
