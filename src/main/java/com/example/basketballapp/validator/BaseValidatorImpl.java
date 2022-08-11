package com.example.basketballapp.validator;

import com.example.basketballapp.exception.ValidationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class BaseValidatorImpl implements BaseValidator{
    @Override
    public void doesStringContainsSpaces(String input, String inputName) {
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(input);
        boolean found = matcher.find();
        if(found == true){
            throw new ValidationException("The "+inputName+" cannot contain spaces.");
        }
    }

    @Override
    public void isTheStringNullOrEmpty(String input, String inputName) {
        if(input.isEmpty() == true){

            throw new ValidationException(inputName+" can not be null or empty");
        }
    }

    @Override
    public void isZeroOrLessThanZero(Long input, String inputName) {
        if(input == 0 || input < 0){
            throw new ValidationException(inputName+" must be greater than 0");
        }

    }


}
