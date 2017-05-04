package com.example.zita.lab3;

import android.content.Context;

import com.example.zita.lab3.ui.UIModule;
import com.example.zita.lab3.ui.details.DetailsPresenter;
import com.example.zita.lab3.ui.message.MessagePresenter;
import com.example.zita.lab3.ui.overview.OverviewPresenter;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

@Module
public class TestModule {

    private final UIModule UIModule;

    public TestModule(Context context) {
        this.UIModule = new UIModule(context);
    }

    @Provides
    public Context provideContext() {
        return UIModule.provideContext();
    }


    @Provides
    public OverviewPresenter provideOverviewPresenter() {
        return UIModule.provideOverviewPresenter();
    }

    @Provides
    public MessagePresenter provideMessagePresenter() {
        return UIModule.provideMessagePresenter();
    }

    @Provides
    public DetailsPresenter provideDetailsPresenter() {
        return UIModule.provideDetailsPresenter();
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideNetworkExecutor() {
        return new UiExecutor();
    }


}
