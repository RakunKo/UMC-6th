package umc.mission.week7.service.ReviewService;

import org.springframework.data.domain.Page;
import umc.mission.week7.domain.entity.Review;
import umc.mission.week7.domain.entity.Store;

import java.util.Optional;

public interface ReviewQueryService {
    Optional<Store> findStore(Long id);

    Page<Review> getReviewList(Long StoreId, Integer page);

    Page<Review> getReviewListByUser(Long MemberId, Integer page);
}
