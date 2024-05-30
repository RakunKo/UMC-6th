package umc.mission.week7.apiPayLoad.code.DTO.member.memberMission;

import lombok.Getter;
import umc.mission.week7.domain.enums.MissionStatus;
import umc.mission.week7.validation.annotation.ExistCategories;

import java.util.List;

public class MemberMissionRequestDTO {
    @Getter
    public static class CreateMemberMissionRequestDTO{
        Long memberId;
        Long missionId;
        MissionStatus status;
    }
}
