package com.example.basketballapp.service.impl;

import com.example.basketballapp.converter.BasketballTeamConverter;
import com.example.basketballapp.entity.BasketballTeam;
import com.example.basketballapp.entity.dtos.CreateBasketballTeamRequestDTO;
import com.example.basketballapp.repository.BasketballTeamRepository;
import com.example.basketballapp.service.BasketballTeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketballTeamServiceImpl implements BasketballTeamService {

    private final BasketballTeamConverter basketballTeamConverter;
    private final BasketballTeamRepository basketballTeamRepository;

    @Override
    public void create(CreateBasketballTeamRequestDTO createBasketballTeamRequestDTO) {
       BasketballTeam basketballTeam = basketballTeamConverter.toBasketballTeam(createBasketballTeamRequestDTO);
       basketballTeamRepository.save(basketballTeam);
    }

    @Override
    public void delete(Long id) {
        basketballTeamRepository.deleteById(id);
    }

    @Override
    public List<BasketballTeam> getAll() {
        List<BasketballTeam> basketballTeams = basketballTeamRepository.findAll();
        return basketballTeams;
    }
}
