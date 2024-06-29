package umc.mission.week7.service.MemberService.MemberMission;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.mission.week7.apiPayLoad.code.DTO.member.memberMission.MemberMissionRequestDTO;
import umc.mission.week7.apiPayLoad.code.DTO.review.ReviewRequestDTO;
import umc.mission.week7.apiPayLoad.code.status.ErrorStatus;
import umc.mission.week7.apiPayLoad.exception.handler.MIssionHandler;
import umc.mission.week7.apiPayLoad.exception.handler.ReviewHandler;
import umc.mission.week7.converter.MemberMissionConverter;
import umc.mission.week7.converter.MissionConverter;
import umc.mission.week7.converter.ReviewConverter;
import umc.mission.week7.domain.entity.Member;
import umc.mission.week7.domain.entity.Mission;
import umc.mission.week7.domain.entity.Review;
import umc.mission.week7.domain.entity.Store;
import umc.mission.week7.domain.enums.MissionStatus;
import umc.mission.week7.domain.mapping.MemberMission;
import umc.mission.week7.repository.*;
import umc.mission.week7.service.MemberService.MemberCommand.MemberCommandService;
import umc.mission.week7.service.MissionService.MissionCommandService;
import umc.mission.week7.service.StoreService.StoreCommandService;
@Service
@RequiredArgsConstructor
public class MemberMissionServiceImpl implements MemberMissionService{
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    public MemberMission createMemberMission(MemberMissionRequestDTO.CreateMemberMissionRequestDTO request, Long memberId, Long missionId) {
        Member member = memberRepository.findById(memberId).get();
        Mission mission = missionRepository.findById(missionId).get();

        if (request.getStatus() != MissionStatus.FAIL &&
                request.getStatus() !=MissionStatus.COMPLETE &&
                request.getStatus() !=MissionStatus.PROCESS &&
                request.getStatus() !=MissionStatus.READY &&
                request.getStatus() !=MissionStatus.DEFAULT) {
            throw new MIssionHandler(ErrorStatus.MEMBER_MISSION_STATUS_ERROR);
        }
        MemberMission newMemberMission = MemberMissionConverter.toMemberMission(request,member, mission);

        return memberMissionRepository.save(newMemberMission);
    }
}
