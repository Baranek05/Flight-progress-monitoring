package com.example.server.repository;

import com.example.server.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByState(String state);

    Flight findById(int id);

    //Flight save(Flight flight);

    void deleteById(int id);

    /*
    //@Query("SELECT f FROM flights f WHERE f.state = :state")
    List<Flight> findFlightByState(String state);


    List<Flight> findFlightById(int id);


    Object save(Flight flight);


    @Query("UPDATE flights f SET f.state = :state WHERE f.flightID = :id")
    void updateStateById(int id, String newState);


    //@Query("DELETE FROM flights f WHERE f.flight = :id")
    void deleteFlightById(int id); */
}
