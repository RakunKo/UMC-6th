package umc.mission.week7.service.MemberService.MemberMission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.mission.week7.apiPayLoad.code.DTO.member.memberMission.MemberMissionRequestDTO;
import umc.mission.week7.apiPayLoad.code.DTO.review.ReviewRequestDTO;
import umc.mission.week7.apiPayLoad.code.status.ErrorStatus;
import umc.mission.week7.apiPayLoad.exception.handler.MIssionHandler;
import umc.mission.week7.apiPayLoad.exception.handler.ReviewHandler;
import umc.mission.week7.converter.MemberMissionConverter;
import umc.mission.week7.converter.MissionConverter;
import umc.mission.week7.converter.ReviewConverter;
import umc.mission.week7.domain.entity.Mission;
import umc.mission.week7.domain.entity.Review;
import umc.mission.week7.domain.enums.MissionStatus;
import umc.mission.week7.domain.mapping.MemberMission;
import umc.mission.week7.repository.MemberMissionRepository;
import umc.mission.week7.repository.ReviewRepository;
import umc.mission.week7.service.MemberService.MemberCommand.MemberCommandService;
import umc.mission.week7.service.MissionService.MissionCommandService;
import umc.mission.week7.service.StoreService.StoreCommandService;
@Service
@RequiredArgsConstructor
public class MemberMissionServiceImpl implements MemberMissionService{
    private final MemberMissionRepository memberMissionRepository;
    private final MemberCommandService memberCommandService;
    private final MissionCommandService missionCommandService;

    @Override
    public MemberMission createMemberMission(MemberMissionRequestDTO.CreateMemberMissionRequestDTO request) {
        if (request.getStatus() != MissionStatus.FAIL &&
                request.getStatus() !=MissionStatus.COMPLETE &&
                request.getStatus() !=MissionStatus.PROCESS &&
                request.getStatus() !=MissionStatus.READY &&
                request.getStatus() !=MissionStatus.DEFAULT) {
            throw new MIssionHandler(ErrorStatus.MEMBER_MISSION_STATUS_ERROR);
        }
        MemberMission newMemberMission = MemberMissionConverter.toMemberMission(request,memberCommandService, missionCommandService);

        return memberMissionRepository.save(newMemberMission);
    }
}
