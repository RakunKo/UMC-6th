package umc.mission.week7.apiPayLoad.code.DTO.member.memberMission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.mission.week7.domain.enums.MissionStatus;

import java.time.LocalDateTime;

public class MemberMissionResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateMemberMissionResponseDTO{
        Long id;
        Long memberId;
        Long missionId;
        MissionStatus status;
        LocalDateTime createdAt;
        LocalDateTime updateAt;
    }
}
