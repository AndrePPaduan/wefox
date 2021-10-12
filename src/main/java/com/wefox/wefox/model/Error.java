package com.wefox.wefox.model;

import javax.persistence.*;

@Entity
@Table(name = "error")
public class Error {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private int paymentId;

    private ErrorType errorType;

    private String description;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
