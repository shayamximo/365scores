package com.assingment;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.assingment.controllers.ElementContorllerFactory;
import com.assingment.controllers.ElementController;
import com.assingment.controllers.ElementNonExistentException;
import com.assingment.json.Section;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

public class MainActivity extends Activity implements IDataFinishLoadListener {

	private final String url = "http://5.79.23.204/MobileDevTest/Test.json";

	private DisplayImageOptions options;

	private ImageLoader imageLoader;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//stuff for image loading
		options = new DisplayImageOptions.Builder().cacheInMemory(true)
				.cacheOnDisc(true).considerExifParams(true)
				.bitmapConfig(Bitmap.Config.RGB_565).build();
		initImageLoader(this);
		imageLoader = ImageLoader.getInstance();

		setContentView(R.layout.activity_main);
		FetchDataTask fetchVenuTask = new FetchDataTask(this);
		fetchVenuTask.execute(url);

	}

	@Override
	public void onFinish(List<Section> sectionList) {
		View pleaseWaitView = findViewById(R.id.tv_please_wait_message);
		pleaseWaitView.setVisibility(View.GONE);

		LinearLayout mainLayout = (LinearLayout) findViewById(R.id.main_layout);

		for (Section section : sectionList) {
			ElementContorllerFactory elementContorllerFactory = new ElementContorllerFactory(
					section, getLayoutInflater(), mainLayout, options,
					imageLoader);

			try {
				ElementController elementContorller = elementContorllerFactory
						.getElementController();
				View row = elementContorller.getRow();
				mainLayout.addView(row);

			} catch (ElementNonExistentException e) {
				Log.i("error", e.getMessage());
			}
		}

	}

	public static void initImageLoader(Context context) {
		// This configuration tuning is custom. You can tune every option, you
		// may tune some of them,
		// or you can create default configuration by
		// ImageLoaderConfiguration.createDefault(this);
		// method.
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				context).threadPriority(Thread.NORM_PRIORITY - 2)
				.denyCacheImageMultipleSizesInMemory()
				.discCacheFileNameGenerator(new Md5FileNameGenerator())
				.tasksProcessingOrder(QueueProcessingType.LIFO)
				.writeDebugLogs() // Remove
									// for
									// release
									// app
				.build();
		// Initialize ImageLoader with configuration.
		ImageLoader.getInstance().init(config);
	}

}