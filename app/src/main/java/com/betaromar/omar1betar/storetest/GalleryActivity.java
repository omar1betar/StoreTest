package com.betaromar.omar1betar.storetest;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class GalleryActivity extends AppCompatActivity {

    private static final String TAG = "GallaryActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        getIncomingIntent();
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("image_url") && getIntent().hasExtra("image_desc")) {
            Log.d(TAG, "getIncomingIntent:  has extra succes ");
            String imageUrl = getIntent().getStringExtra("image_url");
            String imageDesc = getIntent().getStringExtra("image_desc");
            String imageName = getIntent().getStringExtra("image_name");
            String imagePrice =getIntent().getStringExtra("price");
            setExtras(imageUrl, imageDesc,imageName,imagePrice);
        }
    }

    private void setExtras(String imageUrl, String imageDesc,String imageName,String imagePrice) {
        Log.d(TAG, "setExtras: succes");

        TextView desc = (TextView) findViewById(R.id.description);
        desc.setText(imageDesc);
        TextView name = (TextView)findViewById(R.id.name_gallery);
        name.setText(imageName);
        TextView price = (TextView)findViewById(R.id.price_gallery);
        price.setText(imagePrice);
        ImageView image = (ImageView) findViewById(R.id.image_gallary);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
    }
}
