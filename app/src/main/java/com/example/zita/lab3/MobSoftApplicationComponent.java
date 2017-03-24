package com.example.zita.lab3;

import com.example.zita.lab3.ui.UIModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zita on 3/24/17.
 */

@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

}