package com.example.server.repository;

import com.example.server.model.Flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    List<Flight> findByState(String state);

    Flight findById(int id);

    Flight save(Flight flight);

    void deleteById(int id);
/*
    //@Query("SELECT f FROM flights f WHERE f.state = :state")
    List<Flight> findFlightByState(String state);


    List<Flight> findFlightById(int id);


    Object save(Flight flight);


    @Query("UPDATE flights f SET f.state = :state WHERE f.flightID = :id")
    void updateStateById(int id, String newState);


    //@Query("DELETE FROM flights f WHERE f.flight = :id")
    void deleteFlightById(int id); */

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