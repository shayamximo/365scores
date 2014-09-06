package com.assingment.json;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Store {

	@SerializedName("Sections")
	private List<Section> sections;

	public List<Section> getSections() {
		return sections;
	}
}
