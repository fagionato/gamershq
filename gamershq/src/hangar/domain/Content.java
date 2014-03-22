package hangar.domain;

public class Content {
	
	private Integer id;
	
	private Integer user;
	
	private String text;
	
	private String mediaUri;

	public Content(Integer id, Integer user, String text, String mediaUri) {
		super();
		this.id = id;
		this.user = user;
		this.text = text;
		this.mediaUri = mediaUri;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getMediaUri() {
		return mediaUri;
	}

	public void setMediaUri(String mediaUri) {
		this.mediaUri = mediaUri;
	}
	

}
