package umc.mission.week7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.mission.week7.domain.entity.Member;
import umc.mission.week7.domain.entity.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
