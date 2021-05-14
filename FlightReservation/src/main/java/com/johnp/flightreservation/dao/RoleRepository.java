package com.johnp.flightreservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johnp.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
