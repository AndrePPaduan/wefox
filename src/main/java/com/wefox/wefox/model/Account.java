package com.wefox.wefox.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private Timestamp birthdate;
    private Timestamp lastPayment;
    private Timestamp creationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Timestamp birthdate) {
        this.birthdate = birthdate;
    }

    public Timestamp getLastPayment() {
        return lastPayment;
    }

    public void setLastPayment(Timestamp lastPayment) {
        this.lastPayment = lastPayment;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }
}
