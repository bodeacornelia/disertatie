package com.entity;

public class Photo {

	private String tag;
	private String location;
	private String path;

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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Photo [tag=" + tag + ", location=" + location + ", path=" + path + "]";
	}

}
