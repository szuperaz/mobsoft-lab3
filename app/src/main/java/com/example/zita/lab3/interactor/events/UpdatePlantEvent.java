package com.example.zita.lab3.interactor.events;

import com.example.zita.lab3.model.Plant;

public class UpdatePlantEvent {
    private Throwable throwable;
    private Plant plant;

    public UpdatePlantEvent(Throwable throwable, Plant plant) {
        this.throwable = throwable;
        this.plant = plant;
    }

    public UpdatePlantEvent(Throwable throwable) {
        this.throwable = throwable;
    }

    public UpdatePlantEvent() {
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }
}
