package com.android.marceloramos.activity;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String email;

    public Usuario(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
