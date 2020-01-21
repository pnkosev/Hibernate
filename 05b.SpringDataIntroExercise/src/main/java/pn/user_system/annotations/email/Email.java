package pn.user_system.annotations.email;

import org.springframework.stereotype.Component;
import pn.user_system.constants.TextConstant;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Component
@Constraint(validatedBy = EmailValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {
    String message() default TextConstant.INVALID_EMAIL_FORMAT;

    int minUsernameLength() default 1;

    int maxUsernameLength() default 50;

    int maxHostNameLength() default 50;

    String regex() default "^([a-zA-Z0-9][-_.]?)*[a-zA-Z0-9]@([a-zA-Z][-]?)*[a-zA-Z](\\\\.([a-zA-Z][-]?)*[a-zA-Z])+$";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
