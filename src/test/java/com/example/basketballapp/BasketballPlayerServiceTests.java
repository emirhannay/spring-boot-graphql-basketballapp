package com.example.basketballapp;

import com.example.basketballapp.entity.BasketballPlayer;
import com.example.basketballapp.entity.dtos.AssignPlayerToTeamRequestDTO;
import com.example.basketballapp.entity.dtos.CreateBasketballPlayerRequestDTO;
import com.example.basketballapp.entity.enums.BasketballPlayerPosition;
import com.example.basketballapp.repository.BasketballPlayerRepository;
import com.example.basketballapp.service.BasketballPlayerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

@SpringBootTest
public class BasketballPlayerServiceTests {


    private final BasketballPlayerRepository basketballPlayerRepository;
    private final BasketballPlayerService basketballPlayerService;

    @Autowired
    public BasketballPlayerServiceTests(BasketballPlayerRepository basketballPlayerRepository, BasketballPlayerService basketballPlayerService) {
        this.basketballPlayerRepository = basketballPlayerRepository;
        this.basketballPlayerService = basketballPlayerService;
    }

    @Test
    public void saveBasketballPlayerTest(){

        basketballPlayerService.create(new CreateBasketballPlayerRequestDTO("Producter","Ay",BasketballPlayerPosition.CENTER));
        BasketballPlayer basketballPlayer = basketballPlayerRepository.findByFirstName("Producter");
        if(Objects.isNull(basketballPlayer)){
            throw new RuntimeException();
        }
        Assertions.assertEquals(basketballPlayer.getId() > 0,true );
    }

    @Test
    public void deletePlayerTest(){
        BasketballPlayer basketballPlayer = new BasketballPlayer();
        basketballPlayer.setLastName("Producter");
        basketballPlayer.setFirstName("Producter");
        basketballPlayer.setPosition(BasketballPlayerPosition.SHOOTINGGUARD);
        basketballPlayerRepository.saveAndFlush(basketballPlayer);
       basketballPlayerService.delete(basketballPlayer.getId());
        BasketballPlayer tempPlayer = basketballPlayerRepository.findByFirstName("Producter");
        if(tempPlayer != null){
            throw new RuntimeException();
        }

    }

    @Test
    public void assignPlayerToTeamTest(){
        BasketballPlayer basketballPlayer = new BasketballPlayer();
        basketballPlayer.setLastName("Producter");
        basketballPlayer.setFirstName("Producter");
        basketballPlayer.setPosition(BasketballPlayerPosition.SHOOTINGGUARD);
        basketballPlayerRepository.saveAndFlush(basketballPlayer);
        basketballPlayerService.assignPlayerToTeam(new AssignPlayerToTeamRequestDTO("New York Knicks",basketballPlayer.getId()));
        BasketballPlayer tempPlayer = basketballPlayerRepository.findByFirstName("Producter");
        if(basketballPlayer.getBasketballTeam().getName().equals("Producter")){

        }
        else {
            throw new RuntimeException();
        }
    }

    @Test
    public void getAllPlayersTest(){
        List<BasketballPlayer> basketballPlayerList = basketballPlayerService.getAll();
        Assertions.assertEquals(basketballPlayerList.size() > 0, true);

    }
}
