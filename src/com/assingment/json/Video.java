package com.assingment.json;

import com.google.gson.annotations.SerializedName;

public class Video {

	@SerializedName("URL")
	private String url;

	@SerializedName("Comp")
	private String comp;

	@SerializedName("Score")
	private String score;

	@SerializedName("VID")
	private String vid;

	public String getUrl() {
		return url;
	}

	public String getComp() {
		return comp;
	}

	public String getScore() {
		return score;
	}

	public String getVid() {
		return vid;
	}

}
