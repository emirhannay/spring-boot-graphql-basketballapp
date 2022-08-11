package com.example.basketballapp.service.impl;

import com.example.basketballapp.converter.BasketballPlayerConverter;
import com.example.basketballapp.entity.BasketballPlayer;
import com.example.basketballapp.entity.BasketballTeam;
import com.example.basketballapp.entity.dtos.AssignPlayerToTeamRequestDTO;
import com.example.basketballapp.entity.dtos.CreateBasketballPlayerRequestDTO;
import com.example.basketballapp.exception.BaseException;
import com.example.basketballapp.repository.BasketballPlayerRepository;
import com.example.basketballapp.repository.BasketballTeamRepository;
import com.example.basketballapp.service.BasketballPlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketballPlayerServiceImpl implements BasketballPlayerService {

    private final BasketballPlayerRepository basketballPlayerRepository;
    private final BasketballPlayerConverter basketballPlayerConverter;
    private final BasketballTeamRepository basketballTeamRepository;

    @Override
    public void create(CreateBasketballPlayerRequestDTO createBasketballPlayerRequestDTO) {
       BasketballPlayer basketballPlayer = basketballPlayerConverter.toBasketballPlayer((createBasketballPlayerRequestDTO));
       basketballPlayerRepository.save(basketballPlayer);
    }

    @Override
    public void delete(Long id) {
       BasketballPlayer basketballPlayer = getById(id);
       basketballPlayerRepository.delete(basketballPlayer);

    }

    @Override
    public List<BasketballPlayer> getAll() {
        return basketballPlayerRepository.findAll();
    }

    @Override
    public void assignPlayerToTeam(AssignPlayerToTeamRequestDTO request) {
        BasketballTeam basketballTeam = basketballTeamRepository.findByName(request.name()).orElseThrow(
                () -> new BaseException("There is no such team.")
        );
        BasketballPlayer basketballPlayer = getById(request.playerId());
        basketballPlayer.assignToTeam(basketballTeam);
        basketballPlayerRepository.save(basketballPlayer);
    }

    public BasketballPlayer getById(Long id){
        BasketballPlayer basketballPlayer = basketballPlayerRepository.findById(id).orElseThrow(
                () -> new BaseException("There is no such player.")
        );
        return  basketballPlayer;
    }
}
