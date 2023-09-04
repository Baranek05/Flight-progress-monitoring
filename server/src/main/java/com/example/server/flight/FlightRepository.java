package com.example.server.flight;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    //List<Flight> findByState(String state);

    List<Flight> findByState(FlightState state);

    Optional<Flight> findById(int id);

    //Flight save(Flight flight);


    void deleteById(int id);



}
