package akm_case_study.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import akm_case_study.model.CreatedMeal;
import akm_case_study.service.CreatedMealService;
import akm_case_study.service.UserService;

/*
 * Following the Model-View-Controller best practice, I created a CreatedMealController class
 * here to handle mapping requests from the frontend.
 */
@Controller
public class CreatedMealController {

	@Autowired
	CreatedMealService createdMealService;
	
	@Autowired
	UserService userService;
	

	@GetMapping("/cheesecake_factory/save/{side}/{entree}/{dessert}/{title}")
	public String sendCheesecakeFactoryCreatedMeal(
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
	
	@GetMapping("/olive_garden/save/{side}/{entree}/{dessert}/{title}")
	public String sendOliveGardenCreatedMeal(
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
		return "redirect:/olive_garden";
	}
	
	@GetMapping("/pf_changs/save/{side}/{entree}/{dessert}/{title}")
	public String sendPFChangsCreatedMeal(
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
		return "redirect:/pf_changs";
	}
	
}
