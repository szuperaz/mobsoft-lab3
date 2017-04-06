package com.example.zita.lab3.ui.details;

import android.os.Bundle;

import com.example.zita.lab3.MobSoftApplication;
import com.example.zita.lab3.R;
import com.example.zita.lab3.ui.BaseActivity;

import javax.inject.Inject;

public class DetailsActivity extends BaseActivity implements DetailsScreen {
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
    }
    @Override
    public void displayDetails(String plant) {
        // TODO implement me
    }
}
