package com.assingment.controllers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.assingment.R;
import com.assingment.json.Item;
import com.assingment.json.Section;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class NewsElementController extends ElementController {

	public NewsElementController(Section section, LayoutInflater inflater,
			ViewGroup root, DisplayImageOptions options, ImageLoader imageLoader) {
		super(section, inflater, root, options, imageLoader);

	}

	@Override
	protected int getNumberOfElementsInRow() {
		return 3;
	}

	@Override
	protected View buildRow(LinearLayout linearLayout, int index) {
		FrameLayout newsLayout = (FrameLayout) inflater.inflate(
				R.layout.news_layout, linearLayout, false);

		// I added 4 here, simply because from the server, some of the first
		// items images are empty.
		Item item = section.getData().getItems().get(index + 4);

		ImageView newsImage = (ImageView) newsLayout
				.findViewById(R.id.news_image);
		TextView newsText = (TextView) newsLayout.findViewById(R.id.news_text);

		imageLoader.displayImage(item.getImageSource(), newsImage);
		newsText.setText(item.getDescription());

		return newsLayout;
	}

}
