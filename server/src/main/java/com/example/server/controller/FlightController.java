package com.example.server.controller;

import com.example.server.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.server.model.Flight;
import com.example.server.repository.FlightRepository;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FlightController {

    private final FlightRepository flightRepository;
    private final FlightService flightService;

    public FlightController(FlightRepository flightRepository, FlightService flightService) {
        this.flightRepository = flightRepository;
        this.flightService = flightService;
    }

    private Map<String, List<Flight>> flightsMap() {
        List<Flight> holdFlights = flightRepository.findFlightByState("hold");
        List<Flight> approachFlights = flightRepository.findFlightByState("approach");
        List<Flight> departureFlights = flightRepository.findFlightByState("departure");
        List<Flight> onStandFlights = flightRepository.findFlightByState("onStand");
        List<Flight> taxiFlights = flightRepository.findFlightByState("taxi");
        List<Flight> runwayFlights = flightRepository.findFlightByState("runway");

        Map<String, List<Flight>> map = new HashMap<>();
        map.put("hold", holdFlights);
        map.put("approach", approachFlights);
        map.put("departure", departureFlights);
        map.put("onStand", onStandFlights);
        map.put("taxi", taxiFlights);
        map.put("runway", runwayFlights);

        return map;
    }

    @GetMapping("/atc")
    public String atc(Model model) {
        model.addAttribute("flightsMap", flightsMap());
        return "atc";
    }


    @PostMapping("/new-flight")
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        Flight createdFlight = flightService.addFlight(flight);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFlight);
    }

    /* @PostMapping("/flight/{id}")
    public Flight updateFlight(@PathVariable int id, @RequestParam("newState") String newState) {
        Flight flight = (Flight) flightService.findFlightById(id);
        flight.setState(newState);
        flightService.addFlight(flight);
        return flight;
    } */

    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlightState(@PathVariable("id") int id, @RequestParam("state") String state) {
        boolean updated = flightService.updateStateById(id, state);
        if (updated) {
            Flight updatedFlight = (Flight) flightService.findFlightById(id);
            return ResponseEntity.ok(updatedFlight);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFlight(@PathVariable int id) {
        boolean deleted = flightService.deleteFlightById(id);
        if (deleted) {
            return ResponseEntity.ok("Flight deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

