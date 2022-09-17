package com.roadrunner.accountservice.entity;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;


@Table(value = "accounts")
public class Account implements Serializable {


    private static final long serialVersionUID = 2206818457672071630L;
    @PrimaryKey
    private String id= UUID.randomUUID().toString();

    @Column(value = "uname")
    private String username;

    @Column(value = "name")
    private String name;

    @Column(value = "email")
    private String email;

    @Column(value = "pwd")
    private String password;

    @Column(value = "is_active")
    private Boolean active;

    public Account(String id, String username, String name, String email, String password, Boolean active) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.active = active;
    }

    public Account() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(username, account.username) &&
                Objects.equals(name, account.name) &&
                Objects.equals(email, account.email) &&
                Objects.equals(password, account.password) &&
                Objects.equals(active, account.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                '}';
    }
}
