package com.example.server.flight;

//import com.example.server.flight.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/flights")
@AllArgsConstructor
//@CrossOrigin(origins = "http://localhost:3000")
public class FlightController {


    private final FlightService flightService;

/*
    private Map<String, List<Flight>> flightsMap() {
        List<Flight> holdFlights = flightService.findFlightByState("hold");
        List<Flight> approachFlights = flightService.findFlightByState("approach");
        List<Flight> departureFlights = flightService.findFlightByState("departure");
        List<Flight> onStandFlights = flightService.findFlightByState("onStand");
        List<Flight> taxiFlights = flightService.findFlightByState("taxi");
        List<Flight> runwayFlights = flightService.findFlightByState("runway");

        Map<String, List<Flight>> map = new HashMap<>();
        map.put("hold", holdFlights);
        map.put("approach", approachFlights);
        map.put("departure", departureFlights);
        map.put("onStand", onStandFlights);
        map.put("taxi", taxiFlights);
        map.put("runway", runwayFlights);

        return map;
    } */

    private Map<FlightState, List<Flight>> flightsMap() {
        List<Flight> holdFlights = flightService.findFlightByState(FlightState.HOLD);
        List<Flight> approachFlights = flightService.findFlightByState(FlightState.APPROACH);
        List<Flight> departureFlights = flightService.findFlightByState(FlightState.DEPARTURE);
        List<Flight> onStandFlights = flightService.findFlightByState(FlightState.ONSTAND);
        List<Flight> taxiFlights = flightService.findFlightByState(FlightState.TAXI);
        List<Flight> runwayFlights = flightService.findFlightByState(FlightState.RUNWAY);

        Map<FlightState, List<Flight>> map = new HashMap<>();
        map.put(FlightState.HOLD, holdFlights);
        map.put(FlightState.APPROACH, approachFlights);
        map.put(FlightState.DEPARTURE, departureFlights);
        map.put(FlightState.ONSTAND, onStandFlights);
        map.put(FlightState.TAXI, taxiFlights);
        map.put(FlightState.RUNWAY, runwayFlights);

        return map;
    }



    @GetMapping("/atc")
    public ResponseEntity<Map<FlightState, List<Flight>>> getData() {
        return new ResponseEntity<>(flightsMap(), HttpStatus.OK);
    }

    @PostMapping("/new-flight")
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        Flight createdFlight = flightService.addFlight(flight);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFlight);
    }



    @PutMapping("/{id}")
    public ResponseEntity<Optional<Flight>> updateFlightState(@PathVariable("id") int id, @RequestParam("state") FlightState state) {
        boolean updated = flightService.updateStateById(id, state);
        if (updated) {
            Optional<Flight> updatedFlight = flightService.findFlightById(id);
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

