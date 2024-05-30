package umc.mission.week7.service.MissionService;

import umc.mission.week7.apiPayLoad.code.DTO.mission.MissionRequestDTO;
import umc.mission.week7.apiPayLoad.code.DTO.review.ReviewRequestDTO;
import umc.mission.week7.domain.entity.Member;
import umc.mission.week7.domain.entity.Mission;
import umc.mission.week7.domain.entity.Review;

public interface MissionCommandService {
    public Mission createReview(MissionRequestDTO.CreateMissionRequestDTO request);

    Mission findMemberById(Long missionId);
}
