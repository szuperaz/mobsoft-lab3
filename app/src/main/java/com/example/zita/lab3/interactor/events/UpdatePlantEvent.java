package com.example.zita.lab3.interactor.events;

public class UpdatePlantEvent {
    private Throwable throwable;

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
}
