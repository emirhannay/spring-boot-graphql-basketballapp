package com.example.basketballapp.validator;

public interface BaseValidator {
    void doesStringContainsSpaces(String input,String inputName);
    void isTheStringNullOrEmpty(String input,String inputName);
    void isZeroOrLessThanZero(Long input, String inputName);

}
