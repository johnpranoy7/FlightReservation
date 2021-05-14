package com.johnp.flightreservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johnp.flightreservation.entities.User;
import java.lang.String;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findByEmail(String email);
}
