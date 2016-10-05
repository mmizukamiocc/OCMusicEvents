package edu.orangecoastcollege.cs273.ocmusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EventListActivity extends ListActivity {

    private MusicEvent musicEvent;
    private MusicEventAdapter musicEventAdapter;

    private ListView musicEventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set the adapter (which binds the ListView with the data in MusicEvent.java)
        //Since the data is an array, we use an ArrayAdapter:
        setListAdapter(new ArrayAdapter(this,R.layout.music_event_list_item,m));




        //setContentView(R.layout.activity_event_list);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int pos, long id)
    {
        String title = musicEvent.getTitle();
        String date = musicEvent.getDate() ;
        String day = musicEvent.getDay();
        String time = musicEvent.getTime();
        String location = musicEvent.getLocation();
        String address1 = musicEvent.getAddress1();
        String address2 = musicEvent.getAddress2();





        Intent detailsIntent = new Intent(this,EventDetailsActivity.class);
        detailsIntent.putExtra("Title",title);
        detailsIntent.putExtra("Date",date);
        detailsIntent.putExtra("Day",day);
        detailsIntent.putExtra("Time",time);
        detailsIntent.putExtra("Location",location);
        detailsIntent.putExtra("Address1",address1);
        detailsIntent.putExtra("Address2",address2);


    startActivity(detailsIntent);


    }

}
