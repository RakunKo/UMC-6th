package umc.mission.week7.service.MemberService.MemberMission;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.mission.week7.apiPayLoad.code.DTO.member.memberMission.MemberMissionResponseDTO;
import umc.mission.week7.domain.entity.Member;
import umc.mission.week7.domain.entity.Mission;
import umc.mission.week7.domain.entity.Review;
import umc.mission.week7.domain.enums.MemberStatus;
import umc.mission.week7.domain.enums.MissionStatus;
import umc.mission.week7.domain.mapping.MemberMission;
import umc.mission.week7.repository.MemberMissionRepository;
import umc.mission.week7.repository.MemberRepository;
import umc.mission.week7.repository.MissionRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService{
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    @Override
    public Page<MemberMission> getMemberMissionList(Long MemberId, Integer page) {

        Member member = memberRepository.findById(MemberId).get();

        Page<MemberMission> processMissions = memberMissionRepository.findAllByMemberAndStatus(
                member,
                MissionStatus.PROCESS,
                PageRequest.of(page, 10)
        );

        return processMissions;
    }
}
