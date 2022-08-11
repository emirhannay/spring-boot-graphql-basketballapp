package com.example.basketballapp.repository;

import com.example.basketballapp.entity.BasketballTeam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BasketballTeamRepository extends JpaRepository<BasketballTeam, Long> {
    Optional<BasketballTeam> findByName(String name);
}
