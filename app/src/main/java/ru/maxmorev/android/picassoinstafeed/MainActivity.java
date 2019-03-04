package ru.maxmorev.android.picassoinstafeed;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.rick.project1201_picasso.R;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private static final String IS_GREED = "MainActivity.IS_GREED";
    private Picasso mPicasso;

    private Integer imageWidth;

    private Boolean isGreed = true;

    RecyclerView listImages;
    private Context context;

    private ImageView greedIcon;
    private ImageView rowIcon;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPicasso = Picasso.with(this);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[] {Manifest.permission.INTERNET},
                    123
            );
        }

        context = this;
        greedIcon = (ImageView)findViewById(R.id.grid_view);
        rowIcon = (ImageView)findViewById(R.id.raw_view);

        if(savedInstanceState!=null){
            isGreed = savedInstanceState.getBoolean(IS_GREED);
        }

        initImageList();
        initMenuIcons();

        Log.d("!!!", "imageWidth="+imageWidth);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putBoolean(IS_GREED, isGreed);
    }

    protected void initMenuIcons(){
        if(isGreed){
            greedIcon.setImageResource(R.drawable.grid_select);
            rowIcon.setImageResource(R.drawable.row);
        }else{
            greedIcon.setImageResource(R.drawable.grid);
            rowIcon.setImageResource(R.drawable.row_select);
        }
    }

    protected void initImageList(){

        int spanCount = isGreed? 2: 1;
        imageWidth = getImageWidth();
        listImages = (RecyclerView) findViewById(R.id.view_list);
        listImages.setLayoutManager(new GridLayoutManager(this, spanCount));
        final ImagesAdapter adapter = new ImagesAdapter(this, imageWidth);

        adapter.setOnItemClickListener(new ImagesAdapter.ClickListener() {
            @Override
            public void onItemClick(int position) {
                final Intent intent = new Intent(MainActivity.this, ImageDetailActivity.class);
                // в качестве параметра [DetailActivity] передается URI выбранной картинки
                intent.putExtra(ImageDetailActivity.NUMBER_ARGUMENT_KEY, position);
                startActivity(intent);
            }

        });
        listImages.setAdapter(adapter);


    }

    protected Integer getImageWidth(){
        int colums = isGreed ? 2:1;
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        imageWidth = (int)(metrics.widthPixels/colums);
        return imageWidth;
    }

    public void onGreedClick(View view) {
        if(!isGreed) {
            isGreed = true;
            //CONFIG IMAGE SIZE PREVIEW
            imageWidth = getImageWidth();
            initMenuIcons();
            initImageList();

        }
    }

    public void onRowClick(View view) {
        if(isGreed) {
            isGreed = false;
            //CONFIG IMAGE SIZE PREVIEW
            imageWidth = getImageWidth();
            initMenuIcons();
            initImageList();
        }

    }




}
