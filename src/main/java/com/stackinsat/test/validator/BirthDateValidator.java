package com.stackinsat.test.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class BirthDateValidator implements ConstraintValidator<BirthDate, LocalDate> {

    @Override
    public boolean isValid(LocalDate valueToValidate,
                           ConstraintValidatorContext constraintValidatorContext) {
        Integer nbYears = Period.between(valueToValidate,
                                         LocalDate.now()).getYears();
        return nbYears <= 150;
    }
}
