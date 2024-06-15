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
import umc.mission.week7.apiPayLoad.code.DTO.member.memberMission.MemberMissionResponseDTO;
import umc.mission.week7.apiPayLoad.code.DTO.mission.MissionRequestDTO;
import umc.mission.week7.apiPayLoad.code.DTO.mission.MissionResponseDTO;
import umc.mission.week7.apiPayLoad.code.DTO.review.ReviewRequestDTO;
import umc.mission.week7.apiPayLoad.code.DTO.review.ReviewResponseDTO;
import umc.mission.week7.converter.MemberMissionConverter;
import umc.mission.week7.converter.MissionConverter;
import umc.mission.week7.converter.ReviewConverter;
import umc.mission.week7.domain.entity.Mission;
import umc.mission.week7.domain.entity.Review;
import umc.mission.week7.domain.mapping.MemberMission;
import umc.mission.week7.service.MemberService.MemberMission.MemberMissionQueryService;
import umc.mission.week7.service.MissionService.MissionCommandService;
import umc.mission.week7.service.ReviewService.ReviewCommandService;
import umc.mission.week7.validation.annotation.CheckPage;
import umc.mission.week7.validation.annotation.ExistMember;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionRestController {
    private final MissionCommandService missionCommandService;
    private final MemberMissionQueryService memberMissionQueryService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.CreateMissionResponseDTO> createStore(@RequestBody @Valid MissionRequestDTO.CreateMissionRequestDTO request){
        Mission mission = missionCommandService.createReview(request);
        return ApiResponse.onSuccess(MissionConverter.toCreateMissionDTO(mission));
    }

    @GetMapping("process/{memberId}/")
    @Operation(summary = "진행중인 미션 목록 조회 API",description = "진행중인 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "유저 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 1번이 1 페이지 입니다."),
    })
    public ApiResponse<MemberMissionResponseDTO.MemberMissionActiveListDTO> getProcessMissionList(@ExistMember @PathVariable(name = "memberId") Long memberId, @CheckPage @RequestParam(name = "page") Integer page){
        if (page >=1) page -= 1;

        Page<MemberMission> missionPage = memberMissionQueryService.getMemberMissionList(memberId, page);
        return ApiResponse.onSuccess(MemberMissionConverter.toProcessMissionList(missionPage));

    }

}
