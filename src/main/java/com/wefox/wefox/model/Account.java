package com.wefox.wefox.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue
    private Integer accountId;

    private String name;
    private String email;
    private Date birthdate;
    private Timestamp lastPaymentDate;
    private Timestamp createdOn;

    public Integer getId() {
        return accountId;
    }

    public void setId(Integer id) {
        this.accountId = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Timestamp getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setLastPaymentDate(Timestamp lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
