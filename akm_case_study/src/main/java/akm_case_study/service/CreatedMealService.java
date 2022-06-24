package akm_case_study.service;

import akm_case_study.model.CreatedMeal;
import akm_case_study.model.FoodItem;

public interface CreatedMealService {
	FoodItem findById(Long id);
	CreatedMeal save(CreatedMeal createdMeal);
}
