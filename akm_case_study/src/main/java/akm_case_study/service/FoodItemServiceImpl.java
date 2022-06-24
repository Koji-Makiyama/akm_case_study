package akm_case_study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akm_case_study.model.FoodItem;
import akm_case_study.repository.FoodItemRepository;



@Service
public class FoodItemServiceImpl implements FoodItemService {

	@Autowired
	FoodItemRepository foodItemRepository;

	@Override
	public void save(FoodItem foodItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FoodItem findById(long id) {
		return foodItemRepository.findById(id).orElseThrow();
	}
	
}
