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
        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        final String name = retrievedFriend.getName();
        String bio = retrievedFriend.getBio();
        int id = retrievedFriend.getDrawableId();


        ImageView picture = findViewById(R.id.picture2);
        TextView text2 = findViewById(R.id.text2);
        TextView bio2 = findViewById(R.id.bio2);

        picture.setImageResource(id);
        text2.setText(name);
        bio2.setText(bio);
        Log.d("esdfdf", name);
        RatingBar rating = findViewById(R.id.rating);
        rating.setRating(load(name));
        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                save(name, rating);
            }
        });
    }
    public void save(String name, float f) {
        SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
        ((SharedPreferences.Editor) editor).putFloat(name, f);
        editor.commit();
    }

    public float load(String name) {
        Log.d("sdfdffds", name);
        SharedPreferences sharedPreferences = getSharedPreferences("settings", MODE_PRIVATE);
        float f =sharedPreferences.getFloat(name, 0f);
        return f;
    }
}
