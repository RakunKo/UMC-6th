package umc.mission.week7.apiPayLoad.code.DTO.review;

import lombok.Getter;

public class ReviewRequestDTO {
    @Getter
    public static class CreateReview {
        Long memberId;
        Long storeId;
        String title;
        Float score;
    }
}
