package akm_case_study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import akm_case_study.service.UserService;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
	
	/*
	 * This method is extremely important. It handles authorization of users to mappings before authentication (login page only), 
	 * and after authentication (all webpages). It does this by using various Spring Security methods.
	 * 
	 * It is also important to note that Spring handles logout which saves me from having to specify a @GetMapping for "/logout" in
	 * the LoginController.
	 * 
	 * loginPage("/login") tells Spring to use a custom login.html page rather than the default Spring login page.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(
				"/registration**",
				"/js/**",
				"/css/**",
				"/img/**").permitAll() // all the non-authenticated user routes
		.antMatchers("/", "/plan", "/about_me", "/cheesecake_factory", "/olive_garden", "/pf_changs").authenticated().anyRequest().permitAll() 
		.and()
		.formLogin()
		.loginPage("/login") 
		.permitAll() // all visitors can go to login page
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) 
		// if .logoutUrl("/logout") was here, it would require you to specify a @GetMapping for "/logout"
		.logoutSuccessUrl("/login?logout")
		.permitAll();
	}

}
