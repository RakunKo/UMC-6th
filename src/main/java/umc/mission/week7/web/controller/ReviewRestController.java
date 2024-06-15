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
import umc.mission.week7.apiPayLoad.code.DTO.review.ReviewRequestDTO;
import umc.mission.week7.apiPayLoad.code.DTO.review.ReviewResponseDTO;
import umc.mission.week7.converter.ReviewConverter;
import umc.mission.week7.domain.entity.Review;
import umc.mission.week7.service.ReviewService.ReviewCommandService;
import umc.mission.week7.service.ReviewService.ReviewQueryService;
import umc.mission.week7.validation.annotation.*;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;

    @PostMapping("/{memberId}/{storeId}")
    public ApiResponse<ReviewResponseDTO.CreateReviewResultDTO> createStore(@RequestBody @Valid ReviewRequestDTO.CreateReview request
            , @ExistMember @PathVariable(name = "memberId") Long memberId
            , @ExistStore @PathVariable(name = "storeId") Long storeId){
        Review review = reviewCommandService.createReview(request, memberId, storeId);
        return ApiResponse.onSuccess(ReviewConverter.toCreateReviewDTO(review));

    }

    @GetMapping("store/{storeId}")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 1번이 1 페이지 입니다."),
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistStore @PathVariable(name = "storeId") Long storeId,
                                                                             @CheckPage @RequestParam(name = "page") Integer page){
        if (page >=1) page -= 1;
        Page<Review> reviewPage = reviewQueryService.getReviewList(storeId,page);
        return ApiResponse.onSuccess(ReviewConverter.reviewPreViewListDTO(reviewPage));
    }

    @GetMapping("member/{memberId}")
    @Operation(summary = "작성한 리뷰 목록 조회 API",description = "자신이 작성한 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
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
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getReviewListByUser(@ExistMember @PathVariable(name = "memberId") Long memberId, @CheckPage @RequestParam(name = "page") Integer page){
        if (page >=1) page -= 1;
        Page<Review> reviewPage = reviewQueryService.getReviewListByUser(memberId,page);
        return ApiResponse.onSuccess(ReviewConverter.reviewPreViewListDTO(reviewPage));
    }
}
