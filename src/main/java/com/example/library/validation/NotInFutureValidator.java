package com.example.library.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.Year;

public class NotInFutureValidator implements ConstraintValidator<NotInFuture, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value <= Year.now().getValue();
    }
}
