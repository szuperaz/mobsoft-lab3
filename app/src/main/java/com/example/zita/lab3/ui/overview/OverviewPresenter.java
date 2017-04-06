package com.example.zita.lab3.ui.overview;

import com.example.zita.lab3.ui.BasePresenter;

public class OverviewPresenter extends BasePresenter<OverviewScreen> {

    private static OverviewPresenter instance = null;

    public OverviewPresenter() {
    }

    @Override
    public void attachScreen(OverviewScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void getPlants() {
        // TODO: implement me
    }

    public void toggleFavouriteStatus(int plantIs) {
        // TODO: implement me
    }
}
