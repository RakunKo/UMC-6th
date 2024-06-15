package umc.mission.week7.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.mission.week7.apiPayLoad.code.status.ErrorStatus;
import umc.mission.week7.repository.FoodCategoryRepository;
import umc.mission.week7.repository.StoreRepository;
import umc.mission.week7.validation.annotation.ExistCategories;
import umc.mission.week7.validation.annotation.ExistStore;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<ExistStore,Long> {
    private final StoreRepository storeRepository;
    @Override
    public void initialize(ExistStore constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long values, ConstraintValidatorContext context) {
        boolean isValid = storeRepository.existsById(values);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;

    }
}
