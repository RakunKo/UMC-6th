package umc.mission.week7.service.MemberService.MemberCommand;

import umc.mission.week7.apiPayLoad.code.DTO.member.member.MemberRequestDTO;
import umc.mission.week7.domain.entity.Member;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);

    Member findMemberById(Long memberId);
}
