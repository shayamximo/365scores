package com.assingment.json;

import com.google.gson.annotations.SerializedName;

public class Item {

	@SerializedName("ImageSource")
	private String imageSource;

	@SerializedName("Title")
	private String title;

	@SerializedName("Description")
	private String description;

	@SerializedName("HasVideo")
	private boolean hasVideo;

	public String getImageSource() {
		return imageSource;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public boolean isHasVideo() {
		return hasVideo;
	}

}
