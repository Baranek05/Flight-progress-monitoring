package com.example.server.controller;

import org.springframework.web.bind.annotation.*;

import com.example.server.model.Flight;
import com.example.server.repository.FlightRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FlightController {

    private final FlightRepository flightRepository;

    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    private Map<String, List<Flight>> flightsMap() {
        List<Flight> holdFlights = flightRepository.findByState("hold");
        List<Flight> approachFlights = flightRepository.findByState("approach");
        List<Flight> departureFlights = flightRepository.findByState("departure");
        List<Flight> onStandFlights = flightRepository.findByState("onStand");
        List<Flight> taxiFlights = flightRepository.findByState("taxi");
        List<Flight> runwayFlights = flightRepository.findByState("runway");

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

    @GetMapping("/new-flight")
    public String addFlight() {
        return "new_flight";
    }

    @PostMapping("/new-flight")
    public String addFlight(@RequestParam("flightInfo") String flightInfo) {
        flightRepository.save(new Flight(flightInfo, "hold"));
        return "redirect:/atc";
    }

    @PostMapping("/flight/{id}")
    public String updateFlight(@PathVariable Long id, @RequestParam("newState") String newState) {
        Flight flight = (Flight) flightRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid flight Id:" + id));
        flight.setState(newState);
        flightRepository.save(flight);
        return "redirect:/atc";
    }

    @PostMapping("/delete-flight/{id}")
    public String deleteFlight(@PathVariable Long id) {
        flightRepository.deleteById(id);
        return "redirect:/atc";
    }

}

