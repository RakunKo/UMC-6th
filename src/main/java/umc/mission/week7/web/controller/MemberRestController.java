package umc.mission.week7.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.mission.week7.apiPayLoad.ApiResponse;
import umc.mission.week7.apiPayLoad.code.DTO.member.member.MemberRequestDTO;
import umc.mission.week7.apiPayLoad.code.DTO.member.member.MemberResponseDTO;
import umc.mission.week7.apiPayLoad.code.DTO.member.memberMission.MemberMissionRequestDTO;
import umc.mission.week7.apiPayLoad.code.DTO.member.memberMission.MemberMissionResponseDTO;
import umc.mission.week7.apiPayLoad.code.DTO.mission.MissionRequestDTO;
import umc.mission.week7.apiPayLoad.code.DTO.mission.MissionResponseDTO;
import umc.mission.week7.converter.MemberConverter;
import umc.mission.week7.converter.MemberMissionConverter;
import umc.mission.week7.converter.MissionConverter;
import umc.mission.week7.domain.entity.Member;
import umc.mission.week7.domain.entity.Mission;
import umc.mission.week7.domain.mapping.MemberMission;
import umc.mission.week7.service.MemberService.MemberCommand.MemberCommandService;
import umc.mission.week7.service.MemberService.MemberMission.MemberMissionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberMissionService memberMissionService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/mission")
    public ApiResponse<MemberMissionResponseDTO.CreateMemberMissionResponseDTO> createStore(@RequestBody @Valid MemberMissionRequestDTO.CreateMemberMissionRequestDTO request){
        MemberMission memberMission = memberMissionService.createMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toCreateMemberMissionDTO(memberMission));
    }
}
