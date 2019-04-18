package com.example.friendsr;

        import android.content.Context;
        import android.media.Image;
        import android.provider.ContactsContract;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.List;



public class FriendsAdapter extends ArrayAdapter<Friend>{

    // Make a new adapter for Friends
    ArrayList<Friend> friends;
    public FriendsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Friend> objects) {
        super(context, resource, objects);
        friends = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }
        // Set the views with information from the friends ArrayList
        TextView text = convertView.findViewById(R.id.text);
        ImageView picture = convertView.findViewById(R.id.picture);
        Friend friend = friends.get(position);
        text.setText(friend.getName());
        picture.setImageResource(friend.getDrawableId());

        return convertView;
    }
}