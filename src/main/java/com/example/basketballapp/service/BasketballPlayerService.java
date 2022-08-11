package com.example.basketballapp.service;

import com.example.basketballapp.entity.BasketballPlayer;
import com.example.basketballapp.entity.dtos.AssignPlayerToTeamRequestDTO;
import com.example.basketballapp.entity.dtos.CreateBasketballPlayerRequestDTO;

import java.util.List;

public interface BasketballPlayerService {

    public void create(CreateBasketballPlayerRequestDTO createBasketballPlayerRequestDTO);
    public void delete(Long id);
    public List<BasketballPlayer> getAll();
    public void assignPlayerToTeam(AssignPlayerToTeamRequestDTO assignPlayerToTeamRequestDTO);
    public BasketballPlayer getById(Long id);
}
