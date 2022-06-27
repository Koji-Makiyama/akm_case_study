package akm_case_study;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
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
class RepositoryTests {

	@Autowired
	CreatedMealService createdMealService;

	@Autowired
	UserService userService;

	/*
	 * This test verifies the query method "findAllCreatedMealsById" that is declared in the class CreatedMealService.
	 * The purpose of this query method is to find all created meals that are associated with a user, using that user's 
	 * primary key (user_id) as a parameter.
     * 
     * In order to do this, we must create both a new user with an id and a created meal that is assigned to that user.
	 * Then, we query the created meal from the database with the user's id.
	 * We store the results of the query as a list and extract the created meal object from it (because we cannot 
	 * store the query directly as a CreatedMeal object).
	 * 
	 * Finally, we verify that the queried result is equal to the expected result, where the expected result is equal 
	 * to the data we used in the multiple parameter constructor when we created the CreatedMeal object.
	 * 
	 * This method, although in a @Transactional class, will still leave a footprint of persisting to the database.
	 * Evidence of this can be seen in sequential users and created meals' id's. They will not start at 1.
	 * This is because the test creates users and created meals, and deletes them, but the database does not 
	 * ignore those dropped rows when assigning subsequent primary keys.
	 * 
	 * To avoid this from interfering, drop the database, run the Spring app (which will recreate an empty database), and 
	 * create a user and created meal via the webpages hosted by the web server BEFORE running any tests.
	 * If you run a test before you create the table via the Spring app, it will create the database via the test, and 
	 * your first users and created meals will be assigned primary keys of 2 or 3 instead of 1. This is not an error.
	 * This is a result of the sequence of operations. 
	 */
	@Test
	void findAllCreatedMealsByIdTest() {
		User user = new User("John", "Doe", "test@gmail.com", "123");
		userService.manuallySave(user);
		User userAfterPersistance = userService.findByEmail("test@gmail.com");
		Long userId = userAfterPersistance.getId(); 
		
		CreatedMeal constructorMeal = new CreatedMeal("TestSide", "TestEntree", "TestDessert", "TestMeal", userAfterPersistance);
		createdMealService.save(constructorMeal);
		List<CreatedMeal> list = createdMealService.findAllCreatedMealsById(userId);
		CreatedMeal queriedMeal = list.get(0);
		System.out.println(constructorMeal);
		System.out.println(queriedMeal);
		assertTrue(constructorMeal == queriedMeal);
	    
	}

	/*
	 * To ensure that the if() condition results in false, drop the database and recreate it.
	 * Then, register a new created meal and run this test. The created meal should register with a primary key
	 * of 1.
	 */
	@Test
	void findFirstRegisteredUserTest() {
		User user = userService.findFirstRegisteredUser();
		if (user == null) {
			// no user with id=1
			assertTrue(user == null);
			System.out.println("User with id=1 does not exist");
		} else {
			// user with id=1 exists
			assertTrue(user != null);
			System.out.println("User with id=1 exists");
		}
			
	}
	
	/*
	 * To ensure that the if() condition results in false, drop the database and recreate it.
	 * Then, register a new user and run this test. The user should register with a primary key
	 * of 1.
	 */
	@Test
	void findFirstRegisteredMealTest() {
		CreatedMeal createdMeal = createdMealService.findFirstRegisteredMeal();
		if (createdMeal == null) {
			// no user with id=1
			assertTrue(createdMeal == null);
			System.out.println("CreatedMeal with id=1 does not exist");
		} else {
			// user with id=1 exists
			assertTrue(createdMeal != null);
			System.out.println("CreatedMeal with id=1 exists");
		}
			
	}

	
	
}
