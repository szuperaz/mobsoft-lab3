package com.example.zita.lab3.ui.details;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zita.lab3.MobSoftApplication;
import com.example.zita.lab3.R;
import com.example.zita.lab3.model.Plant;
import com.example.zita.lab3.ui.BaseActivity;
import com.example.zita.lab3.ui.overview.OverviewAdapter;

import java.io.InputStream;

import javax.inject.Inject;

public class DetailsActivity extends BaseActivity implements DetailsScreen {
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

    @Inject
    DetailsPresenter detailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        detailsPresenter.attachScreen(this);
        Intent intent = getIntent();
        Long plantId = intent.getLongExtra("id", 0L);
        detailsPresenter.getPlant(plantId);
    }

    @Override
    protected void onStop() {
        super.onStop();
        detailsPresenter.detachScreen();
    }

    @Override
    public void showDetails(Plant plant) {
        ((TextView)findViewById(R.id.description)).setText(plant.getDescription());
        ((TextView)findViewById(R.id.planting)).setText(plant.getPlantationTime());
        ((TextView)findViewById(R.id.picking)).setText(plant.getPickingTime());
        new DownloadImageTask((ImageView) findViewById(R.id.details_image)).execute(plant.getPhotoUrl());
    }
}
