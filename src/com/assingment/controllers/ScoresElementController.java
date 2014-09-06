package com.assingment.controllers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.assingment.R;
import com.assingment.json.Comp;
import com.assingment.json.Game;
import com.assingment.json.Section;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class ScoresElementController extends ElementController {

	public ScoresElementController(Section section, LayoutInflater inflater,
			ViewGroup root, DisplayImageOptions options, ImageLoader imageLoader) {
		super(section, inflater, root, options, imageLoader);

	}

	@Override
	protected int getNumberOfElementsInRow() {
		return 2;
	}

	@Override
	protected View buildRow(LinearLayout linearLayout, int index) {
		RelativeLayout scoreLayout = (RelativeLayout) inflater.inflate(
				R.layout.score_layout, linearLayout, false);

		TextView team1 = (TextView) scoreLayout.findViewById(R.id.team1);
		TextView team2 = (TextView) scoreLayout.findViewById(R.id.team2);
		TextView date = (TextView) scoreLayout.findViewById(R.id.date);
		
		Game game = section.getData().getGames().get(index);
		
		Comp comp1 = game.getCompOne();
		Comp comp2 = game.getCompTwo();

		team1.setText(comp1.getDisplayName().replace(" ", "\n"));
		team2.setText(comp2.getDisplayName().replace(" ", "\n"));
		date.setText(game.getDateReadableFormat());
		return scoreLayout;
	}

}
