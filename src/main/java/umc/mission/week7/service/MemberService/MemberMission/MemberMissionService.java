package umc.mission.week7.service.MemberService.MemberMission;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umc.mission.week7.apiPayLoad.code.DTO.member.memberMission.MemberMissionRequestDTO;
import umc.mission.week7.domain.entity.Member;
import umc.mission.week7.domain.mapping.MemberMission;

public interface MemberMissionService {
    public MemberMission createMemberMission(MemberMissionRequestDTO.CreateMemberMissionRequestDTO request,
                                             Long memberId,
                                             Long missionId);
}
