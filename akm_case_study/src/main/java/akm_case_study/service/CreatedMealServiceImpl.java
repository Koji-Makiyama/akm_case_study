package akm_case_study.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akm_case_study.model.CreatedMeal;
import akm_case_study.model.FoodItem;
import akm_case_study.repository.CreatedMealRepository;


@Service
public class CreatedMealServiceImpl implements CreatedMealService {

	@Autowired
	CreatedMealRepository createdMealRepository;

	@Override
	public FoodItem findById(Long id) {
		createdMealRepository.findById(id);
		return null;
	}

	@Override
	public CreatedMeal save(CreatedMeal createdMeal) {
		return createdMealRepository.save(createdMeal);
	}
	
}
