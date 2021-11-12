package com.stackinsat.test.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.lang.annotation.ElementType.*;

@Constraint(validatedBy = BirthDateValidator.class)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BirthDate {
    String message();
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};
}
