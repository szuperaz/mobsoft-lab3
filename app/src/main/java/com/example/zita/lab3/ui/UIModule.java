package com.example.zita.lab3.ui;

import android.content.Context;

import com.example.zita.lab3.ui.details.DetailsPresenter;
import com.example.zita.lab3.ui.message.MessagePresenter;
import com.example.zita.lab3.ui.overview.OverviewPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public OverviewPresenter provideOverviewPresenter() {
        return new OverviewPresenter();
    }

    @Provides
    @Singleton
    public MessagePresenter provideMessagePresenter() {
        return new MessagePresenter();
    }

    @Provides
    @Singleton
    public DetailsPresenter provideDetailsPresenter() {
        return new DetailsPresenter();
    }

}
