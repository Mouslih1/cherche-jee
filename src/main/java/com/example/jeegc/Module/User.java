package com.example.jeegc.Module;

import java.lang.*;
public class User {
    private int id;
    private String name;
    private String ville;
    private int age;

    public User() {
    }

    public User(int id, String name, String ville, int age) {
        this.id = id;
        this.name = name;
        this.ville = ville;
        this.age = age;
    }

    public User(String name, String ville, int age) {
        this.name = name;
        this.ville = ville;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ville='" + ville + '\'' +
                ", age=" + age +
                '}';
    }
}
