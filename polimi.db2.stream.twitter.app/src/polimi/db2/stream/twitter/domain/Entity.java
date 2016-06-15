package polimi.db2.stream.twitter.domain;

public class Entity {

	private String[] urls;
	private String[] hashtags;
	private UserMention[] user_mentions;
	public String[] getUrls() {
		return urls;
	}
	public void setUrls(String[] urls) {
		this.urls = urls;
	}
	public String[] getHashtags() {
		return hashtags;
	}
	public void setHashtags(String[] hashtags) {
		this.hashtags = hashtags;
	}
	public UserMention[] getUser_mentions() {
		return user_mentions;
	}
	public void setUser_mentions(UserMention[] user_mentions) {
		this.user_mentions = user_mentions;
	}
   
	
	


}
