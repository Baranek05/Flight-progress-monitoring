package com.example.server.flight;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "flights", schema = "public", catalog = "postgres")
public class Flight {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "flightID")
    private int flightId;
    @Basic
    @Column(name = "flightInfo")
    private String flightInfo;
    @Basic
    @Column(name = "state")
    private String state;

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight that = (Flight) o;
        return flightId == that.flightId && Objects.equals(flightInfo, that.flightInfo) && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, flightInfo, state);
    }
}
