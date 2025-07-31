package com.example.library.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NotInFutureValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotInFuture {
    String message() default "Value must not be in the future";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

