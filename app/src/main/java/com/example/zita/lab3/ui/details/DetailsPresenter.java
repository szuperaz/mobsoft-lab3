package com.example.zita.lab3.ui.details;

import android.util.Log;

import com.example.zita.lab3.MobSoftApplication;
import com.example.zita.lab3.interactor.PlantsInteractor;
import com.example.zita.lab3.interactor.events.GetPlantEvent;
import com.example.zita.lab3.interactor.events.GetPlantsEvent;
import com.example.zita.lab3.ui.BasePresenter;
import com.example.zita.lab3.ui.overview.OverviewScreen;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

public class DetailsPresenter extends BasePresenter<DetailsScreen> {
    @Inject
    PlantsInteractor interactor;

    @Inject
    Executor executor;

    @Inject
    EventBus eventBus;

    public void onEventMainThread(GetPlantEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showErrorMessage("error");
            }
            Log.e("Networking", "Error reading plants", event.getThrowable());
        } else {
            if (screen != null) {
                screen.showDetails(event.getPlant());
            }
        }
    }

    @Override
    public void attachScreen(DetailsScreen screen) {
        super.attachScreen(screen);
        MobSoftApplication.injector.inject(this);
        eventBus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        eventBus.unregister(this);
    }

    void getPlant(final Long plantId) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                interactor.getPlant(plantId);
            }
        });
    }

}
