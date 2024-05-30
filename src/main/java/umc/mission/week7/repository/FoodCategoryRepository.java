package umc.mission.week7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.mission.week7.domain.entity.FoodCategory;
import umc.mission.week7.validation.annotation.ExistCategories;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
