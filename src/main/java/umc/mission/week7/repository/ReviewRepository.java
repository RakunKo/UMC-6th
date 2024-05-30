package umc.mission.week7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.mission.week7.domain.entity.Review;
import umc.mission.week7.domain.entity.Store;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
