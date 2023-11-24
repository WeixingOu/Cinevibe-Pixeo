package com.cinevibe.validators.Impls;

import com.cinevibe.validators.Birthdate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class BirthdateValidatorImpl implements ConstraintValidator<Birthdate, LocalDate> {
    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        if (value.isBefore(LocalDate.of(1900, 1, 1))) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("must be realistic")
                    .addConstraintViolation();
            return false;
        }

        if (value.plusYears(18).isAfter(LocalDate.now())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("must be at least 18 years old")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
