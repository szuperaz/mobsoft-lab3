package com.example.zita.lab3.ui.overview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zita.lab3.R;
import com.example.zita.lab3.model.Plant;
import com.example.zita.lab3.ui.details.DetailsActivity;

import java.io.InputStream;
import java.util.List;

public class OverviewAdapter extends RecyclerView.Adapter<OverviewAdapter.ViewHolder> {

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

    private List<Plant> plants;
    private OverviewActivity activity;

    public OverviewAdapter(List<Plant> plants, OverviewActivity activity) {
        this.plants = plants;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.plant_cell, parent, false);

        ViewHolder vh = new ViewHolder(view);

        vh.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.itemClicked(v);
            }
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(plants.get(position).getName());
        holder.descriptionView.setText(plants.get(position).getType());
        if(plants.get(position).isFavourite()) holder.favIcon.setImageResource(R.drawable.ic_not_fav);
        else holder.favIcon.setImageResource(R.drawable.ic_favourite);
        new DownloadImageTask(holder.imageView).execute(plants.get(position).getProfileImageUrl());
    }

    @Override
    public int getItemCount() {
        return plants.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView textView;
        public ImageView imageView;
        public ImageView favIcon;
        public TextView descriptionView;
        public ViewHolder(View v) {
            super(v);
            view = v;
            textView = (TextView) v.findViewById(R.id.title);
            descriptionView = (TextView) v.findViewById(R.id.type);
            imageView = (ImageView) v.findViewById(R.id.image);
            favIcon = (ImageView) v.findViewById(R.id.fav);
        }
    }

}
