package akm_case_study.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import akm_case_study.dto.UserRegistrationDto;
import akm_case_study.model.Role;
import akm_case_study.model.User;
import akm_case_study.repository.UserRepository;

/*
 * Each Service class implements the corresponding interface for its model.
 */
@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@Override
	   public User findByEmail(String email){
	       return userRepository.findByEmail(email);
	}

	@Override
	public User manuallySave(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstName(), 
				registrationDto.getLastName(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));
		
		return userRepository.save(user);
	}

	// UsernameNotFoundException is a Spring Security Exception
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
	
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	public User findById(long id) {
		return userRepository.findById(id).orElseThrow();
	}
	
	@Override
	public User findFirstRegisteredUser() {
		try {
			User user = userRepository.findById((long)1).orElseThrow();
			return user;
		} catch (NoSuchElementException e) {
			return null;
		}
	}
	
}
