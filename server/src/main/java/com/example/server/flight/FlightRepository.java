package com.example.server.flight;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByState(String state);

    Flight findById(int id);

    //Flight save(Flight flight);


    void deleteById(int id);



}
