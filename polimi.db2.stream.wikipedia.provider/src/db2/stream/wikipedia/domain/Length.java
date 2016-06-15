package db2.stream.wikipedia.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Length {
	
	private Long lenght_old;
	private Long length_new;
	
	public Length(){
		
	}
	
	public Length(Long lenght_old, Long length_new) {
		super();
		this.lenght_old = lenght_old;
		this.length_new = length_new;
	}
	
	@JsonProperty("old")
	public Long getLenght_old() {
		return lenght_old;
	}
	
	public void setLenght_old(Long lenght_old) {
		this.lenght_old = lenght_old;
	}
	
	@JsonProperty("new")
	public Long getLength_new() {
		return length_new;
	}
	
	public void setLength_new(Long length_new) {
		this.length_new = length_new;
	}

	@Override
	public String toString() {
		return "Length [lenght_old=" + lenght_old + ", length_new="
				+ length_new + "]";
	}

}
