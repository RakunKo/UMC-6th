package umc.mission.week7.converter;

import org.springframework.data.domain.Page;
import umc.mission.week7.apiPayLoad.code.DTO.member.memberMission.MemberMissionRequestDTO;
import umc.mission.week7.apiPayLoad.code.DTO.member.memberMission.MemberMissionResponseDTO;
import umc.mission.week7.apiPayLoad.code.DTO.mission.MissionRequestDTO;
import umc.mission.week7.apiPayLoad.code.DTO.mission.MissionResponseDTO;
import umc.mission.week7.domain.entity.Member;
import umc.mission.week7.domain.entity.Mission;
import umc.mission.week7.domain.entity.Store;
import umc.mission.week7.domain.mapping.MemberMission;
import umc.mission.week7.service.MemberService.MemberCommand.MemberCommandService;
import umc.mission.week7.service.MissionService.MissionCommandService;
import umc.mission.week7.service.StoreService.StoreCommandService;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {

    public static MemberMissionResponseDTO.CreateMemberMissionResponseDTO toCreateMemberMissionDTO(MemberMission memberMission){
        return MemberMissionResponseDTO.CreateMemberMissionResponseDTO.builder()
                .id(memberMission.getId())
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .status(memberMission.getStatus())
                .createdAt(memberMission.getCreatedAt())
                .updateAt(memberMission.getUpdatedAt())
                .build();
    }

    public static MemberMission toMemberMission(MemberMissionRequestDTO.CreateMemberMissionRequestDTO request,
                                                Member member,
                                                Mission mission){
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(request.getStatus())
                .build();
    }

    public static MemberMissionResponseDTO.MissionActiveDTO toProcessMission(MemberMission mission){
        return MemberMissionResponseDTO.MissionActiveDTO.builder()
                .missionSpec(mission.getMission().getMissionSpec())
                .createdAt(mission.getCreatedAt())
                .deadline(mission.getMission().getDeadline())
                .reward(mission.getMission().getReward())
                .status(mission.getStatus().toString())
                .build();
    }

    public static MemberMissionResponseDTO.MemberMissionActiveListDTO toProcessMissionList(Page<MemberMission> missionList){

        List<MemberMissionResponseDTO.MissionActiveDTO> processMissionList = missionList.stream()
                .map(MemberMissionConverter::toProcessMission).collect(Collectors.toList());

        return MemberMissionResponseDTO.MemberMissionActiveListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(processMissionList.size())
                .missionList(processMissionList)
                .build();
    }
}
