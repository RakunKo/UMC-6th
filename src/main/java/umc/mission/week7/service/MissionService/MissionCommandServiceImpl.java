package umc.mission.week7.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.mission.week7.apiPayLoad.code.DTO.mission.MissionRequestDTO;
import umc.mission.week7.apiPayLoad.code.status.ErrorStatus;
import umc.mission.week7.apiPayLoad.exception.handler.MIssionHandler;
import umc.mission.week7.converter.MissionConverter;
import umc.mission.week7.domain.entity.Mission;
import umc.mission.week7.repository.MissionRepository;
import umc.mission.week7.service.StoreService.StoreCommandService;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MissionRepository missionRepository;

    private final StoreCommandService storeCommandService;

    @Override
    public Mission createReview(MissionRequestDTO.CreateMissionRequestDTO request) {
        if (request.getMissionSpec().equals("")) {
            throw new MIssionHandler(ErrorStatus.MISSION_SPEC_EMPTY);
        }
        if (request.getReward().equals(0)) {
            throw new MIssionHandler(ErrorStatus.MISSION_REWARD_EMPTY);
        }
        if (request.getDeadline() == null) {
            throw new MIssionHandler(ErrorStatus.MISSION_DEADLINE_EMPTY);
        }

        Mission newMission = MissionConverter.toMission(request,storeCommandService);

        return missionRepository.save(newMission);
    }

    @Override
    public Mission findMemberById(Long missionId) {
        return missionRepository.findById(missionId)
                .orElseThrow(() -> new RuntimeException("Mission not found with id: " + missionId));

    }
}
