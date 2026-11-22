package es.etg.daw.dawes.huellas.animal.infraestructure.web.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NombreAnimalValidator implements ConstraintValidator<NombreAnimal, String> {

    public static final String PATRON = "^[\\p{L} ]+$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank())
            return true; 
        return value.trim().matches(PATRON);
    }
}