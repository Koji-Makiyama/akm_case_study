package akm_case_study.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import akm_case_study.dto.UserRegistrationDto;
import akm_case_study.model.User;


public interface UserService extends UserDetailsService{
	User findByEmail(String email);
	User save(UserRegistrationDto registrationDto);
}
