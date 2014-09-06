package com.assingment.controllers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

import com.assingment.R;
import com.assingment.json.Section;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public abstract class ElementController {

	protected Section section;
	protected LayoutInflater inflater;
	protected ViewGroup root;
	protected DisplayImageOptions options;
	protected ImageLoader imageLoader;

	public ElementController(Section section, LayoutInflater inflater,
			ViewGroup root, DisplayImageOptions options, ImageLoader imageLoader) {
		super();
		this.section = section;
		this.inflater = inflater;
		this.root = root;
		this.options = options;
		this.imageLoader = imageLoader;
	}

	public View getRow() {

		LinearLayout mainRowLayout = (LinearLayout) inflater.inflate(
				R.layout.single_row_layout, root, false);

		TextView title = (TextView) mainRowLayout.findViewById(R.id.title);

		title.setText(section.getName());

		LinearLayout horizontalRowLayout = (LinearLayout) mainRowLayout
				.findViewById(R.id.horizontal_layout);

		for (int i = 0; i < getNumberOfElementsInRow(); i++) {
			View scoreView = buildRow(horizontalRowLayout, i);
			
			LinearLayout.LayoutParams layoutParams1 = (LayoutParams) scoreView
					.getLayoutParams();
			layoutParams1.weight = 1;
			horizontalRowLayout.addView(scoreView);
		}

		return mainRowLayout;

	}

	protected abstract int getNumberOfElementsInRow();

	protected abstract View buildRow(LinearLayout linearLayout, int index);

}
