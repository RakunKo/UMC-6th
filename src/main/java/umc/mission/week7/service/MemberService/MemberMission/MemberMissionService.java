package umc.mission.week7.service.MemberService.MemberMission;

import umc.mission.week7.apiPayLoad.code.DTO.member.memberMission.MemberMissionRequestDTO;
import umc.mission.week7.domain.mapping.MemberMission;

public interface MemberMissionService {
    public MemberMission createMemberMission(MemberMissionRequestDTO.CreateMemberMissionRequestDTO request);

}
