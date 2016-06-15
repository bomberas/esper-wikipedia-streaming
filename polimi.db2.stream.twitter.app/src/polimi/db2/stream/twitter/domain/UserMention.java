package polimi.db2.stream.twitter.domain;

public class UserMention {
	
	 private int[] indices;
	 private String name;
     private int id;
     private String screen_name;
     private String id_str;
	public int[] getIndices() {
		return indices;
	}
	public void setIndices(int[] indices) {
		this.indices = indices;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int isId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getScreen_name() {
		return screen_name;
	}
	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}
	public String getId_str() {
		return id_str;
	}
	public void setId_str(String id_str) {
		this.id_str = id_str;
	}
	
	
	
	
	
	
}




