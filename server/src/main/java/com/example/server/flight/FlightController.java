package com.example.server.flight;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/flights")
@AllArgsConstructor
public class FlightController {


    private final FlightService flightService;


    @GetMapping("/atc")
    public ResponseEntity<Map<FlightState, List<Flight>>> getData() {
        return new ResponseEntity<>(flightService.flightsMap(), HttpStatus.OK);
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

