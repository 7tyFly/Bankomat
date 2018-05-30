package com;

public class Client {

    int id;
    String fullName;
    int cash;
    String password;
    String login;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", cash=" + cash +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                '}';
    }

    public Client(int id, String fullName, int cash, String password, String login) {
        this.id = id;
        this.fullName = fullName;
        this.cash = cash;
        this.password = password;
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
