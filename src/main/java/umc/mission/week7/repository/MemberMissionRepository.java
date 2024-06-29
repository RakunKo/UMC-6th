package umc.mission.week7.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.mission.week7.domain.entity.FoodCategory;
import umc.mission.week7.domain.entity.Member;
import umc.mission.week7.domain.entity.Mission;
import umc.mission.week7.domain.entity.Review;
import umc.mission.week7.domain.enums.MemberStatus;
import umc.mission.week7.domain.enums.MissionStatus;
import umc.mission.week7.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    Page<MemberMission> findAllByMemberAndStatus(Member member, MissionStatus status, PageRequest pageRequest);
}
