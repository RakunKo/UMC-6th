package umc.mission.week7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.mission.week7.domain.entity.FoodCategory;
import umc.mission.week7.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
}
