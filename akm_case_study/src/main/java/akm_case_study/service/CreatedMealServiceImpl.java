package akm_case_study.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akm_case_study.model.CreatedMeal;
import akm_case_study.repository.CreatedMealRepository;

/*
 * Each Service class implements the corresponding interface for its model.
 */
@Service
public class CreatedMealServiceImpl implements CreatedMealService {

	@Autowired
	CreatedMealRepository createdMealRepository;

	
	@Override
	public CreatedMeal findById(Long id) {
		return createdMealRepository.findById(id).orElseThrow();
	}

	
	@Override
	public CreatedMeal save(CreatedMeal createdMeal) {
		return createdMealRepository.save(createdMeal);
	}

	
	@Override
	public List<CreatedMeal> findAllCreatedMealsById(Long id) {
		return createdMealRepository.findAllCreatedMealForUserById(id);
	}

	
	@Override
	public void delete(Long id) {
		createdMealRepository.deleteById(id);
		
	}

	
	@Override
	public CreatedMeal findFirstRegisteredMeal() {
		try {
			CreatedMeal createdMeal = createdMealRepository.findById((long)1).orElseThrow();
			return createdMeal;
		} catch (NoSuchElementException e) {
			return null;
		}
	}
	
}
