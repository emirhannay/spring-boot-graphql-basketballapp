package com.example.basketballapp.service;

import com.example.basketballapp.entity.BasketballTeam;
import com.example.basketballapp.entity.dtos.CreateBasketballTeamRequestDTO;

import java.util.List;

public interface BasketballTeamService {
    public void create(CreateBasketballTeamRequestDTO createBasketballTeamRequestDTO);
    public void delete(Long id);
    public List<BasketballTeam> getAll();
}
