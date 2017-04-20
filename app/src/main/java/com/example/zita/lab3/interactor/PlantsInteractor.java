package com.example.zita.lab3.interactor;

import com.example.zita.lab3.MobSoftApplication;
import com.example.zita.lab3.interactor.events.GetPlantsEvent;
import com.example.zita.lab3.interactor.events.UpdatePlantEvent;
import com.example.zita.lab3.model.Plant;
import com.example.zita.lab3.repository.Repository;
import com.google.common.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

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

    public void addPlantToFavourites(Long plantId) {
        UpdatePlantEvent event = new UpdatePlantEvent();
        try {
            repository.addPlantToFavourites(plantId);
            eventBus.post(event);
        }
        catch (Exception e) {
            event.setThrowable(e);
            eventBus.post(event);
        }
    }

    public void deletePlantFromFavourites(Long plantId) {
        UpdatePlantEvent event = new UpdatePlantEvent();
        try {
            repository.addPlantToFavourites(plantId);
            eventBus.post(event);
        }
        catch (Exception e) {
            event.setThrowable(e);
            eventBus.post(event);
        }
    }
}
