package com.example.server.flight;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    public Map<FlightState, List<Flight>> flightsMap() {
        List<Flight> holdFlights = findFlightByState(FlightState.HOLD);
        List<Flight> approachFlights = findFlightByState(FlightState.APPROACH);
        List<Flight> departureFlights = findFlightByState(FlightState.DEPARTURE);
        List<Flight> onStandFlights = findFlightByState(FlightState.ONSTAND);
        List<Flight> taxiFlights = findFlightByState(FlightState.TAXI);
        List<Flight> runwayFlights = findFlightByState(FlightState.RUNWAY);

        Map<FlightState, List<Flight>> map = new HashMap<>();
        map.put(FlightState.HOLD, holdFlights);
        map.put(FlightState.APPROACH, approachFlights);
        map.put(FlightState.DEPARTURE, departureFlights);
        map.put(FlightState.ONSTAND, onStandFlights);
        map.put(FlightState.TAXI, taxiFlights);
        map.put(FlightState.RUNWAY, runwayFlights);

        return map;
    }


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
