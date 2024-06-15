package umc.mission.week7.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.mission.week7.apiPayLoad.code.status.ErrorStatus;
import umc.mission.week7.repository.StoreRepository;
import umc.mission.week7.validation.annotation.CheckPage;
import umc.mission.week7.validation.annotation.ExistStore;

@Component
@RequiredArgsConstructor
public class PageCheckValidator implements ConstraintValidator<CheckPage,Integer> {
    private final StoreRepository storeRepository;
    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer values, ConstraintValidatorContext context) {
        if (values == null || values <= 0) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.CHECK_PAGE_ERROR.toString()).addConstraintViolation();
            return false;
        }

        return true;

    }
}
