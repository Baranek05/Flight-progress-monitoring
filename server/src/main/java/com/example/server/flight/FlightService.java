package com.example.server.flight;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;
    private final RabbitTemplate rabbitTemplate;


    public List<Flight> findFlightByState(FlightState state) {
        return flightRepository.findByState(state);
    }

    public Optional<Flight> findFlightById(int id) {
        return flightRepository.findById(id);
    }

    public Flight addFlight(Flight flight){
        return flightRepository.save(flight);
    }


    public boolean updateStateById(int id, FlightState newState) {
        Optional<Flight> flightOptional = flightRepository.findById(id);
        if (flightOptional.isPresent()) {
            Flight flight = flightOptional.get();
            flight.setState(newState);
            flightRepository.save(flight);
            return true;
        } else {
            return false;
        }
    }


    public boolean deleteFlightById(int id) {
        flightRepository.deleteById(id);
        return true;
    }
}
