package umc.mission.week7.service.MemberService.MemberMission;

import org.springframework.data.domain.Page;
import umc.mission.week7.domain.mapping.MemberMission;

public interface MemberMissionQueryService {
    Page<MemberMission> getMemberMissionList(Long MemberId, Integer page);
}
