package com.pyazdani.grouplanguages.models;

import javax.validation.constraints.Size;

public class Language {
	@Size(min = 2, max = 20, message="Name must be between 2-20 characters.")
	private String name;
	
	@Size(min = 2, max = 20, message="Creator must be between 2-20 characters.")
	private String creator;
	
	@Size(min=1, message="Please enter a version.")
	private String version;
	
	private int thisid;
	
	public Language() {
	}
	public Language(String name, String creator, String version, int thisid) {
		this.name = name;
		this.creator = creator;
		this.version = version;
		this.thisid = thisid;

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public int getThisid() {
		return thisid;
	}
	public void setThisid(int thisid) {
		this.thisid = thisid;
	}

}
