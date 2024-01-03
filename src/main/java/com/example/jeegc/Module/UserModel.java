package com.example.jeegc.Module;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private String ville;
    private List<User> users = new ArrayList<>();

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
