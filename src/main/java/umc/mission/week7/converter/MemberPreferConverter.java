package umc.mission.week7.converter;

import umc.mission.week7.domain.entity.FoodCategory;
import umc.mission.week7.domain.mapping.MemberPrefer;
import umc.mission.week7.validation.annotation.ExistCategories;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {

    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList) {
        return foodCategoryList.stream()
                .map(foodCategory ->
                        MemberPrefer.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
