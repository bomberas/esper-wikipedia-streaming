package db2.stream.wikipedia.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "log_id", "log_type", "log_action_comment", "log_params", "log_action" })
public class WikiStream {

	private String id;
	private String type;
	private int namespace;
	private String title;
	private String comment;
	private int timestamp;
	private String user;
	private boolean bot;
	private String server_url;
	private String server_name;
	private String server_script_path;
	private String wiki;
	private boolean minor;
	private boolean patrolled;
	private Long log_id;
	private Length length;
	private Revision revision;
	
	public WikiStream() {

	}

	public WikiStream(String id, String type, int namespace, String title,
			String comment, int timestamp, String user, boolean bot,
			String server_url, String server_name, String server_script_path,
			String wiki, boolean minor, boolean patrolled, 
			Length length, Revision revision) {
		super();
		this.id = id;
		this.type = type;
		this.namespace = namespace;
		this.title = title;
		this.comment = comment;
		this.timestamp = timestamp;
		this.user = user;
		this.bot = bot;
		this.server_url = server_url;
		this.server_name = server_name;
		this.server_script_path = server_script_path;
		this.wiki = wiki;
		this.minor = minor;
		this.patrolled = patrolled;
		this.length = length;
		this.revision = revision;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNamespace() {
		return namespace;
	}

	public void setNamespace(int namespace) {
		this.namespace = namespace;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public boolean isBot() {
		return bot;
	}

	public void setBot(boolean bot) {
		this.bot = bot;
	}

	public String getServer_url() {
		return server_url;
	}

	public void setServer_url(String server_url) {
		this.server_url = server_url;
	}

	public String getServer_name() {
		return server_name;
	}

	public void setServer_name(String server_name) {
		this.server_name = server_name;
	}

	public String getServer_script_path() {
		return server_script_path;
	}

	public void setServer_script_path(String server_script_path) {
		this.server_script_path = server_script_path;
	}

	public String getWiki() {
		return wiki;
	}

	public void setWiki(String wiki) {
		this.wiki = wiki;
	}

	public boolean isMinor() {
		return minor;
	}

	public void setMinor(boolean minor) {
		this.minor = minor;
	}

	public boolean isPatrolled() {
		return patrolled;
	}

	public void setPatrolled(boolean patrolled) {
		this.patrolled = patrolled;
	}

	public Long getLog_id() {
		return log_id;
	}

	public void setLog_id(Long log_id) {
		this.log_id = log_id;
	}

	public Length getLength() {
		return length;
	}

	public void setLength(Length length) {
		this.length = length;
	}

	public Revision getRevision() {
		return revision;
	}

	public void setRevision(Revision revision) {
		this.revision = revision;
	}

	@Override
	public String toString() {
		return "WikiStream [id=" + id + ", type=" + type + ", namespace="
				+ namespace + ", title=" + title + ", comment=" + comment
				+ ", timestamp=" + timestamp + ", user=" + user + ", bot="
				+ bot + ", server_url=" + server_url + ", server_name="
				+ server_name + ", server_script_path=" + server_script_path
				+ ", wiki=" + wiki + ", minor=" + minor + ", patrolled="
				+ patrolled + ", log_id=" + log_id  
				+ ", length=" + length + ", revision=" + revision + "]";
	}

}
