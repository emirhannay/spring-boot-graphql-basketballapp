package com.example.basketballapp.controller;

import com.example.basketballapp.entity.BasketballPlayer;
import com.example.basketballapp.entity.dtos.AssignPlayerToTeamRequestDTO;
import com.example.basketballapp.entity.dtos.CreateBasketballPlayerRequestDTO;
import com.example.basketballapp.service.BasketballPlayerService;
import com.example.basketballapp.validator.BaseValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BasketballPlayerController {

    private final BasketballPlayerService basketballPlayerService;
    private final BaseValidator baseValidator;


    @SchemaMapping(typeName = "Query",value = "allPlayers")
    public List<BasketballPlayer> getAllPlayers(){
        return basketballPlayerService.getAll();
    }

    @MutationMapping
    public void createPlayer(@Argument CreateBasketballPlayerRequestDTO basketballPlayerRequestDTO) {
        baseValidator.isTheStringNullOrEmpty(basketballPlayerRequestDTO.firstName(),"First Name");
        baseValidator.isTheStringNullOrEmpty(basketballPlayerRequestDTO.lastName(),"Last Name");
        basketballPlayerService.create(basketballPlayerRequestDTO);
    }
    @MutationMapping
    public void deletePlayer(@Argument Long id){
        baseValidator.isZeroOrLessThanZero(id,"Id");
        basketballPlayerService.delete(2L);
    }
    @MutationMapping
    public void assignPlayerToTeam(@Argument AssignPlayerToTeamRequestDTO assignPlayerToTeamRequestDTO){
        baseValidator.isZeroOrLessThanZero(assignPlayerToTeamRequestDTO.playerId(),"Player Id");
        baseValidator.isTheStringNullOrEmpty(assignPlayerToTeamRequestDTO.name(),"Name");
        basketballPlayerService.assignPlayerToTeam(assignPlayerToTeamRequestDTO);
    }
}
