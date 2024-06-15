package umc.mission.week7.apiPayLoad.code.DTO.member.memberMission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.mission.week7.domain.enums.MissionStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberMissionActiveListDTO{
        List<MissionActiveDTO> missionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionActiveDTO{
        String missionSpec;
        Integer reward;
        LocalDate deadline;
        String status;  //mission에서 가져오기
        LocalDateTime createdAt;
    }
}
