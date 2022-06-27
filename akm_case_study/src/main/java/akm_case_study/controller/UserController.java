package akm_case_study.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import akm_case_study.model.CreatedMeal;
import akm_case_study.model.User;
import akm_case_study.repository.CreatedMealRepository;
import akm_case_study.service.CreatedMealService;
import akm_case_study.service.UserService;

/*
 * Following the Model-View-Controller best practice, I created a UserController class
 * here to handle mapping requests from the frontend.
 */
@Controller
public class UserController {

	@Autowired
	UserService userService;

	@Autowired 
	CreatedMealService createdMealService;

	@GetMapping("/plan")
	public String viewCreatedMeals(Model model, Authentication authentication) {
		User user = userService.findByEmail(authentication.getName());
		Long id = user.getId();
		List<CreatedMeal> list = createdMealService.findAllCreatedMealsById(id);
		System.out.println(list);
		model.addAttribute("list", list);
		return "plan";
	}
	
	
    @GetMapping("/plan/update_name/{name}/{id}")
    public String updateName(
            @PathVariable("name") String name,
            @PathVariable("id") long id,
            Authentication authentication) {
    CreatedMeal createdMeal = createdMealService.findById(id);
    createdMeal.setCreatedMealName(name);
    createdMealService.save(createdMeal);
        return "redirect:/plan";
    }
    
    
    @GetMapping("/plan/update_side/{side}/{id}")
    public String updateSide(
            @PathVariable("side") String side,
            @PathVariable("id") long id,
            Authentication authentication) {
    CreatedMeal createdMeal = createdMealService.findById(id);
    createdMeal.setSide(side);
    createdMealService.save(createdMeal);
        return "redirect:/plan";
    }
	
    
    @GetMapping("/plan/update_entree/{entree}/{id}")
    public String updateEntree(
            @PathVariable("entree") String entree,
            @PathVariable("id") long id,
            Authentication authentication) {
    CreatedMeal createdMeal = createdMealService.findById(id);
    createdMeal.setEntree(entree);
    createdMealService.save(createdMeal);
        return "redirect:/plan";
    }
	
    
    @GetMapping("/plan/update_dessert/{dessert}/{id}")
    public String updateDessert(
            @PathVariable("dessert") String dessert,
            @PathVariable("id") long id,
            Authentication authentication) {
    CreatedMeal createdMeal = createdMealService.findById(id);
    createdMeal.setDessert(dessert);
    createdMealService.save(createdMeal);
        return "redirect:/plan";
    }
	
    
	@GetMapping("/plan/delete/{id}")
	public String deleteCreatedMeal(@PathVariable("id") long id, Authentication authentication) {
		createdMealService.delete(id);
		return "redirect:/plan";
	}

	@GetMapping("/about_me")
	public String aboutMe() {
		return "about_me";
	}
	
	@GetMapping("/cheesecake_factory")
	public String cheesecakeFactory() {
		return "cheesecake_factory";
	}
	
	@GetMapping("/olive_garden")
	public String oliveGarden() {
		return "olive_garden";
	}

	@GetMapping("/pf_changs")
	public String pfChangs() {
		return "pf_changs";
	}

}
