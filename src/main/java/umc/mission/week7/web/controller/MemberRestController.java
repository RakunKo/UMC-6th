package umc.mission.week7.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.mission.week7.apiPayLoad.ApiResponse;
import umc.mission.week7.apiPayLoad.code.DTO.member.member.MemberRequestDTO;
import umc.mission.week7.apiPayLoad.code.DTO.member.member.MemberResponseDTO;
import umc.mission.week7.apiPayLoad.code.DTO.member.memberMission.MemberMissionRequestDTO;
import umc.mission.week7.apiPayLoad.code.DTO.member.memberMission.MemberMissionResponseDTO;
import umc.mission.week7.apiPayLoad.code.DTO.mission.MissionRequestDTO;
import umc.mission.week7.apiPayLoad.code.DTO.mission.MissionResponseDTO;
import umc.mission.week7.apiPayLoad.code.DTO.review.ReviewResponseDTO;
import umc.mission.week7.converter.MemberConverter;
import umc.mission.week7.converter.MemberMissionConverter;
import umc.mission.week7.converter.MissionConverter;
import umc.mission.week7.converter.ReviewConverter;
import umc.mission.week7.domain.entity.Member;
import umc.mission.week7.domain.entity.Mission;
import umc.mission.week7.domain.entity.Review;
import umc.mission.week7.domain.mapping.MemberMission;
import umc.mission.week7.service.MemberService.MemberCommand.MemberCommandService;
import umc.mission.week7.service.MemberService.MemberMission.MemberMissionQueryService;
import umc.mission.week7.service.MemberService.MemberMission.MemberMissionService;
import umc.mission.week7.validation.annotation.CheckPage;
import umc.mission.week7.validation.annotation.ExistMember;
import umc.mission.week7.validation.annotation.ExistMission;
import umc.mission.week7.validation.annotation.ExistStore;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberMissionService memberMissionService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/{memberId}/{missionId}")
    public ApiResponse<MemberMissionResponseDTO.CreateMemberMissionResponseDTO> createStore(@RequestBody @Valid MemberMissionRequestDTO.CreateMemberMissionRequestDTO request
    , @ExistMember @PathVariable(name = "memberId") Long memberId
    , @ExistMission @PathVariable(name = "missionId") Long missionId){
        MemberMission memberMission = memberMissionService.createMemberMission(request, memberId, missionId);
        return ApiResponse.onSuccess(MemberMissionConverter.toCreateMemberMissionDTO(memberMission));
    }
}
