package com.example.basketballapp;

import com.example.basketballapp.entity.BasketballPlayer;
import com.example.basketballapp.entity.BasketballTeam;
import com.example.basketballapp.entity.dtos.CreateBasketballPlayerRequestDTO;
import com.example.basketballapp.entity.dtos.CreateBasketballTeamRequestDTO;
import com.example.basketballapp.entity.enums.BasketballPlayerPosition;
import com.example.basketballapp.repository.BasketballTeamRepository;
import com.example.basketballapp.service.BasketballTeamService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

@SpringBootTest
public class BasketballTeamServiceTests {
    private final BasketballTeamRepository basketballTeamRepository;
    private final BasketballTeamService basketballTeamService;

    @Autowired
    public BasketballTeamServiceTests(BasketballTeamRepository basketballTeamRepository, BasketballTeamService basketballTeamService) {
        this.basketballTeamRepository = basketballTeamRepository;
        this.basketballTeamService = basketballTeamService;
    }

    @Test
    public void getAllTeamsTest(){
        List<BasketballTeam> basketballTeams = basketballTeamRepository.findAll();
        Assertions.assertEquals(basketballTeams.size() > 0, true);
    }

    @Test
    public void saveBasketballPlayerTest(){

        basketballTeamService.create(new CreateBasketballTeamRequestDTO("Producter Team"));
        BasketballTeam basketballTeam = basketballTeamRepository.findByName("Producter Team").orElseThrow(
                () -> new RuntimeException()
        );

    }
}
