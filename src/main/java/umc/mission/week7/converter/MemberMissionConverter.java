package umc.mission.week7.converter;

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

    public static MemberMission toMemberMission(MemberMissionRequestDTO.CreateMemberMissionRequestDTO request, MemberCommandService memberCommandService, MissionCommandService missionCommandService){
        Member member = memberCommandService.findMemberById(request.getMemberId());
        Mission mission = missionCommandService.findMemberById(request.getMissionId());
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(request.getStatus())
                .build();
    }
}
