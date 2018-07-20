package cn.joey.entity;

import java.io.Serializable;

public class User implements Serializable{
    private int i;
    private String username;
    private String password;
    private int port;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public User(){

    }
    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(int i, String username, String password,int port) {
        this.i = i;
        this.username = username;
        this.password = password;
        this.port = port;
    }
}
