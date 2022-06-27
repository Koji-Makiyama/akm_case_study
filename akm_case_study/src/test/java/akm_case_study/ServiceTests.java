package akm_case_study;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import akm_case_study.model.CreatedMeal;
import akm_case_study.model.User;
import akm_case_study.service.CreatedMealService;
import akm_case_study.service.UserService;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AkmCaseStudyApplication.class)
class ServiceTests {

	@Autowired
	UserService userService;
	
	@Autowired
	CreatedMealService createdMealService;
	
	/*
	 * This is an example of a User test using the JpaRepository method findById().
	 */
	@ParameterizedTest
	@ValueSource(ints = {2, 1})
	void findUserByIdTest(int id) {
		User user = userService.findById((long) id);
		System.out.println(user);
		assertTrue(user != null);
	}
	
	/*
	 * This is an example of a Created Meal test using the JpaRepository method findById().
	 */
	@ParameterizedTest
	@ValueSource(ints = {2, 1})
	void findByIdTest(int id) {
		CreatedMeal createdMeal = createdMealService.findById((long) id);
		System.out.println(createdMeal);
		assertTrue(createdMeal != null);
	}
	
	
	/*
	 *  This is an example of another User test using the JpaRepository method findByEmail().
	 */
    @Test
    void confirmUserLength() {
        User user = userService.findByEmail("abc@gmail.com");
        System.out.println(user.toString());
        String fullName = user.getFirstName() + " " + user.getLastName();
        System.out.println(fullName);
        assertEquals(fullName, "a b");
    }
    
}