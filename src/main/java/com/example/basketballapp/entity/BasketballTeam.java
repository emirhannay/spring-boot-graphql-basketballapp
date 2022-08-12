package com.example.basketballapp.entity;

import com.example.basketballapp.exception.BaseException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
public class BasketballTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Temporal(value = TemporalType.DATE)
    private Date foundingDate;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "basketballTeam",fetch = FetchType.EAGER)
    private Set<BasketballPlayer> basketballPlayers = new HashSet<>();

    public void addPlayer(BasketballPlayer basketballPlayer){
        if(basketballPlayers.size() == 10){
            throw new BaseException("The team has reached its maximum capacity.");
        }
        basketballPlayers.add(basketballPlayer);
    }

    }


