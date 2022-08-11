package com.example.basketballapp.entity;

import com.example.basketballapp.entity.enums.BasketballPlayerPosition;
import com.example.basketballapp.exception.BaseException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class BasketballPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private BasketballPlayerPosition position;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    @Setter(AccessLevel.NONE)
    private BasketballTeam basketballTeam;

    public void assignToTeam(BasketballTeam basketballTeam){
        if(basketballTeam.getBasketballPlayers().size() == 10){
            throw new BaseException("The team has reached its maximum capacity.");
        }
        this.basketballTeam = basketballTeam;
    }

}
