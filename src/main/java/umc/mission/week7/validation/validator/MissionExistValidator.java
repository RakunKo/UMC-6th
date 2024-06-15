package umc.mission.week7.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.mission.week7.apiPayLoad.code.status.ErrorStatus;
import umc.mission.week7.repository.MissionRepository;
import umc.mission.week7.repository.StoreRepository;
import umc.mission.week7.validation.annotation.ExistMission;
import umc.mission.week7.validation.annotation.ExistStore;

@Component
@RequiredArgsConstructor
public class MissionExistValidator implements ConstraintValidator<ExistMission,Long> {
    private final MissionRepository missionRepository;
    @Override
    public void initialize(ExistMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long values, ConstraintValidatorContext context) {
        boolean isValid = missionRepository.existsById(values);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;

    }
}
