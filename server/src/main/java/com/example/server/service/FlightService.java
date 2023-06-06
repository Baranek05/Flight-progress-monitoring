package com.example.server.service;

import com.example.server.model.Flight;
import com.example.server.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }


    public List<Flight> findFlightByState(String state) {
        return null;
    }

    public List<Flight> findFlightById(int id) {
        return null;
    }

    public Flight addFlight(Flight flight){
        flightRepository.save(flight);
        return flight;
    }


    public boolean updateStateById(int id, String newState) {
        Flight flight = new Flight();
        flight.setState(newState);
        return true;
    }


    public boolean deleteFlightById(int id) {
        flightRepository.deleteFlightById(id);
        return true;
    }


    public Flight updateFlight(Flight existingFlight) {

    }
}
