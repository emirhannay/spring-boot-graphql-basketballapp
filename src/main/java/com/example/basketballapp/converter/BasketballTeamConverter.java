package com.example.basketballapp.converter;

import com.example.basketballapp.entity.BasketballTeam;
import com.example.basketballapp.entity.dtos.CreateBasketballTeamRequestDTO;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BasketballTeamConverter {

    public BasketballTeam toBasketballTeam(CreateBasketballTeamRequestDTO requestDTO){
        BasketballTeam basketballTeam = new BasketballTeam();
        basketballTeam.setName(requestDTO.name());
        basketballTeam.setFoundingDate(new Date());
        return basketballTeam;
    }
}
