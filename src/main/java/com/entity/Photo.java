package com.entity;

public class Photo {

	private String tag;
	private String location;

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Photo [tag=" + tag + ", location=" + location + "]";
	}

}
