package umc.mission.week7.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.mission.week7.domain.entity.Member;
import umc.mission.week7.domain.entity.Review;
import umc.mission.week7.domain.entity.Store;
import umc.mission.week7.repository.MemberRepository;
import umc.mission.week7.repository.ReviewRepository;
import umc.mission.week7.repository.StoreRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService{

    private final StoreRepository storeRepository;

    private final ReviewRepository reviewRepository;

    private final MemberRepository memberRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {

        Store store = storeRepository.findById(StoreId).get();

        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }

    @Override
    public Page<Review> getReviewListByUser(Long MemberId, Integer page) {
        Member member = memberRepository.findById(MemberId).get();

        Page<Review> UserPage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
        return UserPage;
    }
}
