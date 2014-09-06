package com.assingment.json;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Game {

	@SerializedName("STime")
	private String timeOfGame;

	@SerializedName("Scrs")
	private List<Integer> scores;

	@SerializedName("Comps")
	private List<Comp> comps;

	@SerializedName("HasVideo")
	private Boolean hasVideo;

	public String getTimeOfGame() {
		return timeOfGame;
	}

	public List<Integer> getScores() {
		return scores;
	}

	public Comp getCompOne() {
		return comps.get(0);
	}

	public Comp getCompTwo() {
		return comps.get(1);
	}

	public Boolean getHasVideo() {
		return hasVideo;
	}

	public String getDateReadableFormat() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		Date date = null;
		try {
			date = formatter.parse(timeOfGame);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String retString = " " + date.getDay() + "/" + date.getMonth() + "\n"
				+ date.getHours() + ":" + date.getMinutes();

		return retString;

	}

}
