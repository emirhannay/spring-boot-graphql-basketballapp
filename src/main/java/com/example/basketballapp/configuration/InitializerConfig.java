package com.example.basketballapp.configuration;

import com.example.basketballapp.entity.BasketballPlayer;
import com.example.basketballapp.entity.BasketballTeam;
import com.example.basketballapp.entity.enums.BasketballPlayerPosition;
import com.example.basketballapp.repository.BasketballPlayerRepository;
import com.example.basketballapp.repository.BasketballTeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@RequiredArgsConstructor
@Component
public class InitializerConfig implements ApplicationRunner {
    private final BasketballTeamRepository basketballTeamRepository;
    private final BasketballPlayerRepository basketballPlayerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BasketballTeam basketballTeam = new BasketballTeam();
        basketballTeam.setName("New York Knicks");
        basketballTeam.setFoundingDate(new Date());
        basketballTeamRepository.saveAndFlush(basketballTeam);

        BasketballTeam basketballTeam2 = new BasketballTeam();
        basketballTeam2.setName("Chicago Bulls");
        basketballTeam2.setFoundingDate(new Date());
        basketballTeamRepository.saveAndFlush(basketballTeam2);

        BasketballTeam basketballTeam3 = new BasketballTeam();
        basketballTeam3.setName("Golden State Warriors");
        basketballTeam3.setFoundingDate(new Date());
        basketballTeamRepository.saveAndFlush(basketballTeam3);

        BasketballTeam basketballTeam4 = new BasketballTeam();
        basketballTeam4.setName("Houston Rockets");
        basketballTeam4.setFoundingDate(new Date());
        basketballTeamRepository.saveAndFlush(basketballTeam4);



        BasketballPlayer player1 = new BasketballPlayer();
        player1.setPosition(BasketballPlayerPosition.POINTGUARD);
        player1.setFirstName("Emirhan");
        player1.setLastName("Ay");
        player1.assignToTeam(basketballTeam);

        BasketballPlayer player2 = new BasketballPlayer();
        player2.setPosition(BasketballPlayerPosition.CENTER);
        player2.setFirstName("David");
        player2.setLastName("Layah");
        player2.assignToTeam(basketballTeam2);

        BasketballPlayer player3 = new BasketballPlayer();
        player3.setPosition(BasketballPlayerPosition.CENTER);
        player3.setFirstName("David");
        player3.setLastName("Layah");
        player3.assignToTeam(basketballTeam3);

        BasketballPlayer player4 = new BasketballPlayer();
        player4.setPosition(BasketballPlayerPosition.CENTER);
        player4.setFirstName("David");
        player4.setLastName("Layah");
        player4.assignToTeam(basketballTeam4);

        BasketballPlayer player5 = new BasketballPlayer();
        player5.setPosition(BasketballPlayerPosition.CENTER);
        player5.setFirstName("David");
        player5.setLastName("Layah");
        player5.assignToTeam(basketballTeam);

        basketballPlayerRepository.saveAndFlush(player1);
        basketballPlayerRepository.saveAndFlush(player2);
        basketballPlayerRepository.saveAndFlush(player3);
        basketballPlayerRepository.saveAndFlush(player4);
        basketballPlayerRepository.saveAndFlush(player5);
    }
}
