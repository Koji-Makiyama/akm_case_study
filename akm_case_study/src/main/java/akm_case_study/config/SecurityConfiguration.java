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
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(
				"/registration**",
				"/js/**",
				"/css/**",
				"/img/**").permitAll() // all your non-authenticated routes
		.antMatchers("/", "/plan").authenticated().anyRequest().permitAll() // once the user is authenticated, they can go to any route including /test, e.g. if you have admin + user specific, admin will have this, not users
		// ^ 
		// user would have .authenticated().permitAll()
		// admin would have .authenticated().anyRequest().permitAll()
		// 500 error means you are trying to display something in thymeleaf/pull something from the server that isn't there
		.and()
		.formLogin()
		.loginPage("/login") // tells Spring to use my custom login.html rather than the default Spring login page 
		.permitAll() // all visitors can go to login page
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // Spring handles logout (saves you from specifying a @GetMapping for "/logout"
		//.logoutUrl("/logout") requires you to specify a @GetMapping for "/logout"
		.logoutSuccessUrl("/login?logout")
		.permitAll();
	}

}
