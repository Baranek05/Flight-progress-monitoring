package com.example.server.repository;

import com.example.server.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByState(String state);

    Flight findById(int id);

    //Flight save(Flight flight);


    void deleteById(int id);



}
