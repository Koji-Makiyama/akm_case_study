package akm_case_study.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import akm_case_study.model.CreatedMeal;
import akm_case_study.model.CreatedMealForm;
import akm_case_study.model.CreatedMealForm2;
import akm_case_study.model.FoodItem;
import akm_case_study.service.CreatedMealService;
import akm_case_study.service.FoodItemService;
import akm_case_study.service.UserService;


@Controller
public class FoodItemController {

	@Autowired
	FoodItemService foodItemService;
	
	@Autowired
	CreatedMealService createdMealService;
	
	@Autowired
	UserService userService;
	

	@GetMapping("/cheesecake_factory/update/{side}/{entree}/{dessert}/{title}")
	public String sendThatData(
			@PathVariable("side") String side, 
			@PathVariable("entree") String entree, 
			@PathVariable("dessert") String dessert,
			@PathVariable("title") String title,
			Authentication authentication) {
		CreatedMeal createdMeal = new CreatedMeal();
	    createdMeal.setSide(side);
	    createdMeal.setEntree(entree);
	    createdMeal.setDessert(dessert);
		createdMeal.setCreatedMealName(title);
		createdMeal.setDateCreated(LocalDateTime.now());
		System.out.println(authentication.getName());
	    createdMeal.setUser(userService.findByEmail(authentication.getName()));
	    createdMealService.save(createdMeal);
		return "redirect:/cheesecake_factory";
	}
	
	// model attribute, pulls the model data (the JS makes this submit nulls instead of values)
	@PostMapping("/send")
	public String clickToSaveYourMeal(CreatedMealForm2 createdMealForm, @ModelAttribute("createdMealForm") CreatedMeal createdMeal) {
	    CreatedMeal createdMeal2 = new CreatedMeal();
	    createdMeal2.setSide(createdMeal.getSide());
	    createdMeal2.setEntree(createdMeal.getEntree());
	    createdMeal2.setDessert(createdMeal.getDessert());
		createdMeal2.setDateCreated(LocalDateTime.now());
	    createdMeal2.setUser(userService.findByEmail("abc@gmail.com"));
	    createdMealService.save(createdMeal2);
		return "redirect:/cheesecake_factory";
	}
	
	@PostMapping("/cheesecake_factory")
	public String submit_cheesecake(CreatedMealForm createdMealForm) {
		List<FoodItem> list = new ArrayList<>();
		CreatedMeal createdMeal = new CreatedMeal();
		createdMeal.setCollectionId((long) 1);
		createdMeal.setCreatedMealName(createdMealForm.getCreatedMealName());
		createdMeal.setDateCreated(LocalDateTime.now());
		createdMeal.setMealItems(list);
		
		if(createdMealForm.getMealItem1() != null) {
			System.out.println("First if statement is running");
			if(foodItemService.findById(
					Long.parseLong(createdMealForm.getMealItem1())) != null) {                                                     // searches db for item in db, if exists, passes it into the add function
				
				System.out.println("Outprinting right before it queries the DB");
				
				createdMeal.getMealItems().add(foodItemService.findById(Long.parseLong(createdMealForm.getMealItem1()))
						); // triggers 
			} else {
				System.out.println("Second if statement ran (If ran, but food not found)");
			}	
		}
		
        //Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		createdMeal.setUser(userService.findByEmail("abc@gmail.com"));
		System.out.println(createdMeal.toString());
		// at this point you have a created meal with a created meal date, name, list of food items up to 9 items
		// then persist it to the database
		// add an id, getIdByEmail()
		createdMealService.save(createdMeal);
		return "redirect:/cheesecake_factory";
	}
	/*
	}
	if(createdMealForm.getMealItem2() != null) {
		createdMeal.getMealItems().add(createdMealForm.getMealItem2());
	}
	if(createdMealForm.getMealItem3() != null) {
		createdMeal.getMealItems().add(createdMealForm.getMealItem3());
	}
	if(createdMealForm.getMealItem4() != null) {
		createdMeal.getMealItems().add(createdMealForm.getMealItem4());
	}
	if(createdMealForm.getMealItem5() != null) {
		createdMeal.getMealItems().add(createdMealForm.getMealItem5());
	}
	if(createdMealForm.getMealItem6() != null) {
		createdMeal.getMealItems().add(createdMealForm.getMealItem6());
	}
	if(createdMealForm.getMealItem7() != null) {
		createdMeal.getMealItems().add(createdMealForm.getMealItem7());
	}
	if(createdMealForm.getMealItem8() != null) {
		createdMeal.getMealItems().add(createdMealForm.getMealItem8());
	}
	if(createdMealForm.getMealItem9() != null) {
		createdMeal.getMealItems().add(createdMealForm.getMealItem9());
	}
*/
	
	
}
