package com.example.server.flight;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
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
    private FlightState state;


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
