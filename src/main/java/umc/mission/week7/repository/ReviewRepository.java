package umc.mission.week7.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.mission.week7.domain.entity.Member;
import umc.mission.week7.domain.entity.Review;
import umc.mission.week7.domain.entity.Store;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
    Page<Review> findAllByMember(Member member, PageRequest pageRequest);
}
