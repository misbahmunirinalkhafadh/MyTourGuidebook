package com.dikoding.picodiploma.mytourguidebook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ArticleActivity extends AppCompatActivity {

    private static final String TAG = "ArticleActivity";

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        getIncomingIntent();
    }

    /**
     * for detail article
     */
    private void getIncomingIntent() {
        if (getIntent().hasExtra("image_url") && getIntent().hasExtra("title")) {
            String imageUrl = getIntent().getStringExtra("image_url");
            String title = getIntent().getStringExtra("title");
            String postedTime = getIntent().getStringExtra("posted_time");
            String postedBy = getIntent().getStringExtra("posted_by");
            String desc = getIntent().getStringExtra("content");

            setImage(imageUrl, title, postedTime, postedBy, desc);
        }
    }

    /**
     * Initialisation and load element
     *
     * @param imageUrl
     * @param title
     * @param postedTime
     * @param postedBy
     * @param desc
     */
    private void setImage(String imageUrl, String title, String postedTime, String postedBy, String desc) {
        //Initialisation
        ImageView image = findViewById(R.id.image_article);
        TextView name = findViewById(R.id.title_article);
        TextView time = findViewById(R.id.posted_time);
        TextView by = findViewById(R.id.posted_by);
        TextView content = findViewById(R.id.content);

        //Load element
        Glide.with(this).asBitmap().load(imageUrl).into(image);
        name.setText(title);
        time.setText(postedTime);
        by.setText(postedBy);
        content.setText(desc);
    }
}
