package umc.mission.week7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.mission.week7.domain.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
