package umc.mission.week7.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.mission.week7.domain.common.DateBaseEntity;
import umc.mission.week7.domain.entity.FoodCategory;
import umc.mission.week7.domain.entity.Member;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPrefer extends DateBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private FoodCategory foodCategory;
}
