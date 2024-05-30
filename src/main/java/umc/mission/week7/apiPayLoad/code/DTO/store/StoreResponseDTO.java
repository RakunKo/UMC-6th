package umc.mission.week7.apiPayLoad.code.DTO.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.mission.week7.domain.entity.Store;

import java.time.LocalDateTime;

public class StoreResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateResultDTO{
        Long id;
        String name;
        String address;
        Float score;
        LocalDateTime updateAt;
        LocalDateTime createdAt;
    }
}
