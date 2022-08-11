package com.example.basketballapp.repository;

import com.example.basketballapp.entity.BasketballPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface BasketballPlayerRepository extends JpaRepository<BasketballPlayer,Long> {

    BasketballPlayer findByFirstName( String firstName);

}
