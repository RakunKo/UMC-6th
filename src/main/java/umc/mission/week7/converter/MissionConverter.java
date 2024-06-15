package umc.mission.week7.converter;

import org.springframework.data.domain.Page;
import umc.mission.week7.apiPayLoad.code.DTO.member.member.MemberResponseDTO;
import umc.mission.week7.apiPayLoad.code.DTO.member.memberMission.MemberMissionResponseDTO;
import umc.mission.week7.apiPayLoad.code.DTO.mission.MissionRequestDTO;
import umc.mission.week7.apiPayLoad.code.DTO.mission.MissionResponseDTO;
import umc.mission.week7.apiPayLoad.code.DTO.review.ReviewResponseDTO;
import umc.mission.week7.domain.entity.Mission;
import umc.mission.week7.domain.entity.Review;
import umc.mission.week7.domain.entity.Store;
import umc.mission.week7.domain.mapping.MemberMission;
import umc.mission.week7.service.StoreService.StoreCommandService;

import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {
    public static MissionResponseDTO.CreateMissionResponseDTO toCreateMissionDTO(Mission mission){
        return MissionResponseDTO.CreateMissionResponseDTO.builder()
                .id(mission.getId())
                .storeId(mission.getStore().getId())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .createdAt(mission.getCreatedAt())
                .updateAt(mission.getUpdatedAt())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.CreateMissionRequestDTO request, StoreCommandService storeCommandService){
        Store store = storeCommandService.findStoreById(request.getStoreId());
        return Mission.builder()
                .deadline(request.getDeadline())
                .reward(request.getReward())
                .missionSpec(request.getMissionSpec())
                .store(store)
                .build();
    }

}
