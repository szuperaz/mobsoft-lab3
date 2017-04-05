package com.example.zita.lab3.ui.overview;

import android.os.Bundle;

import com.example.zita.lab3.R;
import com.example.zita.lab3.ui.BaseActivity;

import java.util.List;

import javax.inject.Inject;

public class OverviewActivity extends BaseActivity implements OverviewScreen {

    @Inject
    OverviewPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachScreen();
    }

    @Override
    public void showPlants(List<String> plants) {
        // TODO: implement me
    }

    @Override
    public void navigateToPlantDetails(int plantId) {
        // TODO: implement me
    }

    @Override
    public void navigateToNewMessage() {
        // TODO: implement me
    }

    @Override
    public void toggleFavouriteIconStatus() {
        // TODO: implement me
    }
}
