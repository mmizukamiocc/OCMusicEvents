package edu.orangecoastcollege.cs273.ocmusicevents;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

public class EventListActivity extends ListActivity {

    private Context context = this;

    private ListView eventListView;
    private ArrayList<MusicEvent> allMusicEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set the adapter (which binds the ListView with the data in MusicEvent.java)
        //Since the data is an array, we use an ArrayAdapter:
        eventListView = (ListView) findViewById(R.id.eventsListView);

        try {
            allMusicEvent = JSONLoader.loadJSONFromAsset(context);
        } catch (IOException ex) {
            Log.e("OC Music Events", "Error loading JSON data." + ex.getMessage());
        }
    setListAdapter(new MusicEventAdapter(this,R.layout.music_event_list_item,allMusicEvent));


    }

    @Override
    protected void onListItemClick(ListView l, View v, int pos, long id)
    {
        Intent detailsIntent = new Intent(this,EventDetailsActivity.class);

        MusicEvent selectedEvent = allMusicEvent.get(pos);

        detailsIntent.putExtra("Title",selectedEvent.getTitle());
        detailsIntent.putExtra("Date",selectedEvent.getDate());
        detailsIntent.putExtra("Day",selectedEvent.getDay());
        detailsIntent.putExtra("Time",selectedEvent.getTime());
        detailsIntent.putExtra("Location",selectedEvent.getLocation());
        detailsIntent.putExtra("Address1",selectedEvent.getAddress1());
        detailsIntent.putExtra("Address2",selectedEvent.getAddress2());
    detailsIntent.putExtra("ImageName",selectedEvent.getImageName());

    startActivity(detailsIntent);


    }

}
