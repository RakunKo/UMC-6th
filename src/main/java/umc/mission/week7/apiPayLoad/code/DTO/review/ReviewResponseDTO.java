package umc.mission.week7.apiPayLoad.code.DTO.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class ReviewResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateReviewResultDTO{
        Long id;
        String title;
        Float score;
        Long memberId;
        Long storeId;
        LocalDateTime updateAt;
        LocalDateTime createdAt;
    }
}
