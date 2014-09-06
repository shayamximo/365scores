package com.assingment.controllers;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.assingment.json.Section;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class ElementContorllerFactory {

	private Section section;
	private LayoutInflater inflater;
	private ViewGroup root;
	private DisplayImageOptions options;
	private ImageLoader imageLoader;

	private enum NAME {
		SCORES,NEWS,TWEETS
	}

	public ElementContorllerFactory(Section section, LayoutInflater inflater,
			ViewGroup root, DisplayImageOptions options, ImageLoader imageLoader) {

		this.section = section;
		this.inflater = inflater;
		this.root = root;
		this.options = options;
		this.imageLoader = imageLoader;
	}

	public ElementController getElementController()
			throws ElementNonExistentException {

		ElementController elementController = null;
		String sectionName = section.getName();

		try {
			NAME name = NAME.valueOf(sectionName);

			switch (name) {
			case SCORES:

				elementController = new ScoresElementController(section,
						inflater, root, options, imageLoader);

				break;
				
			case NEWS:
				elementController = new NewsElementController(section,
						inflater, root, options, imageLoader);
				
				break;
				
			case TWEETS:
				elementController = new TweetsElementController(section,
						inflater, root, options, imageLoader);
				
				break;

			default:
				throw new ElementNonExistentException();

			}

		} catch (IllegalArgumentException illegalArgumentException) {
			throw new ElementNonExistentException();
		}

		return elementController;

	}

}
