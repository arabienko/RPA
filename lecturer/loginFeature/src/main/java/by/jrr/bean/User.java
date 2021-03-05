package by.jrr.bean;

import java.util.Objects;

public class User {
private String login;
private String password;
private int loginAttemp;
private boolean blocked;

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLoginAttemp() {
        return loginAttemp;
    }

    public void setLoginAttemp(int loginAttemp) {
        this.loginAttemp = loginAttemp;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return loginAttemp == user.loginAttemp && blocked == user.blocked && Objects.equals(login, user.login) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, loginAttemp, blocked);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", loginAttemp=" + loginAttemp +
                ", blocked=" + blocked +
                '}';
    }
}
