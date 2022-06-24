package akm_case_study.service;

import akm_case_study.model.FoodItem;

public interface FoodItemService {
	void save(FoodItem foodItem);
	FoodItem findById(long id);

}
