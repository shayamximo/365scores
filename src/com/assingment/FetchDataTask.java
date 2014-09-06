package com.assingment;

import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.util.Log;

import com.assingment.json.Section;
import com.assingment.json.Store;
import com.google.gson.Gson;

public class FetchDataTask extends AsyncTask<String, Void, List<Section>> {

	IDataFinishLoadListener dataFinishLoadListener;

	public FetchDataTask(IDataFinishLoadListener dataFinishLoadListener) {
		this.dataFinishLoadListener = dataFinishLoadListener;
	}

	@Override
	protected List<Section> doInBackground(String... url) {

		// Perform http request to get data
		HttpClient client = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(url[0]);
		ResponseHandler<String> responseHandler = new BasicResponseHandler();
		String jsonResponse = null;
		try {
			jsonResponse = client.execute(httpget, responseHandler);
		} catch (Exception e) {
			Log.i("ERROR", "error during call for venus");
		}

		// create instance from json
		Gson gson = new Gson();
		Store store = null;
		try {
			store = gson.fromJson(jsonResponse, Store.class);
			Log.i("", "");
		} catch (Exception e) {
			Log.i("", "");
		}

		return store.getSections();
	}

	@Override
	protected void onPostExecute(List<Section> dataList) {
		dataFinishLoadListener.onFinish(dataList);
	}

	@Override
	protected void onPreExecute() {
	}

	@Override
	protected void onProgressUpdate(Void... values) {
	}

}
