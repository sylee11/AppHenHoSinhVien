package com.santteam;

/**
 * Created by nqait on 9/15/2017.
 */

public class AnhDaiDienUser {
    private String username;
    private int anhDaiDien;

    public AnhDaiDienUser(String username, int anhDaiDien) {
        this.username = username;
        this.anhDaiDien = anhDaiDien;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAnhDaiDien() {
        return anhDaiDien;
    }

    public void setAnhDaiDien(int anhDaiDien) {
        this.anhDaiDien = anhDaiDien;
    }
}
