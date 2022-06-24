package akm_case_study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akm_case_study.model.Restaurant;
import akm_case_study.repository.RestaurantRepository;



@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantRepository restaurantRepository;
	
	public List<Restaurant> getAllRestaurants() {
		return restaurantRepository.findAll();
	}
	
}
