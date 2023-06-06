package com.example.server.repository;

import com.example.server.model.User;

import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public interface UserRepository extends JpaRepository {
    User getUserData(String username);


    /*
    private EntityManager entityManager;

    public User getUser(String login) {
        Query query = entityManager.createQuery("SELECT u FROM User u LEFT JOIN u.userDetails ud WHERE u.login = :login");
        query.setParameter("login", login);
        User user = (User) query.getSingleResult();
        return user;
    }

    public Object[] getUserData(String login) {
        Query query = entityManager.createQuery("SELECT u.login, ud.name, ud.surname, ud.jobDetails FROM User u LEFT JOIN u.userDetails ud WHERE u.login = :login");
        query.setParameter("login", login);
        Object[] userData = (Object[]) query.getSingleResult();
        return userData;
    }

    public void addUser(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.save(user.getUserDetails());
        session.save(user);
    }

    public int getUserDetailsId(User user) {
        Query query = entityManager.createQuery("SELECT ud.detailsUserID FROM UserDetails ud WHERE ud.name = :name AND ud.surname = :surname AND ud.jobDetails = :jobDetails");
        query.setParameter("name", user.getUserDetails().getName());
        query.setParameter("surname", user.getUserDetails().getSurname());
        query.setParameter("jobDetails", user.getUserDetails().getJobDetails());
        int userDetailsId = (int) query.getSingleResult();
        return userDetailsId;
    } */

}

