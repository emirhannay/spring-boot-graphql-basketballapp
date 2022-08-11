package com.example.basketballapp.converter;

import com.example.basketballapp.entity.BasketballPlayer;
import com.example.basketballapp.entity.dtos.CreateBasketballPlayerRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class BasketballPlayerConverter {
    public BasketballPlayer toBasketballPlayer(CreateBasketballPlayerRequestDTO createBasketballPlayerRequestDTO){
        BasketballPlayer basketballPlayer = new BasketballPlayer();
        basketballPlayer.setFirstName(createBasketballPlayerRequestDTO.firstName());
        basketballPlayer.setLastName(createBasketballPlayerRequestDTO.lastName());
        basketballPlayer.setPosition(createBasketballPlayerRequestDTO.position());
        return basketballPlayer;
    }
}
