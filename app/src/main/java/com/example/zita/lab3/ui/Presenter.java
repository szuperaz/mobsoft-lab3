package com.example.zita.lab3.ui;

/**
 * Created by zita on 3/24/17.
 */

public abstract class Presenter<S> {
    protected S screen;

    public void attachScreen(S screen) {
        this.screen = screen;
    }

    public void detachScreen() {
        this.screen = null;
    }
}
