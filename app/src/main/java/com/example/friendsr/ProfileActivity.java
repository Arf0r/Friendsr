package com.example.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the proper UI and save the info of the friend that was just clicked
        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        // Save that friends info into separate variables
        final String name = retrievedFriend.getName();
        String bio = retrievedFriend.getBio();
        int id = retrievedFriend.getDrawableId();

        // Update the text- and imageViews
        ImageView picture = findViewById(R.id.picture2);
        TextView text2 = findViewById(R.id.text2);
        TextView bio2 = findViewById(R.id.bio2);
        picture.setImageResource(id);
        text2.setText(name);
        bio2.setText(bio);

        // Load the current rating
        RatingBar rating = findViewById(R.id.rating);
        rating.setRating(load(name));

        // If the rating is changed, update the saved rating
        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                save(name, rating);
            }
        });
    }

    // Method for saving a rating (with the character name as the key)
    public void save(String name, float f) {
        SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
        ((SharedPreferences.Editor) editor).putFloat(name, f);
        editor.commit();
    }

    // Method for loading the ratings
    public float load(String name) {
        SharedPreferences sharedPreferences = getSharedPreferences("settings", MODE_PRIVATE);
        float f =sharedPreferences.getFloat(name, 0f);
        return f;
    }
}
