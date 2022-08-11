package com.example.basketballapp.entity.dtos;

import com.example.basketballapp.entity.enums.BasketballPlayerPosition;

public record CreateBasketballPlayerRequestDTO(String firstName, String lastName, BasketballPlayerPosition position) {
}
