package com.example.server.repository;

import com.example.server.model.Flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    @Query("SELECT f FROM Flight f WHERE f.state = :state")
    List<Flight> findFlightByState(String state);

    List<Flight> findFlightById(int id);

    void addFlight(Flight flight);

    @Query("UPDATE Flight SET state = :state WHERE \"flightID\" = :id")
    void updateStateById(int id, String newState);

    @Query("DELETE FROM Flight WHERE \"flightID\" = :id")
    void deleteFlightById(int id);

}

/*
@Repository
@Transactional
public class FlightRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Flight> getFlightsByState(String state) {
        String query = "SELECT f FROM Flight f WHERE f.state = :state";
        return entityManager.createQuery(query, Flight.class)
                .setParameter("state", state)
                .getResultList();
    }

    public void updateState(int id, String newState) {
        Flight flight = entityManager.find(Flight.class, id);
        if (flight != null) {
            flight.setState(newState);
        }
    }

    public void addFlight(String info, String state) {
        Flight flight = new Flight(info, state);
        entityManager.persist(flight);
    }

    public void deleteFlightById(int id) {
        Flight flight = entityManager.find(Flight.class, id);
        if (flight != null) {
            entityManager.remove(flight);
        }
    }
}

*/