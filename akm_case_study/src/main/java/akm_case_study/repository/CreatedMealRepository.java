package akm_case_study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import akm_case_study.model.CreatedMeal;


@Repository
public interface CreatedMealRepository extends JpaRepository<CreatedMeal, Long> {

}
