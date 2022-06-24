package akm_case_study.service;

import java.util.List;

import org.springframework.stereotype.Service;

import akm_case_study.model.Restaurant;


public interface RestaurantService {

	List<Restaurant> getAllRestaurants();
	
}
