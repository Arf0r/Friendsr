package com.example.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Make list of names
        String[] names = {"Arya", "Cersei", "Daenerys", "Jaime", "Jon", "Jorah", "Margaery",
                "Melisandre", "Sansa", "Tyrion"};

        // Make list of bio's
        String [] bios = {"Wollah, ik steek je met mn kleine mes", "4x duurder",
                "How not to train your dragon", "Incest = wincest", "Zwart is cool toch?",
                "Niet relevant", "Met beetje geil doen kom je niet op de troon schat",
                "Carice van Houten, multi'VO",
                "Bitch die in een horrorfilm alle fouten dingen zou kiezen",
                "Its funny cuz he's tiny"};

        // For every name in the name list add a friend object to friend class
        ArrayList<Friend> friends = new ArrayList<>();
        for(int i = 0; i < names.length; i++) {
            String name = names[i];
            String bio = bios[i];
            int id = getResources().getIdentifier(name.toLowerCase(), "drawable", getPackageName());
            Friend friend = new Friend(name, bio, id);
            friends.add(friend);
            }

        // Fill the gridView with the different friends
        FriendsAdapter friendsAdapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView gridView  = findViewById(R.id.gridView);
        gridView.setAdapter(friendsAdapter);

        // Set a listener for on click for the gridView
        gridView.setOnItemClickListener(new GridItemClickListener());
    }

    private class GridItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){

            // Get the info of the friend at the clicked position
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }
}
