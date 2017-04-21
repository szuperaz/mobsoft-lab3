package com.example.zita.lab3.interactor;

import com.example.zita.lab3.MobSoftApplication;
import com.example.zita.lab3.interactor.events.SaveMessageEvent;
import com.example.zita.lab3.model.Message;
import com.example.zita.lab3.repository.Repository;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

public class MessagesInteractor {
    @Inject
    Repository repository;
    @Inject
    EventBus eventBus;

    public MessagesInteractor () {
        MobSoftApplication.injector.inject(this);
    }

    public void saveMessage (Message message) {
        SaveMessageEvent event = new SaveMessageEvent();
        event.setMessage(message);
        try {
            eventBus.post(event);
        }
        catch (Exception e) {
            event.setThrowable(e);
            eventBus.post(event);
        }
    }
}
