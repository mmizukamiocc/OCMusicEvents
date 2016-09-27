package edu.orangecoastcollege.cs273.ocmusicevents;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class EventDetailsActivity extends AppCompatActivity {

    private ImageView eventImageView;

    private Context context = (Context) this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        Intent detailsIntent = getIntent();
        String title = detailsIntent.getStringExtra("Title");
        String details = detailsIntent.getStringExtra("Details");
        String imageFileName = title.replace(" ","") + ".jpeg";

        eventImageView = (ImageView) findViewById(R.id.eventImageView);

        AssetManager am = context.getAssets();

        try{
            InputStream stream = am.open(imageFileName);
            Drawable image = Drawable.createFromStream(stream,title);
            eventImageView.setImageDrawable(image);
        }
        catch (IOException ex)
        {
            Log.e("OC Music Events","Cannot load image: " + imageFileName + ex);
        }
    }
}
