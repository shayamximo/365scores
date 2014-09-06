package com.assingment.json;

import com.google.gson.annotations.SerializedName;

public class Comp {

	@SerializedName("SName")
	private String shortName;

	@SerializedName("Name")
	private String name;

	public String getDisplayName() {

		return (shortName != null) ? shortName : name;
	}
}
