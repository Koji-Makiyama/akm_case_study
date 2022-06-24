package akm_case_study.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import akm_case_study.model.Restaurant;


public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
