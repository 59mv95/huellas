package es.etg.daw.dawes.huellas.animal.infraestructure.web.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.RECORD_COMPONENT })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NombreAnimalValidator.class)
@Documented
public @interface NombreAnimal {
    String message() default "{animal.valid.nombre.formato}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}