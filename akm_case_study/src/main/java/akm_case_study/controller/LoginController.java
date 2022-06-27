package akm_case_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import akm_case_study.service.UserService;

/*
 * Following the Model-View-Controller best practice, I created a LoginController class
 * here to handle mapping requests from the frontend.
 */
@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/login")
	public String login() {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); // this location is where spring stores your user object that just logged in
		if (principal instanceof UserDetails) {
			return "redirect:/"; 
		}
		
		return "login";
	}

}
