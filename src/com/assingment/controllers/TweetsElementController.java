package com.assingment.controllers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.assingment.R;
import com.assingment.json.Item;
import com.assingment.json.Section;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class TweetsElementController extends ElementController {

	public TweetsElementController(Section section, LayoutInflater inflater,
			ViewGroup root, DisplayImageOptions options, ImageLoader imageLoader) {
		super(section, inflater, root, options, imageLoader);
	}

	@Override
	protected int getNumberOfElementsInRow() {
		return 2;
	}

	@Override
	protected View buildRow(LinearLayout linearLayout, int index) {

		LinearLayout tweetLayout = (LinearLayout) inflater.inflate(
				R.layout.tweet_layout, linearLayout, false);
		
		
		Item item = section.getData().getItems().get(index);

		ImageView newsImage = (ImageView) tweetLayout
				.findViewById(R.id.tweet_image);
		TextView descriptionText = (TextView) tweetLayout.findViewById(R.id.tweet_description);

		TextView titleText =  (TextView) tweetLayout.findViewById(R.id.tweet_title);
		
		
		imageLoader.displayImage(item.getImageSource(), newsImage);
		descriptionText.setText(item.getDescription());
		titleText.setText(item.getTitle());

		return tweetLayout;

	}

}
