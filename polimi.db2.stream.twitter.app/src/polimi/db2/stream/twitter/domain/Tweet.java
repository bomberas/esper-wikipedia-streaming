package polimi.db2.stream.twitter.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "log_id", "log_type", "log_action_comment", "log_params", "log_action" })


public class Tweet {
	
	private int retweet_count;
	private String text;
	private Entity entities;
	private boolean retweeted;
	private String in_reply_to_status_id_str;
	private String place;
	private String in_reply_to_user_id_str;
	private String coordinates;
	private String source;
	private String in_reply_to_screen_name;
	private String in_reply_to_user_id;
	private String in_reply_to_status_id;
	private boolean favorited;
	private String contributors;
	private String geo;
	private boolean truncated;
	private String created_at;
	private User user;
	private int id;
	private String id_str;
	private boolean hasPicture;
	
	
	
	public int getRetweet_count() {
		return retweet_count;
	}
	public void setRetweet_count(int retweet_count) {
		this.retweet_count = retweet_count;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Entity getEntities() {
		return entities;
	}
	public void setEntities(Entity entities) {
		this.entities = entities;
	}
	public boolean isRetweeted() {
		return retweeted;
	}
	public void setRetweeted(boolean retweeted) {
		this.retweeted = retweeted;
	}
	public String getIn_reply_to_status_id_str() {
		return in_reply_to_status_id_str;
	}
	public void setIn_reply_to_status_id_str(String in_reply_to_status_id_str) {
		this.in_reply_to_status_id_str = in_reply_to_status_id_str;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getIn_reply_to_user_id_str() {
		return in_reply_to_user_id_str;
	}
	public void setIn_reply_to_user_id_str(String in_reply_to_user_id_str) {
		this.in_reply_to_user_id_str = in_reply_to_user_id_str;
	}
	public String getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getIn_reply_to_screen_name() {
		return in_reply_to_screen_name;
	}
	public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
		this.in_reply_to_screen_name = in_reply_to_screen_name;
	}
	public String getIn_reply_to_user_id() {
		return in_reply_to_user_id;
	}
	public void setIn_reply_to_user_id(String in_reply_to_user_id) {
		this.in_reply_to_user_id = in_reply_to_user_id;
	}
	public String getIn_reply_to_status_id() {
		return in_reply_to_status_id;
	}
	public void setIn_reply_to_status_id(String in_reply_to_status_id) {
		this.in_reply_to_status_id = in_reply_to_status_id;
	}
	public boolean isFavorited() {
		return favorited;
	}
	public void setFavorited(boolean favorited) {
		this.favorited = favorited;
	}
	public String getContributors() {
		return contributors;
	}
	public void setContributors(String contributors) {
		this.contributors = contributors;
	}
	public String getGeo() {
		return geo;
	}
	public void setGeo(String geo) {
		this.geo = geo;
	}
	public boolean isTruncated() {
		return truncated;
	}
	public void setTruncated(boolean truncated) {
		this.truncated = truncated;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getId_str() {
		return id_str;
	}
	public void setId_str(String id_str) {
		this.id_str = id_str;
	}
	
	public boolean isHasPicture() {
		return hasPicture;
	}
	public void setHasPicture(boolean hasPicture) {
		this.hasPicture = hasPicture;
	}
	public Tweet(int retweet_count, String text, boolean retweeted,
			String place, String source, boolean favorited, String geo,
			boolean truncated, String created_at, boolean hasPicture) {
		super();
		this.retweet_count = retweet_count;
		this.text = text;
		this.retweeted = retweeted;
		this.place = place;
		this.source = source;
		this.favorited = favorited;
		this.geo = geo;
		this.truncated = truncated;
		this.created_at = created_at;
		this.hasPicture = hasPicture;
	}
	
	@Override
	public String toString() {
		return "Tweet [retweet_count=" + retweet_count + ", text=" + text
				+ ", retweeted=" + retweeted + ", place=" + place + ", source="
				+ source + ", favorited=" + favorited + ", geo=" + geo
				+ ", truncated=" + truncated + ", created_at=" + created_at
				+ ", hasPicture=" + hasPicture + "]";
	}
	
	
	
	}
	
	
