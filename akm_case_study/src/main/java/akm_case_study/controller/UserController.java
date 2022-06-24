package akm_case_study.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import akm_case_study.model.CreatedMeal;
import akm_case_study.model.CreatedMealForm;
import akm_case_study.model.CreatedMealForm2;
import akm_case_study.model.Restaurant;
import akm_case_study.repository.CreatedMealRepository;
import akm_case_study.service.CreatedMealService;
import akm_case_study.service.RestaurantService;
import akm_case_study.service.UserService;

/*
 *  This controller ... does XYZ
 */

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired // temporary
	CreatedMealRepository createdMealRepository; // temporary
	
	@Autowired
	RestaurantService restaurantService;
	
	@GetMapping("/plan")
	public String plan() {
		return "plan";
	}
	
	@GetMapping("/about_me")
	public String aboutMe() {
		return "about_me";
	}
	
	// previous TABLE FROM NAME/ITEM1/ITEM2 / ... 12
	/*
	@GetMapping("/cheesecake_factory")
	public String cheesecakeFactory(Model model) {
		CreatedMealForm createdMealForm = new CreatedMealForm();
		model.addAttribute("createdMealForm", createdMealForm);
		
		List<Restaurant> list = restaurantService.getAllRestaurants();
		model.addAttribute("list", list);
		System.out.println(list);
		return "cheesecake_factory";
	}
	*/
	
	// WORK IN PROGRESS FOR PLAN.HTML
	@RequestMapping("/plan")
	public String getCustomMeals(Model model) {
		List<CreatedMeal> createdMeals = createdMealRepository.findAll();
		model.addAttribute("createdMeals", createdMeals);
		System.out.println(createdMeals);
		return "redirect:/plan";
	}
	
	@GetMapping("/cheesecake_factory")
	public String cheesecakeFactory(Model model) {
		CreatedMealForm2 createdMealForm = new CreatedMealForm2();
		model.addAttribute("createdMealForm", createdMealForm);
		
		List<Restaurant> list = restaurantService.getAllRestaurants();
		model.addAttribute("list", list);
		System.out.println(list);
		return "cheesecake_factory";
	}

	//@PostMapping("/add")
	//public String cheesecakeAddItem(Model model) {
	// 
    //}
	
	@GetMapping("/olive_garden")
	public String oliveGarden() {
		return "olive_garden";
	}
	
	@GetMapping("/red_lobster")
	public String redLobster() {
		return "red_lobster";
	}
	
	@GetMapping("/pf_changs")
	public String pfChangs() {
		return "pf_changs";
	}
	
	@GetMapping("/texas_roadhouse")
	public String texasRoadhouse() {
		return "texas_roadhouse";
	}
	
	@GetMapping("/chilis")
	public String chilis() {
		return "chilis";
	}
	
	@GetMapping("/buffalo_wild_wings")
	public String buffaloWildWings() {
		return "buffalo_wild_wings";
	}
	
}
