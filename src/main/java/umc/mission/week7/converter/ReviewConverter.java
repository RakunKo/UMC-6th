package umc.mission.week7.converter;

import umc.mission.week7.apiPayLoad.code.DTO.review.ReviewRequestDTO;
import umc.mission.week7.apiPayLoad.code.DTO.review.ReviewResponseDTO;
import umc.mission.week7.domain.entity.Member;
import umc.mission.week7.domain.entity.Review;
import umc.mission.week7.domain.entity.Store;
import umc.mission.week7.service.MemberService.MemberCommand.MemberCommandService;
import umc.mission.week7.service.StoreService.StoreCommandService;

public class ReviewConverter {
    public static ReviewResponseDTO.CreateReviewResultDTO toCreateReviewDTO(Review review){
        return ReviewResponseDTO.CreateReviewResultDTO.builder()
                .id(review.getId())
                .memberId(review.getMember().getId())   //수동지정
                .storeId(review.getStore().getId())    //수동지정
                .title(review.getTitle())
                .score(review.getScore())
                .createdAt(review.getCreatedAt())
                .updateAt(review.getUpdatedAt())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.CreateReview request, MemberCommandService memberCommandService, StoreCommandService storeCommandService){
        Member member = memberCommandService.findMemberById(request.getMemberId());
        Store store = storeCommandService.findStoreById(request.getStoreId());
        return Review.builder()
                .member(member)
                .store(store)
                .title(request.getTitle())
                .score(request.getScore())
                .build();
    }
}
