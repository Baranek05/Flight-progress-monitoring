package com.example.server.model;

import javax.persistence.*;

@Entity
@Table(name = "flights", schema = "public", catalog = "postgres")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flightID")
    private int id;

    @Column(name = "flightInfo")
    private String flightInfo;

    @Column(name = "state")
    private String state;

    //public Flight() {}

    public Flight() {
        this.flightInfo = flightInfo;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public String getFlightInfo() {
        return flightInfo;
    }

    public void setFlightInfo(String flightInfo) {
        this.flightInfo = flightInfo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

