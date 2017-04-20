package com.example.zita.lab3.ui.overview;

import com.example.zita.lab3.model.Plant;
import com.example.zita.lab3.ui.BaseScreen;

import java.util.List;

public interface OverviewScreen extends BaseScreen {
    void showPlants(List<Plant> plants);

    void toggleFavouriteIconStatus();
}
