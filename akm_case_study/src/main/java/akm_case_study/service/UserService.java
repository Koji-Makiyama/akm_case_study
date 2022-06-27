package akm_case_study.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import akm_case_study.dto.UserRegistrationDto;
import akm_case_study.model.User;

/*
 * Each Service interface is implemented by its own Service class
 */
public interface UserService extends UserDetailsService{
	User findByEmail(String email);
	User findById(long id);
	User save(UserRegistrationDto registrationDto);
	User manuallySave(User user);
	User findFirstRegisteredUser();
}
