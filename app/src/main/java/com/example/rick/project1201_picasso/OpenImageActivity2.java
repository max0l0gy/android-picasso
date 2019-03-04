package com.example.rick.project1201_picasso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class OpenImageActivity2 extends AppCompatActivity {


    public static final String NUMBER_ARGUMENT_KEY = "OpenImageActivity.NUMBER_ARGUMENT";

    private int mNumber;
    private Picasso mPicasso;
    private Integer imageWidth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_image2);
        Intent intent = getIntent();
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        imageWidth = metrics.widthPixels;
        mNumber = intent.getIntExtra(NUMBER_ARGUMENT_KEY,0);
        mPicasso = Picasso.with(this);
        ImageView imageView = findViewById(R.id.fullsizeImageView);
        final ProgressBar progressBar = findViewById(R.id.view_progress_detail);

        progressBar.setVisibility(View.VISIBLE);

        mPicasso
                .load(ImageService.getImageURL(mNumber))
                .placeholder(R.drawable.placeholder)
                .resize(imageWidth, imageWidth)
                .centerInside()
                .into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError() {
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}
