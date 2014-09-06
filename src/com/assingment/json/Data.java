package com.assingment.json;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Data {

	@SerializedName("Games")
	private List<Game> games;

	@SerializedName("Items")
	private List<Item> items;

	public List<Game> getGames() {
		return games;
	}

	public List<Item> getItems() {
		return items;
	}
}
