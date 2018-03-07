package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Ing paulin on 2/24/2018.
 */

public class Tweet {

    public String body;
    public long uid; // database ID for the tweet
    public String createdAt;

    public User user;

    //  deserialize the json

    public static Tweet fromJSON(JSONObject jsonObject) throws JSONException{

        Tweet tweet= new Tweet();

        // extract the values from JSON

        tweet.body=jsonObject.getString("text");
        tweet.uid=jsonObject.getLong("id");
        tweet.createdAt=jsonObject.getString("created_at");
        tweet.user=User.fromJSON(jsonObject.getJSONObject("user"));

        return tweet;
    }
}
