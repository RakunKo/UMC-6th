package umc.mission.week7.converter;

import org.springframework.data.domain.Page;
import umc.mission.week7.apiPayLoad.code.DTO.review.ReviewRequestDTO;
import umc.mission.week7.apiPayLoad.code.DTO.review.ReviewResponseDTO;
import umc.mission.week7.domain.entity.Member;
import umc.mission.week7.domain.entity.Review;
import umc.mission.week7.domain.entity.Store;
import umc.mission.week7.service.MemberService.MemberCommand.MemberCommandService;
import umc.mission.week7.service.StoreService.StoreCommandService;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {
    public static ReviewResponseDTO.CreateReviewResultDTO toCreateReviewDTO(Review review){
        return ReviewResponseDTO.CreateReviewResultDTO.builder()
                .id(review.getId())
                .memberId(review.getMember().getId())   //수동지정
                .storeId(review.getStore().getId())    //수동지정
                .title(review.getTitle())
                .score(review.getScore())
                .body(review.getBody())
                .createdAt(review.getCreatedAt())
                .updateAt(review.getUpdatedAt())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.CreateReview request, Member member , Store store){
        return Review.builder()
                .member(member)
                .store(store)
                .body(request.getBody())
                .title(request.getTitle())
                .score(request.getScore())
                .build();
    }

    //review list 만들기
    public static ReviewResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return ReviewResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    //review list response 만들기
    public static ReviewResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<ReviewResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewConverter::reviewPreViewDTO).collect(Collectors.toList());

        return ReviewResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }


}
