package umc.mission.week7.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.mission.week7.validation.validator.PageCheckValidator;
import umc.mission.week7.validation.validator.StoreExistValidator;

import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PageCheckValidator.class)
@Documented
public @interface CheckPage {

    String message() default "잘못된 page number 입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
