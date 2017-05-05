package com.example.zita.lab3.interactor;

import com.example.zita.lab3.MobSoftApplication;
import com.example.zita.lab3.interactor.events.GetPlantEvent;
import com.example.zita.lab3.interactor.events.GetPlantsEvent;
import com.example.zita.lab3.interactor.events.UpdatePlantEvent;
import com.example.zita.lab3.model.Plant;
import com.example.zita.lab3.repository.Repository;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

public class PlantsInteractor {

    @Inject
    Repository repository;

    @Inject
    EventBus eventBus;

    public PlantsInteractor () {
        MobSoftApplication.injector.inject(this);
    }

    public void getPlants () {
        GetPlantsEvent event = new GetPlantsEvent();
        try {
            List<Plant> plants = repository.getPlants();
            event.setPlants(plants);
            eventBus.post(event);
        }
        catch (Exception e) {
            event.setThrowable(e);
            eventBus.post(event);
        }
    }

    public void getPlant (Long id) {
        GetPlantEvent event = new GetPlantEvent();
        try {
            Plant plant = repository.getPlant(id);
            event.setPlant(plant);
            eventBus.post(event);
        }
        catch (Exception e) {
            event.setThrowable(e);
            eventBus.post(event);
        }
    }

    public void toggleFavouriteStatus(Long plantId) {
        UpdatePlantEvent event = new UpdatePlantEvent();
        try {
            event.setPlant(repository.toggleFavouriteStatus(plantId));
            eventBus.post(event);
        }
        catch (Exception e) {
            event.setThrowable(e);
            eventBus.post(event);
        }
    }
}
