package pl.psipko.DentistClinic.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(
        validatedBy = {UniqueUserValidatior.class}
)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface UserUnique {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
