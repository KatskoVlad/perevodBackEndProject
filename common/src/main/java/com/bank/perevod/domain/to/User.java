package com.bank.perevod.domain.to;

import java.util.Objects;

public class User {

    private Integer idUser;
    private String login;
    private String password;
    private String dateReg;
    private boolean isBloked;
    private String sex;
    private Integer idRole;
    private String surname;
    private String name;
    private String email;

    public User() {
    }

    public User(Integer idUser, String login, String password,
                String dateReg, boolean isBloked, String sex,
                Integer idRole, String surname, String name, String email) {
        this.idUser = idUser;
        this.login = login;
        this.password = password;
        this.dateReg = dateReg;
        this.isBloked = isBloked;
        this.sex = sex;
        this.idRole = idRole;
        this.surname = surname;
        this.name = name;
        this.email = email;
    }
    public User(String login, String password,
                String dateReg, boolean isBloked, String sex,
                Integer idRole, String surname, String name, String email) {
        this.idUser = idUser;
        this.login = login;
        this.password = password;
        this.dateReg = dateReg;
        this.isBloked = isBloked;
        this.sex = sex;
        this.idRole = idRole;
        this.surname = surname;
        this.name = name;
        this.email = email;
    }
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
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

    public String getDateReg() {
        return dateReg;
    }

    public void setDateReg(String dateReg) {
        this.dateReg = dateReg;
    }

    public boolean isBloked() {
        return isBloked;
    }

    public void setBloked(boolean bloked) {
        isBloked = bloked;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isBloked == user.isBloked &&
                idUser.equals(user.idUser) &&
                login.equals(user.login) &&
                password.equals(user.password) &&
                dateReg.equals(user.dateReg) &&
                sex.equals(user.sex) &&
                idRole.equals(user.idRole) &&
                surname.equals(user.surname) &&
                name.equals(user.name) &&
                email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, login, password, dateReg, isBloked, sex, idRole, surname, name, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", dateReg=" + dateReg +
                ", isBloked=" + isBloked +
                ", sex=" + sex +
                ", idRole=" + idRole +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
