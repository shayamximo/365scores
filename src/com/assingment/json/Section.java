package com.assingment.json;

import com.google.gson.annotations.SerializedName;

public class Section {

	@SerializedName("Data")
	private Data data;

	@SerializedName("Name")
	private String name;

	public Data getData() {
		return data;
	}

	public String getName() {
		return name;
	}

}
