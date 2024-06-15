package umc.mission.week7.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.mission.week7.domain.entity.Member;
import umc.mission.week7.domain.entity.Mission;
import umc.mission.week7.domain.entity.Review;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
