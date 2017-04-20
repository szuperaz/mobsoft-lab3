package com.example.zita.lab3.interactor.events;

import com.example.zita.lab3.model.Message;

public class SaveMessageEvent {
    private Message message;
    private Throwable throwable;

    public SaveMessageEvent(Message message, Throwable throwable) {
        this.message = message;
        this.throwable = throwable;
    }

    public SaveMessageEvent() {
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
