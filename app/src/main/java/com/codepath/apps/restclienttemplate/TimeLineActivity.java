package com.codepath.apps.restclienttemplate;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.codepath.apps.restclienttemplate.fragments.TweetsListFragment;
import com.codepath.apps.restclienttemplate.fragments.TweetsPagerAdapter;
import com.codepath.apps.restclienttemplate.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class TimeLineActivity extends AppCompatActivity implements TweetsListFragment.TweetSelectedListener {

    private TwitterClient client;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);

        client = TwitterApp.getRestClient();  //View(R.layout.activity_timeline)
         //get the view pager
        ViewPager vpPager = (ViewPager) findViewById(R.id.viewpager);
        //set the adapter for the pager
        vpPager.setAdapter(new TweetsPagerAdapter(getSupportFragmentManager(), this));
        //setup the tablayout to use the view pager
        TabLayout tabLayout= (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(vpPager);
        //find the RecycleView

       // populateTimeLine();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_timeline, menu);
        return true;
    }
    public void onProfileView(MenuItem item){
        //launch the profile view
        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
    }

    @Override
    public void onTweetSelected(Tweet tweet) {
        Toast.makeText(this, tweet.body, Toast.LENGTH_SHORT).show();
    }
    //  private void populateTimeLine(){

     //   client.getHomeTimeLine(new JsonHttpResponseHandler(){
      //      @Override
          //  public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
            //    Log.d("TwitterClient",response.toString());

          //  }

        //    @Override
         //   public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
          //      fragmentTweetsList.addItems(response);
                //    Log.d("TwitterClient",response.toString());
                //iterate trought the JSON array
                //for each entry, deserialyze the JSON object
             //   for (int i = 0; i < response.length(); i++) {
                    //convert each object to a Tweet model
                    //add that tweet model to our data source
                    //notify the adapter that we've added an item

              //  }
           // }

          //  @Override
          //  public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
            //    Log.d("TwitterClient",responseString);
            //    throwable.printStackTrace();
          //  }

          //  @Override
          //  public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
          //      Log.d("TwitterClient",errorResponse.toString());
          //      throwable.printStackTrace();
          //  }

          //  @Override
          //  public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
          //      Log.d("TwitterClient",errorResponse.toString());
          //      throwable.printStackTrace();
          //  }



            //         Log.d("TwitterClient",response.toString());
                //iterate trought the JSON array
                //for each entry, deserialize the JSON object




       // });


}
