package umc.mission.week7.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.mission.week7.apiPayLoad.code.DTO.review.ReviewRequestDTO;
import umc.mission.week7.apiPayLoad.code.status.ErrorStatus;
import umc.mission.week7.apiPayLoad.exception.handler.ReviewHandler;
import umc.mission.week7.converter.ReviewConverter;
import umc.mission.week7.domain.entity.Member;
import umc.mission.week7.domain.entity.Mission;
import umc.mission.week7.domain.entity.Review;
import umc.mission.week7.domain.entity.Store;
import umc.mission.week7.repository.MemberRepository;
import umc.mission.week7.repository.ReviewRepository;
import umc.mission.week7.repository.StoreRepository;
import umc.mission.week7.service.MemberService.MemberCommand.MemberCommandService;
import umc.mission.week7.service.StoreService.StoreCommandService;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;


    @Override
    public Review createReview(ReviewRequestDTO.CreateReview request, Long memberId, Long storeId) {
        Member member = memberRepository.findById(memberId).get();
        Store store = storeRepository.findById(storeId).get();
        Review newReview = ReviewConverter.toReview(request, member, store);
        if (request.getTitle().equals("")) {
            throw new ReviewHandler(ErrorStatus.REVIEW_TITLE_EMPTY);
        }
        if (request.getScore().equals("")) {
            throw new ReviewHandler(ErrorStatus.REVIEW_SCORE_EMPTY);
        }
        return reviewRepository.save(newReview);
    }
}
