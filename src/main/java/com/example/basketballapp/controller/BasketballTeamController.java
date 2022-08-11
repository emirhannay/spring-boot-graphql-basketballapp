package com.example.basketballapp.controller;

import com.example.basketballapp.entity.BasketballTeam;
import com.example.basketballapp.entity.dtos.CreateBasketballTeamRequestDTO;
import com.example.basketballapp.repository.BasketballTeamRepository;
import com.example.basketballapp.service.BasketballTeamService;
import com.example.basketballapp.validator.BaseValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BasketballTeamController {

    private final BasketballTeamService basketballTeamService;
    private final BaseValidator baseValidator;

    @SchemaMapping(typeName = "Query",value = "allTeams")
    public List<BasketballTeam> getAllTeams(){
        return basketballTeamService.getAll();
    }

    @MutationMapping
    public void createTeam(@Argument CreateBasketballTeamRequestDTO createBasketballTeamRequestDTO){
        baseValidator.isTheStringNullOrEmpty(createBasketballTeamRequestDTO.name(),"Team Name");
        basketballTeamService.create(createBasketballTeamRequestDTO);
    }
}
