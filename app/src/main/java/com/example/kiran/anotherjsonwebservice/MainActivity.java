package com.example.kiran.anotherjsonwebservice;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends Activity {
    String url = "http://hmkcode.appspot.com/rest/controller/get.json";
    ArrayList<ListData> ld = new ArrayList<ListData>();
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new AsytaskClass().execute();
    }

    class AsytaskClass extends AsyncTask<String, Integer, String> {
        String response;
        HttpClient httpClient = new DefaultHttpClient();

        @Override
        protected String doInBackground(String... params) {
            try {
                response = EntityUtils.toString(httpClient.execute(new HttpGet(url)).getEntity());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonObject = new JSONObject(response);
                if (jsonObject == null) {
                    Log.d("json", "jsonnull");
                } else {
                    Log.d("json", "json is not null");
                }
                JSONArray jsonArray = jsonObject.getJSONArray("articleList");
                Log.d("thevalueofJson", Integer.toString(jsonArray.length()));
                JSONObject jsonObjectinner;
                for (int i = 0; i < jsonArray.length(); i++) {
//                    Log.d("ivlaue",Integer.toString(i));
                    ListData listData = new ListData();
                    jsonObjectinner = jsonArray.getJSONObject(i);
                    Log.d("ivlaue", jsonObjectinner.toString());
                    listData.setTitle(jsonObjectinner.getString("title"));
                    listData.setUrl(jsonObjectinner.getString("url"));
                    JSONArray jsonArrayCategory = jsonObjectinner.getJSONArray("categories");
                    listData.setCategory(jsonArrayCategory.get(0).toString());
                    JSONArray jSonArraytag =jsonObjectinner.getJSONArray("tags");
                    Log.d("jsonArraytag",""+jSonArraytag.length());
                    for(int jsonArraytagint=0;jsonArraytagint<jSonArraytag.length();jsonArraytagint++)
                    {
//                        listData.settag_1(jSonArraytag.get(jsonArraytagint).toString());
                    }
//                    String categoryvalue=jsonArrayCategory.get(i).toString();
//                    Log.d("theCategoryValue",categoryvalue);
                    ld.add(listData);
                }/*for loop*/


            } catch (JSONException e) {
                e.printStackTrace();
            }
            lv = (ListView) findViewById(R.id.Lv_one);
            CustomlistAdapter ca = new CustomlistAdapter(getApplicationContext(), ld);
            lv.setAdapter(ca);
        }
    }
}
