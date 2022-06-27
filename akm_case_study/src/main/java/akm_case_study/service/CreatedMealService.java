package akm_case_study.service;

import java.util.List;
import akm_case_study.model.CreatedMeal;

/*
 * Each Service interface is implemented by its own Service class
 */
public interface CreatedMealService {
	CreatedMeal findById(Long id);
	List<CreatedMeal> findAllCreatedMealsById(Long id);
	CreatedMeal findFirstRegisteredMeal();
	CreatedMeal save(CreatedMeal createdMeal);
	void delete(Long id);

}
