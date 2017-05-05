package com.example.zita.lab3.ui.overview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.zita.lab3.MobSoftApplication;
import com.example.zita.lab3.R;
import com.example.zita.lab3.model.Plant;
import com.example.zita.lab3.ui.BaseActivity;
import com.example.zita.lab3.ui.details.DetailsActivity;
import com.example.zita.lab3.ui.message.MessageActivity;

import java.util.List;

import javax.inject.Inject;

public class OverviewActivity extends BaseActivity implements OverviewScreen {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Plant> plants;

    @Inject
    OverviewPresenter overviewPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        MobSoftApplication.injector.inject(this);

        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

    }

    @Override
    protected void onStart() {
        super.onStart();
        overviewPresenter.attachScreen(this);
        overviewPresenter.getPlants();

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToNewMessage();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        overviewPresenter.detachScreen();
    }

    @Override
    public void showPlants(List<Plant> plants) {
        this.plants = plants;
        mAdapter = new OverviewAdapter(plants, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void navigateToPlantDetails(Long plantId) {
        Intent i = new Intent(OverviewActivity.this, DetailsActivity.class);
        i.putExtra("id", plantId);
        startActivity(i);
    }

    public void navigateToNewMessage() {
        Intent i = new Intent(OverviewActivity.this, MessageActivity.class);
        startActivity(i);
    }

    @Override
    public void toggleFavouriteIconStatus(Plant plant) {
        System.out.print(plant);
    }

    public void itemClicked(View v) {
        int position = mRecyclerView.getChildLayoutPosition(v);
        if(position != -1) {
            navigateToPlantDetails(plants.get(position).getId());
        }
    }
}
