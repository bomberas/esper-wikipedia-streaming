package db2.stream.wikipedia.domain;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Revision {

	private Long revision_old;
	private Long revision_new;
	
	public Revision(){
		
	}
	
	public Revision(Long revision_old, Long revision_new) {
		super();
		this.revision_old = revision_old;
		this.revision_new = revision_new;
	}

	@JsonProperty("old")
	public Long getRevision_old() {
		return revision_old;
	}

	public void setRevision_old(Long revision_old) {
		this.revision_old = revision_old;
	}

	@JsonProperty("new")
	public Long getRevision_new() {
		return revision_new;
	}

	public void setRevision_new(Long revision_new) {
		this.revision_new = revision_new;
	}

	@Override
	public String toString() {
		return "Revision [revision_old=" + revision_old + ", revision_new="
				+ revision_new + "]";
	}
}
