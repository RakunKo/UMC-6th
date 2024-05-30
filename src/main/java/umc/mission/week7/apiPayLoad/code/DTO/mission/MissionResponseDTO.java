package umc.mission.week7.apiPayLoad.code.DTO.mission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class MissionResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateMissionResponseDTO{
        Long id;
        Long storeId;
        String missionSpec;
        Integer reward;
        LocalDate deadline;
        LocalDateTime updateAt;
        LocalDateTime createdAt;
    }
}
