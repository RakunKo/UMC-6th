package umc.mission.week7.service.MemberService.MemberCommand;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.mission.week7.apiPayLoad.code.DTO.member.member.MemberRequestDTO;
import umc.mission.week7.apiPayLoad.code.status.ErrorStatus;
import umc.mission.week7.apiPayLoad.exception.handler.FoodCategoryHandler;
import umc.mission.week7.converter.MemberConverter;
import umc.mission.week7.converter.MemberPreferConverter;
import umc.mission.week7.domain.entity.FoodCategory;
import umc.mission.week7.domain.entity.Member;
import umc.mission.week7.domain.mapping.MemberPrefer;
import umc.mission.week7.repository.FoodCategoryRepository;
import umc.mission.week7.repository.MemberRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }

    public Member findMemberById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + memberId));
    }
}