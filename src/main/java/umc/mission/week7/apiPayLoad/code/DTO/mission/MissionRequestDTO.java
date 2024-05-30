package umc.mission.week7.apiPayLoad.code.DTO.mission;

import lombok.Getter;
import umc.mission.week7.validation.annotation.ExistCategories;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class MissionRequestDTO {

    @Getter
    public static class CreateMissionRequestDTO{
        String missionSpec;
        Long storeId;
        LocalDate deadline;
        Integer reward;
    }
}
