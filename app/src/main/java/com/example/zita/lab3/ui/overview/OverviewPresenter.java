package com.example.zita.lab3.ui.overview;

import android.util.Log;

import com.example.zita.lab3.MobSoftApplication;
import com.example.zita.lab3.interactor.PlantsInteractor;
import com.example.zita.lab3.interactor.events.GetPlantsEvent;
import com.example.zita.lab3.interactor.events.UpdatePlantEvent;
import com.example.zita.lab3.ui.BasePresenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

public class OverviewPresenter extends BasePresenter<OverviewScreen> {

    @Inject
    PlantsInteractor interactor;

    @Inject
    Executor executor;

    @Inject
    EventBus eventBus;

    @Override
    public void attachScreen(OverviewScreen screen) {
        super.attachScreen(screen);
        MobSoftApplication.injector.inject(this);
        eventBus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        eventBus.unregister(this);
    }

    public void getPlants() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                interactor.getPlants();
            }
        });
    }

    public void toggleFavouriteStatus(final Long plantId) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                interactor.toggleFavouriteStatus(plantId);
            }
        });
    }

    public void onEventMainThread(GetPlantsEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showErrorMessage("error");
            }
            Log.e("Networking", "Error reading plants", event.getThrowable());
        } else {
            if (screen != null) {
                screen.showPlants(event.getPlants());
            }
        }
    }

    public void onEventMainThread(UpdatePlantEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showErrorMessage("error");
            }
            Log.e("Networking", "Error reading plants", event.getThrowable());
        } else {
            if (screen != null) {
                screen.toggleFavouriteIconStatus(event.getPlant());
            }
        }
    }
}
