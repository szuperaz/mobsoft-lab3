package com.example.zita.lab3.ui.overview;

import com.example.zita.lab3.ui.BaseScreen;

import java.util.List;

public interface OverviewScreen extends BaseScreen {
    // TODO: replace String with business model
    void showPlants(List<String> plants);

    void toggleFavouriteIconStatus();
}
