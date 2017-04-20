package com.example.zita.lab3.model;

import com.orm.dsl.Table;

@Table
public class Message {
    private Long id = null;
    private String body;
    private String photo;

    public Message(Long id, String body, String photo) {
        this.id = id;
        this.body = body;
        this.photo = photo;
    }

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
