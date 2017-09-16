package com.santteam.model;

/**
 * Created by Admin on 9/16/2017.
 */

public class ContactList {
    int avatar;
    String name;
    String content;

    public ContactList(int avatar, String name, String content) {
        this.avatar = avatar;
        this.name = name;
        this.content = content;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
