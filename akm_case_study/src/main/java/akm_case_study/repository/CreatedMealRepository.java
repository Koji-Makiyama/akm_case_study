package akm_case_study.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import akm_case_study.model.CreatedMeal;


@Repository
public interface CreatedMealRepository extends JpaRepository<CreatedMeal, Long> {

	
	 // ?1 refers to the first parameter, i.e. the parameter passed in as a long for 'id'
    @Query(value = "SELECT * FROM created_meal WHERE created_meal.user_id = ?1", 
	       nativeQuery = true)
	    List<CreatedMeal> findAllCreatedMealForUserById(long id);
	 
	 
    @Query(value = "SELECT * FROM user WHERE custom_meal.created_meal_id = '1'", 
	       nativeQuery = true)
	    List<CreatedMeal> findFirstRegisteredMeal();
	 
}
