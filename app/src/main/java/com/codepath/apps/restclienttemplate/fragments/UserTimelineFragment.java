package com.codepath.apps.restclienttemplate.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.codepath.apps.restclienttemplate.TwitterApp;
import com.codepath.apps.restclienttemplate.TwitterClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Alain Etienne on 03-Mar-18.
 */

public class UserTimelineFragment extends TweetsListFragment {
    TwitterClient client;
    public static UserTimelineFragment newInstance(String  screenName){
       UserTimelineFragment userTimelineFragment = new UserTimelineFragment();
       Bundle args= new Bundle();
       args.putString("screen_name", screenName);
       userTimelineFragment.setArguments(args);
       return userTimelineFragment;


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = TwitterApp.getRestClient();
        populateTimeLine();
    }

    private void populateTimeLine() {
        //comes from the activity
        String screenName = getArguments().getString("screen_name");

        client.getUserTimeline(screenName, new JsonHttpResponseHandler() {
                                   @Override
                                   public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                                       Log.d("TwitterClient", response.toString());

                                   }

                                   @Override
                                   public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                                       addItems(response);
                                       //    Log.d("TwitterClient",response.toString());

                                       //iterate trought the JSON array
                                       //for each entry, deserialyze the JSON object
                                       for (int i = 0; i < response.length(); i++) {
                                           //convert each object to a Tweet model
                                           //add that tweet model to our data source
                                           //notify the adapter that we've added an item


                                       }
                                   }

                                   @Override
                                   public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                                       Log.d("TwitterClient", responseString);
                                       throwable.printStackTrace();
                                   }

                                   @Override
                                   public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                                       Log.d("TwitterClient", errorResponse.toString());
                                       throwable.printStackTrace();
                                   }

                                   @Override
                                   public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                                       Log.d("TwitterClient", errorResponse.toString());
                                       throwable.printStackTrace();
                                   }


                                           //         Log.d("TwitterClient",response.toString());
            //iterate trought the JSON array
            //for each entry, deserialize the JSON object


        });
}}
