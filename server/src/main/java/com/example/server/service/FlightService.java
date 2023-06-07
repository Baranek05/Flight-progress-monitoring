package com.example.server.service;

import com.example.server.model.Flight;
import com.example.server.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }




    //public Flight updateFlight(Flight existingFlight) {

    //}


    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(int id) {
        return flightRepository.findById(id).orElse(null);
    }

    public List<Flight> getFlightsByState(String state) {
        return flightRepository.findFlightByState(state);
    }

    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public void updateFlightStateById(int id, String newState) {
        flightRepository.updateStateById(id, newState);
    }

    public void deleteFlightById(int id) {
        flightRepository.deleteFlightById(id);
    }

    /*
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
    } */
}
