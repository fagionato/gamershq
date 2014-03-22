package hangar.bean;

import hangar.domain.Content;

import java.util.ArrayList;
import java.util.List;

public class DataBean {
	
	private List<Content> extFeed;
	
	private List<Content> intFeed;
	
	public DataBean(){
		extFeed = new ArrayList<Content>();
		intFeed = new ArrayList<Content>();
		
		intFeed.add(new Content(1, 1, "ajdhgfjkasdgfjsdhgfjsdgfjsdgfjsdhgf", null));
		intFeed.add(new Content(1, 1, "ajdhgfjkasdgfjsdhgfjsdgfjsdgfjsdhgf", null));
		intFeed.add(new Content(1, 1, "ajdhgfjkasdgfjsdhgfjsdgfjsdgfjsdhgf", null));
		intFeed.add(new Content(1, 1, "ajdhgfjkasdgfjsdhgfjsdgfjsdgfjsdhgf", null));
		
		extFeed.add(new Content(1, 1, "ajdhgfjkasdgfjsdhgfjsdgfjsdgfjsdhgf", null));
		extFeed.add(new Content(1, 1, "ajdhgfjkasdgfjsdhgfjsdgfjsdgfjsdhgf", null));
		extFeed.add(new Content(1, 1, "ajdhgfjkasdgfjsdhgfjsdgfjsdgfjsdhgf", null));
		extFeed.add(new Content(1, 1, "ajdhgfjkasdgfjsdhgfjsdgfjsdgfjsdhgf", null));
	}

	public List<Content> getExtFeed() {
		return extFeed;
	}

	public List<Content> getIntFeed() {
		return intFeed;
	}
}
