package com.example.server.flight;

import com.example.server.flight.Flight;
import com.example.server.flight.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;



    public List<Flight> findFlightByState(String state) {
        return flightRepository.findByState(state);
    }

    public Flight findFlightById(int id) {
        return flightRepository.findById(id);
    }

    public Flight addFlight(Flight flight){
        return flightRepository.save(flight);
    }


    public boolean updateStateById(int id, String newState) {
        Flight flight = new Flight();
        flight.setState(newState);
        return true;
    }


    public boolean deleteFlightById(int id) {
        flightRepository.deleteById(id);
        return true;
    }
}