package com.example.travelo_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.travelo_backend.model.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
    Optional<Seat> findByFlight_IdFlight(Integer flightId);
}