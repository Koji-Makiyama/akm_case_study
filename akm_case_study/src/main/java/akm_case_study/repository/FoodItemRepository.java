package akm_case_study.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import akm_case_study.model.FoodItem;


public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
}
