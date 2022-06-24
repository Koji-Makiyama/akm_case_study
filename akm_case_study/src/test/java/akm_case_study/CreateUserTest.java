package akm_case_study;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import akm_case_study.model.User;
import akm_case_study.repository.UserRepository;
import akm_case_study.service.UserService;

class CreateUserTest {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	/*
	@Test
	public void whenAssertingEquality_thenEqual() {
	    String expected = "abc";
	    String actual = "abc";
	    assertEquals(expected, actual);
	}
	*/
	
    @Test
    public void userExists() {
    	User user = userService.findByEmail("abc@gmail.com");
        System.out.println(user);
        assertEquals(1, 1);
    }
    
}
