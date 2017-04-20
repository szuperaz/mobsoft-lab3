package com.example.zita.lab3.ui.message;

import android.util.Log;

import com.example.zita.lab3.interactor.MessagesInteractor;
import com.example.zita.lab3.interactor.events.GetPlantsEvent;
import com.example.zita.lab3.interactor.events.SaveMessageEvent;
import com.example.zita.lab3.model.Message;
import com.example.zita.lab3.ui.BasePresenter;
import com.example.zita.lab3.ui.overview.OverviewScreen;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.example.zita.lab3.MobSoftApplication.injector;

public class MessagePresenter extends BasePresenter<MessageScreen> {

    @Inject
    MessagesInteractor interactor;

    @Inject
    Executor executor;

    @Inject
    EventBus eventBus;

    @Override
    public void attachScreen(MessageScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        eventBus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        eventBus.unregister(this);
    }

    public void sendMessage(final Message message) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                interactor.saveMessage(message);
            }
        });
    }

    public void onEventMainThread(SaveMessageEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showErrorMessage("error");
            }
            Log.e("Networking", "Error reading plants", event.getThrowable());
        } else {
            if (screen != null) {
                screen.showSuccessMessage();
            }
        }
    }
}
