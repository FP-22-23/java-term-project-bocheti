package types;

import utils.Checkers;

public record Id(String id,String url) implements Comparable<Id>{

	public Id(String id, String url) {
		Checkers.check("id can't be null", id != "");
		this.id = id;
		Checkers.check("url can't be null", url != "");
		this.url = url;
	}
	
	public int compareTo(Id i) {
		int res = this.id().compareTo(i.id());
		if (res == 0) {
			res = this.url().compareTo(i.url());
		}
		return res;
	}
	
}
