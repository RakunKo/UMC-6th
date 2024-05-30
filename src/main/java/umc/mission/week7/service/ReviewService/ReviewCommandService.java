package umc.mission.week7.service.ReviewService;

import umc.mission.week7.apiPayLoad.code.DTO.review.ReviewRequestDTO;
import umc.mission.week7.apiPayLoad.code.DTO.store.StoreRequestDTO;
import umc.mission.week7.domain.entity.Review;
import umc.mission.week7.domain.entity.Store;

public interface ReviewCommandService {
    public Review createReview(ReviewRequestDTO.CreateReview request);
}
